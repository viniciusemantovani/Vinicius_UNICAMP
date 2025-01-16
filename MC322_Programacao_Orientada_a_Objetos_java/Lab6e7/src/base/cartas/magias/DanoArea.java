package base.cartas.magias;

import java.util.List;
import java.util.UUID;

import base.cartas.Carta;
import base.cartas.Lacaio;

public class DanoArea extends Dano{
	
	public DanoArea(String nome, int custoMana, int dano) {
		super(nome, dano, custoMana);
	}
	
	public DanoArea(UUID id, String nome, int custoMana, int dano) {
		super(id, nome, custoMana, dano);
	}
	
	public void usar(List<Carta> cards) {
		for(Carta card : cards) {
			Lacaio lac = (Lacaio) card;
			lac.setVidaAtual(lac.getVidaAtual() - this.getDano() > 0 ? lac.getVidaAtual() - this.getDano() : 0);
		}
	}
}
