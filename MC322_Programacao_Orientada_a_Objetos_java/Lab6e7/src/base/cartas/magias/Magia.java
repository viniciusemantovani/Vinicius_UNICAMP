package base.cartas.magias;

import java.util.UUID;

import base.cartas.Carta;

public class Magia extends Carta{
	
	// Construtor:
	
	public Magia(UUID id, String nome, int custoMana) {
		super(id ,nome, custoMana);
	}
	
	public Magia(String nome, int custoMana) {
		super(nome, custoMana);
	}
	
@Override
	public String toString() {
		
		String out = super.toString();
		
		return out;
	}
	
}
