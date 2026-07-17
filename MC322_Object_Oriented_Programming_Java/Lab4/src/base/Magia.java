package base;

public class Magia extends Carta{
	//private int ID;
	//public String nome;
	private int dano;
	private boolean area;
	//private int custoMana;
	private String descricao;
	
	// Construtor:
	
	public Magia(String nome, int dano, boolean area, int custoMana) {
		super(nome, custoMana);
		//this.ID = ID;
		//this.nome = nome;
		this.dano = dano;
		this.area = area;
		//this.custoMana = custoMana;
	}
	
	// Métodos Gerais:
	
	//public int getID () {
      //  return ID;
	//}
	
	//public String getNome() {
	//	return nome;
	//}
	
	//public int getCustoMana() {
	//	return custoMana;
	//}
	
	public boolean getArea() {
		return area;
	}
	
	public int getDano() {
		return dano;
	}
	
	//public void setNome(String nome) {
		//this.nome = nome;
	//}
	
	//public void setCustoMana(int custoMana) {
	//	this.custoMana = custoMana;
	//}
	
	//public void setID(int ID) {
	//	this.ID = ID;
	//}
	
	public void setDano(int dano) {
		this.dano = dano;
	}
	
	public void setArca(boolean area) {
		this.area = area;
	}
	
@Override
	public String toString() {
		
		String out = super.toString();
		out = out + "Dano = "+getDano()+"\n";
		out = out + "Arca = "+getArea()+"\n";

		
		return out;
	}
	
}
