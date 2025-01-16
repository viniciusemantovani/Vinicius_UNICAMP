package base.service.impl;

import java.util.Random;

import base.cartas.Carta;
import base.cartas.HabilidadesLacaio;
import base.cartas.Lacaio;
import base.cartas.TipoCarta;
import base.cartas.magias.Buff;
import base.cartas.magias.Dano;
import base.cartas.magias.DanoArea;
import base.service.CartaService;
import util.RandomString;

public class CartaServiceImpl implements CartaService{

	@Override
	public Carta geraCartaAleatoria(Random gerador, int maxMana, int maxAtaque, int maxVida, TipoCarta tc) {
		RandomString stringGerador = new RandomString(gerador, 10);
		String nome = stringGerador.nextString();
		int ataque = randInt(gerador, maxAtaque, 1);
		int custoMana = randInt(gerador, maxMana, 1); // vida e ataque sao usados como os aumento de buff tambem;
		int vida = randInt(gerador, maxVida, 1); 
									
		if(tc == null) {
			int tipoCartaDetermina = randInt(gerador, TipoCarta.values().length, 1);

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
		return null;
	}

	@Override
	public int randInt(Random gerador, int max, int min) {
		int aleatorio = gerador.nextInt((max - 1) + 1) + 1;
		return aleatorio;
	}
	
}
