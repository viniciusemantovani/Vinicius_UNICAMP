package base.cartas;

import java.util.UUID;

import base.Mesa;

public class Lacaio extends Carta{
	
	private int ataque;
	private int vidaAtual;
	private int vidaMaxima;
	private HabilidadesLacaio habilidade;
	
	// Construtores:
	
	public Lacaio(String nome, int ataque, int vidaMaxima,int vidaAtual, int mana) {
		super(nome, mana);
		this.ataque = ataque;
		this.vidaAtual = vidaAtual;
		this.vidaMaxima = vidaMaxima;
	}
			
	public Lacaio(String nome, int ataque, int vidaMaxima,int vidaAtual, int mana, HabilidadesLacaio habilidade) {
		super(nome, mana);
		this.ataque = ataque;
		this.vidaAtual = vidaAtual;
		this.vidaMaxima = vidaMaxima;
		this.habilidade = habilidade;
		
	}
	
	public Lacaio(UUID id, String nome, int mana, int ataque, int vidaMaxima, int vidaAtual) {
		super(id, nome, mana);
		this.ataque = ataque;
		this.vidaAtual = vidaAtual;
		this.vidaMaxima = vidaMaxima;
	}	
	
	// Métodos gerais:
	
	public int getVidaMaxima() {
		return vidaMaxima;
	}
	
	public int getVidaAtual() {
		return vidaAtual;
	}
	
	public int getAtaque() {
		return ataque;
	}
	
	public void setVidaMaxima(int vidaMaxima) {
		this.vidaMaxima = vidaMaxima;
	}
	
	public void setVidaAtual(int vidaAtual) {
		this.vidaAtual = vidaAtual;
	}
	
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	
	public HabilidadesLacaio getHabilidade() {
		return this.habilidade;
	}
	
	public void setHabilidade(HabilidadesLacaio habilidade) {
		this.habilidade = habilidade;
	}
	


	public void usar(Carta alvo) {
		Lacaio lac1 = (Lacaio) alvo;
		lac1.setVidaAtual(lac1.getVidaAtual() - this.ataque > 0 ? lac1.getVidaAtual() - this.ataque : 0);
		this.setVidaAtual((this.getVidaAtual() - lac1.getAtaque()) > 0 ? this.getVidaAtual() - lac1.getAtaque() : 0);
		
	}

@Override
	public String toString() {
	
		String out = getNome()+" (ID: "+getID()+")\n";
		out = out + "Ataque = "+getAtaque()+"\n";
		out = out + "Vida Atual = "+getVidaAtual()+"\n";
		out = out + "Vida Maxima = "+getVidaMaxima()+"\n";
		out = out + "Custo de Mana = "+getCustoMana()+"\n";
		
		return out;
	}
}
