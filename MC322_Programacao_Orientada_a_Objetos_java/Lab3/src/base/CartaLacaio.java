package base;
public class CartaLacaio {
	
	private int ID;
	private String nome;
	private int ataque;
	private int vidaAtual;
	private int vidaMaxima;
	private int custoMana;
	
	// Construtores:
	
	public CartaLacaio(int ID, String nome, int ataque, int vida, int mana) {
		this.ID = ID;
		this.nome = nome;
		this.ataque = ataque;
		this.vidaAtual = vida;
		this.vidaMaxima = vida;
		this.custoMana = mana;
	}
	
	// Construtor reduzido:
	
	public CartaLacaio(int ID, String nome, int mana) {
		this.ID = ID;
		this.nome = nome;
		this.custoMana = mana;
		
	}
	
	// Construtor cópia:
	
	public CartaLacaio(CartaLacaio origem) {
		this.ID = origem.ID;
		this.nome = origem.nome;
		this.ataque = origem.ataque;
		this.vidaAtual = origem.vidaAtual;
		this.vidaMaxima = origem.vidaMaxima;
		this.custoMana = origem.custoMana;
	}
	
	// Métodos gerais:
	
	public int getVidaMaxima() {
		return vidaMaxima;
	}
	
	public int getCustoMana() {
		return custoMana;
	}
	
	public int getVidaAtual() {
		return vidaAtual;
	}
	
	public int getAtaque() {
		return ataque;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getID () {
        return ID;
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public void setVidaMaxima(int vidaMaxima) {
		this.vidaMaxima = vidaMaxima;
	}
	
	public void setCustoMana(int custoMana) {
		this.custoMana = custoMana;
	}
	
	public void setVidaAtual(int vidaAtual) {
		this.vidaAtual = vidaAtual;
	}
	
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
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
