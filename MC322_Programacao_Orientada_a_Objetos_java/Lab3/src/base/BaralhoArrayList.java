package base;
import java.util.ArrayList;
import java.util.Collections;

public class BaralhoArrayList {

	private ArrayList<CartaLacaio> vetorCartas;
	
	public BaralhoArrayList() {
		vetorCartas = new ArrayList<CartaLacaio>();
	}
	
	public CartaLacaio comprarCarta(){
		CartaLacaio comprado;
		comprado = vetorCartas.get(vetorCartas.size() - 1);		
		vetorCartas.remove(vetorCartas.size() - 1);
		
		return comprado;
	}
	
	public void adicionarCarta(CartaLacaio card){
		vetorCartas.add(card);
	}
	
	public void embaralhar() {
		Collections.shuffle(vetorCartas);
		int i;
		for (i = vetorCartas.size() - 1; i > -1; i--) {
			System.out.println(vetorCartas.toArray()[i]);
		}
	}
}
