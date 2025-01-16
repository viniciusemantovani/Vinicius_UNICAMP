package base;

import base.cartas.Carta;

public class Jogada {

	private Carta jogada;
	private Carta alvo;
	private char autor;
	
	public Jogada(Carta jogada, Carta alvo, char autor) {
		this.jogada = jogada;
		this.alvo = alvo;
		this.autor = autor;
	}
	
	public Carta getJogada() {
		return this.jogada;
	}
	
	public void setJogada(Carta jogada){
		this.jogada = jogada;
	}
	
	public Carta getAlvo() {
		return this.alvo;
	}
	
	public void setAlvo(Carta alvo) {
		this.alvo = alvo;
	}
	
	public char getAutor() {
		return this.autor;
	}
	
	public void setAutor(char autor) {
		this.autor = autor;
	}
	
	public String toString() {
		
		String out = "Autor da jogada: " + this.autor + "\n"
				+ "Carta jogada ou Carta atacante: " + this.jogada + "/n"
				+ "Alvo: "	+ this.alvo;			

		return out;
	}
}
