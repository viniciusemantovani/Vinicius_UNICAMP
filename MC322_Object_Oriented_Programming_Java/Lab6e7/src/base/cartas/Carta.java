package base.cartas;
import java.util.Objects;
import java.util.UUID;

public class Carta /*#implements Comparable*/{
	
	private UUID id;
	
	private String nome;
	private int custoMana;
	
	
	public Carta(UUID id, String nome, int custoMana) {
		this.id = id;
		this.nome = nome;
		this.custoMana = custoMana;
	}
	
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
	
	public int compareTo(Object c) {
		if(equals(c)) {
			return 0;
		} else {
			return 1;
		}
	}
	
	public void usar(Carta alvo) {	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nome, id, custoMana);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(!(obj instanceof Carta)) return false;
		Carta a = (Carta) obj;
		if(nome == null || a.nome == null) return false;
		return id == a.id && nome.equals(a.nome) && custoMana == a.custoMana;
	}
}
