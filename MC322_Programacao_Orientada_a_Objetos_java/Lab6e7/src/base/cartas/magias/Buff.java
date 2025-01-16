package base.cartas.magias;

import java.util.UUID;

import base.cartas.Carta;
import base.cartas.Lacaio;

public class Buff extends Magia{
private int aumentoEmAtaque;
private int aumentoEmVida;

	public Buff(UUID id, String nome, int custoMana, int aumentoEmAtaque, int aumentoEmVida){
		super(id, nome, custoMana);
		this.aumentoEmAtaque = aumentoEmAtaque;
		this.aumentoEmVida = aumentoEmVida;
	}
	
	public Buff(String nome, int custoMana, int aumentoEmAtaque, int aumentoEmVida) {
		super(nome, custoMana);
		this.aumentoEmAtaque = aumentoEmAtaque;
		this.aumentoEmVida = aumentoEmVida;
	}
	
	public int getAumentoEmAtaque(){
		return this.aumentoEmAtaque;
	}
	
	public int getAumentoEmVida() {
		return this.aumentoEmVida;
	}
	
	public void setAumentoEmAtaque(int aumentoEmAtaque) {
		this.aumentoEmAtaque = aumentoEmAtaque;
	}
	
	public void setAumentoEmVida(int aumentoEmVida) {
		this.aumentoEmVida = aumentoEmVida;
	}
	
	public void usar(Carta card) {
		Lacaio lac = (Lacaio) card;
		lac.setVidaAtual(lac.getVidaAtual() + this.getAumentoEmVida());
		lac.setVidaMaxima(lac.getVidaMaxima() + this.getAumentoEmVida());
		lac.setAtaque(lac.getAtaque() + this.aumentoEmAtaque);
	}
	
	public String toString(){
		return "nome: " + this.getNome()+ "ID: " + this.getID() +"\n" + "Custo de Mana: " +
					this.getCustoMana() + "\n" + "Aumento em Vida: " + this.getAumentoEmVida() + "\n" + 
					"Aumento em Ataque: " + this.getAumentoEmAtaque();
	}
}
