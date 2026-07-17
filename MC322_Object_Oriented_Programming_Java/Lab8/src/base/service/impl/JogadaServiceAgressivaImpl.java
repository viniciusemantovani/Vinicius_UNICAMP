	package base.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import base.Jogada;
import base.Mesa;
import base.cartas.Carta;
import base.cartas.Lacaio;
import base.cartas.magias.Dano;
import base.service.JogadaService;

public class JogadaServiceAgressivaImpl implements JogadaService{
	
	public class DanoComparator implements Comparator<Carta> {

		@Override
		public int compare(Carta o1, Carta o2) {
			Dano dano1 = (Dano) o1;
			Dano dano2 = (Dano) o2;
			
			return Integer.compare(dano1.getDano(), dano2.getDano());
		}
		
	}
	
	public class LacaioComparator implements Comparator<Carta> {
		
		@Override
		public int compare(Carta o1, Carta o2) {
			Lacaio lacaio1 = (Lacaio) o1;
			Lacaio lacaio2 = (Lacaio) o2;
			
			return Integer.compare(lacaio1.getAtaque(), lacaio2.getAtaque());
		}
	}
	
	public JogadaServiceAgressivaImpl(){
		
	}
	
	public List<Jogada> criaJogada(Mesa mesa, char primeiroJogador){
		
		ArrayList<Jogada> jogadas = new ArrayList<Jogada>();
		ArrayList<Carta> lacaios = new ArrayList<Carta>();
		ArrayList<Carta> magia = new ArrayList<Carta>();
		DanoComparator comparadorDano = new DanoComparator();
		LacaioComparator comparadorLacaio = new LacaioComparator();
		
		
		for(Carta card : (primeiroJogador == 'P' ? mesa.getMaoP() : mesa.getMaoS())) {
			if(card instanceof Dano) {
				magia.add(card);
			} else if(card instanceof Lacaio){
				lacaios.add(card);
			}
		}
		
		Collections.sort(magia, comparadorDano);
		Collections.reverse(magia);
		Collections.sort(lacaios, comparadorLacaio);
		Collections.reverse(lacaios);
		
		for(Carta card : lacaios) {
			if((primeiroJogador == 'P' ? mesa.getManaP() : mesa.getManaS()) >= card.getCustoMana()) {
				Lacaio lacaio = (Lacaio) card;
				Jogada jog = new Jogada(lacaio, null, primeiroJogador == 'P' ? 'P' : 'S');
				jogadas.add(jog);
				if(primeiroJogador == 'P') {
					mesa.setManaP(mesa.getManaP() - lacaio.getCustoMana());;
					mesa.getMaoP().remove(card);
				} else {
					mesa.setManaS(mesa.getManaS() - lacaio.getCustoMana());
					mesa.getMaoS().remove(card);
				}
			}
		}
		
		for(Carta card : magia) {
			Dano dano = (Dano) card;
			if((primeiroJogador == 'P' ? mesa.getManaP() : mesa.getManaS()) >= card.getCustoMana()) {
				
				Jogada jog = new Jogada(dano, null, primeiroJogador == 'P' ? 'P' : 'S');
				jogadas.add(jog);
				if(primeiroJogador == 'P') {
					mesa.setManaP(mesa.getManaP() - dano.getCustoMana());;
					mesa.getMaoP().remove(card);
				} else {
					mesa.setManaS(mesa.getManaS() - dano.getCustoMana());
					mesa.getMaoS().remove(card);
				}
			}
		}
		
		return jogadas;
	}
	
}
