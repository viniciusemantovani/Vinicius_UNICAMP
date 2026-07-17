package Lab1;

public class CartaMagia {
	private int ID;
	private String nome;
	private int dano;
	private boolean arca;
	private int custoMana;
	
	// Construtor:
	
	public CartaMagia(int ID, String nome, int dano, boolean arca, int custoMana) {
		this.ID = ID;
		this.nome = nome;
		this.dano = dano;
		this.arca = arca;
		this.custoMana = custoMana;
	}
	
	// Métodos Gerais:
	
	public int getID () {
        return ID;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getCustoMana() {
		return custoMana;
	}
	
	public boolean getArca() {
		return arca;
	}
	
	public int getDano() {
		return dano;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCustoMana(int custoMana) {
		this.custoMana = custoMana;
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public void setDano(int dano) {
		this.dano = dano;
	}
	
	public void setArca(boolean arca) {
		this.arca = arca;
	}
	
@Override
	public String toString() {
		String out = getNome()+" (ID: "+getID()+"\n";
		out = out + "Dano = "+getDano()+"\n";
		out = out + "Arca = "+getArca()+"\n";
		out = out + "Custo de Mana = "+getCustoMana()+"\n";
		
		return out;
	}
	
}
