import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

import base.Carta;
import base.Lacaio;
import base.Magia;
import base.RandomStringGen;

public class Main2 {

	public static void main(String[] args) {
		
		HashSet<Carta> cartasHash = new HashSet<Carta>();
		TreeSet<Carta> cartasTreeSet = new TreeSet<Carta>();
		
		//Adicionando cartas aos Sets:
		
		for(int i = 0; i < 5000; i++) {
			
			Random gerador = new Random();
			int a = 20;
			RandomStringGen geradorString = new RandomStringGen(a);
			int ataque = gerador.nextInt(10);
			int vida = gerador.nextInt(10);
			int mana = gerador.nextInt(10);
			String nome = geradorString.nextString();
			
			Lacaio lac = new Lacaio(nome, ataque, vida, mana);
			cartasHash.add(lac);
			cartasTreeSet.add(lac);
		}
		
		for(int j = 5000; j < 10000; j++) {
			
			Random gerador = new Random();
			RandomStringGen geradorString = new RandomStringGen(20);
			int mana = gerador.nextInt(10);
			String nome = geradorString.nextString();
			String descricao = geradorString.nextString();
			
			Magia mag = new Magia(nome, mana, descricao);
			cartasHash.add(mag);
			cartasTreeSet.add(mag);
		}
		
		//Coletando e imprimindo tempos de operações desejadas:
		
		long cartasHashContains = System.nanoTime();
		
		for(Carta card : cartasHash){
			cartasHash.contains(card);
		}
		
		System.out.println("A operacao para o HashSet demorou " + (System.nanoTime() - cartasHashContains)/1000000 + " ms");
		
		long cartasTreeSetContains = System.nanoTime();
		
		for(Carta card : cartasTreeSet){
			cartasTreeSet.contains(card);
		}
		
		System.out.println("A operacao para o TreeSet demorou " + (System.nanoTime() - cartasTreeSetContains)/1000000 + " ms");
	}

}
