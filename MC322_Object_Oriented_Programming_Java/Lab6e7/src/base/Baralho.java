package base;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import base.cartas.Carta;
import util.Util;

public class Baralho {

	private ArrayList<Carta> vetorCartas;
	
	public Baralho() {
		vetorCartas = new ArrayList<Carta>();
	}
	
	public Carta comprar(){
		Carta comprado;
		comprado = vetorCartas.get(vetorCartas.size() - 1);		
		vetorCartas.remove(vetorCartas.size() - 1);
		
		return comprado;
	}
	
	public void adicionarCarta(Carta card){
		vetorCartas.add(card);
	}
	
	public void embaralhar() {
		Collections.shuffle(vetorCartas);
		int i;
		for (i = 0; i < vetorCartas.size(); i++) {
			System.out.println(vetorCartas.toArray()[i]);
		}
	}
	
	public void preencheAleatorio(Random gerador, int tamanho, int maxMana, int maxAtaque, int maxVida) {
		for(int i = 0; i < tamanho; i++) {
			Carta card = Util.geraCartaAleatoria(gerador, maxMana, maxAtaque, maxVida, null);
			
			vetorCartas.add(card);
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(!(obj instanceof Baralho)) return false;
		Baralho a = (Baralho) obj;
		return vetorCartas.equals(a.vetorCartas);
	}
}
