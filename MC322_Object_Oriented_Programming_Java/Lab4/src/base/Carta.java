package base;
import java.util.UUID;

public class Carta {
	
	private UUID id;
	
	private String nome;
	private int custoMana;
	
	
	public Carta(String nome, int custoMana) {
		this.id = UUID.randomUUID();
		this.nome = nome;
		this.custoMana = custoMana;
	}
	
	public String getNome() {
		
		return nome;
	}
	
	public UUID getID() {
		return id;
	}
	
	public int getCustoMana() {
		return custoMana;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCustoMana(int custoMana) {
		this.custoMana = custoMana;
	}
	
	public String toString() {
		String out = getNome()+" (ID: "+getID()+")\n";
		out = out + "Custo de Mana = "+getCustoMana()+"\n";
		
		return out;
	}
	
	private void usar(Carta alvo) {	}
	
}
