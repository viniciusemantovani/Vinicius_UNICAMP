package util;

import java.util.Random;

import base.cartas.Carta;
import base.cartas.HabilidadesLacaio;
import base.cartas.Lacaio;
import base.cartas.TipoCarta;
import base.cartas.magias.Buff;
import base.cartas.magias.Dano;
import base.cartas.magias.DanoArea;

public class Util {
	
	public static final int PODER_HEROI = 30;
	public static final int MAX_CARDS = 30;
	public static final int MAO_INI = 7;
	
	public static void buffar(Lacaio lac, int a) {
		if(a > 0) {
			lac.setVidaAtual(lac.getVidaAtual() + a);
			lac.setVidaMaxima(lac.getVidaMaxima() + a);
			alteraNomeFortalecido(lac);
		}
	}
	
	public static void buffar(Lacaio lac, int a, int v) {
		if(a > 0 && v > 0) {
			lac.setVidaAtual(lac.getVidaAtual() + a);
			lac.setVidaMaxima(lac.getVidaMaxima() + v);
			alteraNomeFortalecido(lac);
		}
	}
	
	private static void alteraNomeFortalecido(Lacaio lac) {
		
		lac.setNome(lac.getNome() + " Buffed");
	}
	
	public static Carta geraCartaAleatoria(Random gerador, int maxMana, int maxAtaque, int maxVida, TipoCarta tc) {
		RandomString stringGerador = new RandomString(gerador, 10);
		String nome = stringGerador.nextString();
		int ataque = gerador.nextInt((maxAtaque - 1) + 1) + 1;
		int custoMana = gerador.nextInt((maxMana - 1) + 1) + 1; // vida e ataque sao usados como os aumento de buff tambem;
		int vida = gerador.nextInt((maxVida - 1) + 1) + 1; 
		Carta carta = new Carta(nome, custoMana);
		
		if(tc == null) {
			int tipoCartaDetermina = gerador.nextInt((TipoCarta.values().length - 1) + 1) + 1;

			if(tipoCartaDetermina == 1) {
				tc = TipoCarta.LACAIO;
			} else if(tipoCartaDetermina == 2) {
				tc = TipoCarta.BUFF;
			} else if(tipoCartaDetermina == 3) {
				tc = TipoCarta.DANO;
			} else {
				tc = TipoCarta.DANO_AREA;
			}
		}

		if(tc == TipoCarta.LACAIO) {

			Lacaio lac = new Lacaio(nome, ataque, vida, vida, custoMana);
			
			int lacHabilidadeDetermina = gerador.nextInt((HabilidadesLacaio.values().length - 1) + 1) + 1;
			
			if(lacHabilidadeDetermina == 1) {
				lac.setHabilidade(HabilidadesLacaio.EXAUSTAO);
			} else if(lacHabilidadeDetermina == 2) {
				lac.setHabilidade(HabilidadesLacaio.INVESTIDA);
			} else {
				lac.setHabilidade(HabilidadesLacaio.PROVOCAR);
			}
			
			return lac;
			
		} else if(tc == TipoCarta.DANO) {
			Dano mag = new Dano(nome, ataque, custoMana);
			
			return mag;
			
		} else if(tc == TipoCarta.DANO_AREA) {
			
			DanoArea mag = new DanoArea(nome, custoMana, ataque);
			
			return mag;
			
		} else if(tc == TipoCarta.BUFF) {
			
			Buff mag = new Buff(nome, custoMana, ataque, vida);
			
			return mag;
		}
		
		return carta;
	}
}
