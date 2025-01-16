package base;

import java.util.ArrayList;

import base.cartas.Carta;
import base.cartas.HabilidadesLacaio;
import base.cartas.Lacaio;
import base.cartas.magias.Buff;
import base.cartas.magias.Dano;
import base.cartas.magias.DanoArea;
import java.util.Iterator;

public class ProcessadorJogada {
	
	public ProcessadorJogada(){
		
	}
	
	public static void processar(Jogada jog, Mesa mesa) {
		
		System.out.println("Autor da jogada: " + jog.getAutor() + "\n" 
				+ "Carta da jogada: ID: " + jog.getJogada().getID() + " Nome: " + jog.getJogada().getNome() + "\n"
				+ "Carta alvo: " + " ID: " + (jog.getAlvo() != null ? jog.getAlvo().getID() : "Heroi") + " Nome: " + (jog.getAlvo() != null ? jog.getAlvo().getNome() : "Heroi") + "\n"
				+ "Numero de lacaios do adversário " + (jog.getAutor() == 'P' ? mesa.getLacaiosS().size() : mesa.getLacaiosP().size())
				+ "\nLacaios do oponente:\n" + "Nome ; ID");
		for(Carta card : (jog.getAutor() == 'P' ? mesa.getLacaiosS() : mesa.getLacaiosP())) {
			System.out.println(card.getNome() + " ; " + card.getID());
		}
		
		System.out.println("Poder heroico adversário: " + (jog.getAutor() == 'P' ? mesa.getPoderHeroiS() : mesa.getPoderHeroiP()));
		
		if(jog.getAutor() == 'P') {
			mesa.setManaP(mesa.getManaP() - jog.getJogada().getCustoMana());
		} else {
			mesa.setManaS(mesa.getManaS() - jog.getJogada().getCustoMana());
		}
		
		if(jog.getJogada() instanceof DanoArea) {
			//System.out.println("\n Area \n");
			DanoArea mag = (DanoArea) jog.getJogada();
			//System.out.println(mag.getDano());
			
			if(jog.getAutor() == 'P') {
				
				mag.usar(mesa.getLacaiosS());
				mesa.setPoderHeroiS(mesa.getPoderHeroiS() - mag.getDano());
				
			} else {
				
				mag.usar(mesa.getLacaiosP());
				mesa.setPoderHeroiP(mesa.getPoderHeroiP() - mag.getDano());
			}
			
		} else if(jog.getJogada() instanceof Dano) {
			//System.out.println("\n Dano \n");
			Dano mag = (Dano) jog.getJogada();
			//System.out.println(mag.getDano());
			//System.out.println(jog.getAlvo() != null ? jog.getAlvo().getNome() : "heroi");
			
			if(jog.getAutor() == 'P' && jog.getAlvo() == null) {
				
				mesa.setPoderHeroiS(mesa.getPoderHeroiS() - mag.getDano());
				
			} else if(jog.getAutor() == 'S' && jog.getAlvo() == null) {
				
				mesa.setPoderHeroiP(mesa.getPoderHeroiP() - mag.getDano());

			}
			
			if(jog.getAlvo() != null) {
				Lacaio lacAlvo = (Lacaio) jog.getAlvo();

				if(lacAlvo.getHabilidade() == HabilidadesLacaio.PROVOCAR) {
					
					mag.usar(lacAlvo);
					
				} else {
					
					int verificaProvocar = 0; // se for 1 ja foi atacado o que tem provocar;
					
					for(Carta card : mesa.getLacaiosS()) {
						
						Lacaio lac = (Lacaio) card;
						
						if(lac.getHabilidade() == HabilidadesLacaio.PROVOCAR) {
							
							mag.usar(lac);
							verificaProvocar = 1;
							break;
			
						}
					}
					
					if(verificaProvocar == 0) {
						
						mag.usar(lacAlvo);						
					}
				}
			}
		} else if (jog.getJogada() instanceof Buff) {
			//System.out.println("\n Buff \n");

			Buff mag = (Buff) jog.getJogada();
			
			if(jog.getAlvo() instanceof Lacaio) {
				Lacaio lac = (Lacaio) jog.getAlvo();
				
				mag.usar(lac);
				
			}
		} else {
			Lacaio lac = (Lacaio) jog.getJogada();
			
			if(jog.getAutor() == 'P') {
				
				if(lac.getHabilidade() == HabilidadesLacaio.EXAUSTAO || lac.getHabilidade() == HabilidadesLacaio.PROVOCAR) {
					//System.out.println("\n Lac \n");

					ArrayList<Carta> cartas = new ArrayList<Carta>();
					cartas.addAll(mesa.getLacaiosP());
					cartas.add(lac);
					mesa.setLacaiosP(cartas);
					if(lac.getHabilidade() == HabilidadesLacaio.EXAUSTAO) {
						lac.setHabilidade(HabilidadesLacaio.INVESTIDA);
					}
				} else {
					//System.out.println("\n Lac inv \n");
					//System.out.println(lac.getAtaque());
					//System.out.println(jog.getAlvo() != null ? jog.getAlvo() : "heroi");
					
					if(jog.getAlvo() != null) {
						lac.usar(jog.getAlvo());
					} else {
						mesa.setPoderHeroiS(mesa.getPoderHeroiS() - lac.getAtaque());
					}					
					ArrayList<Carta> cartas = new ArrayList<Carta>();
					cartas.addAll(mesa.getLacaiosP());
					cartas.add(lac);
					mesa.setLacaiosP(cartas);
				}
				
			} else {
				if(lac.getHabilidade() == HabilidadesLacaio.EXAUSTAO || lac.getHabilidade() == HabilidadesLacaio.PROVOCAR) {
					//System.out.println("\n Lac \n");
					
					ArrayList<Carta> cartas = new ArrayList<Carta>();
					cartas.addAll(mesa.getLacaiosP());
					cartas.add(lac);
					mesa.setLacaiosS(cartas);
					if(lac.getHabilidade() == HabilidadesLacaio.EXAUSTAO) {
						lac.setHabilidade(HabilidadesLacaio.INVESTIDA);
					}
				} else {
					
					/*System.out.println("\n Lac inv \n");
					System.out.println(lac.getAtaque());
					System.out.println(jog.getAlvo() != null ? jog.getAlvo() : "heroi");*/
					if(jog.getAlvo() != null) {
						lac.usar(jog.getAlvo());
					} else {
						mesa.setPoderHeroiP(mesa.getPoderHeroiP() - lac.getAtaque());
					}	
					ArrayList<Carta> cartas = new ArrayList<Carta>();
					cartas.addAll(mesa.getLacaiosP());
					cartas.add(lac);
					mesa.setLacaiosS(cartas);				
				}
			}
		}
		
		
		for(Iterator<Carta> it = mesa.getLacaiosP().iterator(); it.hasNext(); ) {
			Lacaio aux = (Lacaio) it.next();
			if(aux.getVidaAtual() <= 0) {
				it.remove();
				
			}
		}
		
		for(Iterator<Carta> it = mesa.getLacaiosS().iterator(); it.hasNext(); ) {
			Lacaio aux = (Lacaio) it.next();
			if(aux.getVidaAtual() <= 0) {
				it.remove();
			}
		}
				
		System.out.println("Número de lacaios do oponente: " + (jog.getAutor() == 'P' ? mesa.getLacaiosS().size() : mesa.getLacaiosP().size()) 
				+ "\n" + "Nome ; ID");
		
		for(Carta card : (jog.getAutor() == 'P' ? mesa.getLacaiosS() : mesa.getLacaiosP())) {
			System.out.println(card.getNome() + " ; " + card.getID());
		}
	}
}
