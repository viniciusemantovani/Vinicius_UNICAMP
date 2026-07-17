package base.cartas.magias;

import java.util.UUID;

import base.cartas.Carta;
import base.cartas.Lacaio;

public class Dano extends Magia{
	private int dano;
	
	public Dano(String nome, int dano, int custoMana) {
		super(nome, custoMana);
		this.dano = dano;
	}
	
	public Dano(UUID id, String nome, int custoMana, int dano) {
		super(id, nome, custoMana);
		this.dano = dano;
	}
	
	public int getDano() {
		return dano;
	}
	
	public void setDano(int dano) {
		this.dano = dano;
	}
	
	public void usar(Carta card) {
		Lacaio lac = (Lacaio) card;
		lac.setVidaAtual(lac.getVidaAtual() - this.getDano() > 0 ? lac.getVidaAtual() - this.getDano() : 0);
	}
}
