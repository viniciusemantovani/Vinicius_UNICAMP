package base;
public class Lacaio extends Carta{
	
	private int ataque;
	private int vidaAtual;
	private int vidaMaxima;
	
	// Construtores:
	
	public Lacaio(String nome, int ataque, int vida, int mana) {
		//this.ID = ID;
		//this.nome = nome;
		super(nome, mana);
		this.ataque = ataque;
		this.vidaAtual = vida;
		this.vidaMaxima = vida;
		//this.custoMana = mana;
	}
	
	// Construtor reduzido:
	
	public Lacaio(String nome, int mana) {
		super(nome, mana);
		
		//this.ID = ID;
		//this.nome = nome;
		//this.custoMana = mana;
		
	}
	
	// Construtor cópia:
	
	public Lacaio(Lacaio origem) {
		
		super(origem.getNome(), origem.getCustoMana());
		//this.ID = origem.ID;
		//this.nome = origem.nome;
		this.ataque = origem.ataque;
		this.vidaAtual = origem.vidaAtual;
		this.vidaMaxima = origem.vidaMaxima;
		//this.custoMana = origem.custoMana;
	}
	
	// Métodos gerais:
	
	public int getVidaMaxima() {
		return vidaMaxima;
	}
	
	//public int getCustoMana() {
	//	return custoMana;
	//}
	
	public int getVidaAtual() {
		return vidaAtual;
	}
	
	public int getAtaque() {
		return ataque;
	}
	
	//public String getNome() {
	//	return nome;
	//}
	
	//public int getID () {
    //   return ID;
	//}
	
	//public void setID(int ID) {
	//	this.ID = ID;
	//}
	
	public void setVidaMaxima(int vidaMaxima) {
		this.vidaMaxima = vidaMaxima;
	}
	
	//public void setCustoMana(int custoMana) {
	//	this.custoMana = custoMana;
	//}
	
	public void setVidaAtual(int vidaAtual) {
		this.vidaAtual = vidaAtual;
	}
	
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	
	//public void setNome(String nome) {
	//	this.nome = nome;
	//}
	
@Override
	public String toString() {
		String out = super.toString();
		out = out + "Ataque = "+getAtaque()+"\n";
		out = out + "Vida Atual = "+getVidaAtual()+"\n";
		out = out + "Vida Maxima = "+getVidaMaxima()+"\n";
		
		
		return out;
	}

	public void usar(Carta alvo) {
		Lacaio lac1 = (Lacaio) alvo;
		lac1.setVidaAtual(lac1.getVidaAtual() - this.ataque);
		
	}

//@Override
	//public String toString() {
	
		//String out = getNome()+" (ID: "+getID()+")\n";
		//out = out + "Ataque = "+getAtaque()+"\n";
	//	out = out + "Vida Atual = "+getVidaAtual()+"\n";
		//out = out + "Vida Maxima = "+getVidaMaxima()+"\n";
		//out = out + "Custo de Mana = "+getCustoMana()+"\n";
		
		//return out;
	//}
}
