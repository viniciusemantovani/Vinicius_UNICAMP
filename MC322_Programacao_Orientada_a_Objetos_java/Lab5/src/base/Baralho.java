package base;
import java.util.ArrayList;
import java.util.Collections;

public class Baralho {

	private ArrayList<Carta> vetorCartas;
	
	public Baralho() {
		vetorCartas = new ArrayList<Carta>();
	}
	
	public Carta comprarCarta(){
		Carta comprado;
		comprado = vetorCartas.get(vetorCartas.size() - 1);		
		vetorCartas.remove(vetorCartas.size() - 1);
		
		return comprado;
	}
	
	public void adicionarCarta(Carta card){
		vetorCartas.add(card);
	}
	
	public void embaralhar() {
		Collections.shuffle(vetorCartas);
		int i;
		for (i = 0; i < vetorCartas.size(); i++) {
			System.out.println(vetorCartas.toArray()[i]);
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(!(obj instanceof Baralho)) return false;
		Baralho a = (Baralho) obj;
		return vetorCartas.equals(a.vetorCartas);
	}
}
