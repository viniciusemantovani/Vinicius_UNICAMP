package base;

import java.util.ArrayList;

import base.cartas.Carta;
import util.Util;

public class Mesa {
	private ArrayList<Carta> maoP;
	private ArrayList<Carta> maoS;
	private ArrayList<Carta> lacaiosP;
	private ArrayList<Carta> lacaiosS;
	private int poderHeroiP;
	private int poderHeroiS;
	private int manaP;
	private int manaS;
	
	public Mesa() {
		this.maoP = new ArrayList<Carta>();
		this.maoS = new ArrayList<Carta>();
		this.lacaiosP = new ArrayList<Carta>();
		this.lacaiosS = new ArrayList<Carta>();
		this.poderHeroiP = Util.PODER_HEROI;
		this.poderHeroiS = Util.PODER_HEROI;
		this.manaP = 1;
		this.manaS = 1;
	}
	
	public Mesa(ArrayList<Carta> maoP, ArrayList<Carta> maoS, ArrayList<Carta> lacaiosP, ArrayList<Carta> lacaiosS, int poderHeroiP, int poderHeroiS, int manaP, int manaS) {
		this.maoP = maoP;
		this.maoS = maoS;
		this.lacaiosP = lacaiosP;
		this.lacaiosS = lacaiosS;
		this.poderHeroiP = poderHeroiP;
		this.poderHeroiS = poderHeroiS;
		this.manaP = manaP;
		this.manaS = manaS;
	}
	
	public ArrayList<Carta> getMaoP(){
		return this.maoP;
	}
	
	public void setMaoP(ArrayList<Carta> maoP) {
		this.maoP.clear();
		this.maoP.addAll(maoP);
	}
	
	public ArrayList<Carta> getMaoS(){
		return this.maoS;
	}
	
	public void setMaoS(ArrayList<Carta> maoS) {	
		this.maoS.clear();
		this.maoS.addAll(maoS);
	}
	
	public ArrayList<Carta> getLacaiosP(){
		return this.lacaiosP;
	}
	
	public void setLacaiosP(ArrayList<Carta> lacaiosP) {
		this.lacaiosP.clear();
		this.lacaiosP.addAll(lacaiosP);
	}
	
	public ArrayList<Carta> getLacaiosS(){
		return this.lacaiosS;
	}
	
	public void setLacaiosS(ArrayList<Carta> lacaiosS) {
		this.lacaiosS.clear();
		this.lacaiosS.addAll(lacaiosS);
	}
	
	public int getPoderHeroiP(){
		return this.poderHeroiP;
	}
	
	public void setPoderHeroiP(int poderHeroiP) {
		this.poderHeroiP = poderHeroiP;
	}
	
	public int getPoderHeroiS(){
		return this.poderHeroiS;
	}
	
	public void setPoderHeroiS(int poderHeroiS) {
		
		this.poderHeroiS = poderHeroiS;
	}
	
	public void decPoderHeroi(int decremento, char heroi) {
		if(heroi == 'P') {
			this.setPoderHeroiP(this.getPoderHeroiP() - decremento);
		} else if(heroi == 'S') {
			this.setPoderHeroiS(this.getPoderHeroiS() - decremento);
		}
	}
	
	public int getManaP() {
		return this.manaP;
	}
	
	public void setManaP(int mana) {
		this.manaP = mana;
	}
	
	public int getManaS() {
		return this.manaS;
	}
	
	public void setManaS(int mana) {
		this.manaS = mana;
	}
	
	public void decMana(int decremento, char heroi) {
		if(heroi == 'P') {
			this.setManaP(this.getManaP() - decremento);
		} else if(heroi == 'S') {
			this.setManaS(this.getManaS() - decremento);
		}
	}
	

	public Carta sacarCarta(char jogador) {
		if(jogador == 'P') {
			Carta card = this.maoP.get(0);
			this.maoP.remove(0);
			return card;
		} else {
			Carta card = this.maoS.get(0);
			this.maoS.remove(0);
			return card;
		}
	}
}
