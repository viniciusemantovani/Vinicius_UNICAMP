import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import base.Carta;
import base.Lacaio;
import base.Magia;
import base.RandomStringGen;

public class Main {

	public static void main(String[] args) {


		ArrayList<Carta> cartas = new ArrayList<Carta>(10000);
		LinkedList<Carta> cartasLinked = new LinkedList<Carta>();
		
		//Adicionando cartas as listas:
		
		for(int i = 0; i < 5000; i++) {
			
			Random gerador = new Random();
			int a = 20;
			RandomStringGen geradorString = new RandomStringGen(a);
			int ataque = gerador.nextInt(10);
			int vida = gerador.nextInt(10);
			int mana = gerador.nextInt(10);
			String nome = geradorString.nextString();
			
			Lacaio lac = new Lacaio(nome, ataque, vida, mana);
			cartas.add(lac);
			cartasLinked.add(lac);
		}
		
		for(int j = 5000; j < 10000; j++) {
			
			Random gerador = new Random();
			RandomStringGen geradorString = new RandomStringGen(20);
			int mana = gerador.nextInt(10);
			String nome = geradorString.nextString();
			String descricao = geradorString.nextString();
			
			Magia mag = new Magia(nome, mana, descricao);
			cartas.add(mag);
			cartasLinked.add(mag);
		}
		
		//Coletando e imprimindo tempo para as execuções desejadas:
		
		long cartasGet = System.nanoTime();
		
		for(int k = 0; k < 10000; k++) {
			cartas.get(k);
		}		
		
		System.out.println("A operacao get para a ArrayList demorou " + (System.nanoTime() - cartasGet)/1000000 + " ms");
		
		long cartasGetLinked = System.nanoTime();
		
		for(int m = 0; m < 10000; m++) {
			cartasLinked.get(m);
		}
		
		System.out.println("A operacao get para a LinkedList demorou " + (System.nanoTime() - cartasGetLinked)/1000000 + " ms");
		
		long cartasContains = System.nanoTime();
		
		for(Carta card : cartas){
			cartas.contains(card);
		}		
		
		System.out.println("A operacao contains para a ArrayList demorou " + (System.nanoTime() - cartasContains)/1000000 + " ms");
		
		long cartasContainsLinked = System.nanoTime();
		
		for(Carta card : cartasLinked){
			cartasLinked.contains(card);
		}		
		
		System.out.println("A operacao contains para LinkedList demorou " + (System.nanoTime() - cartasContainsLinked)/1000000 + " ms");
		
	}

}
