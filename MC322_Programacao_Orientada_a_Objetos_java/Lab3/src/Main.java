import base.CartaLacaio;
import base.Baralho;
import base.BaralhoArrayList;
import util.Util;

public class Main {

	public static void main(String[] args) {
		CartaLacaio lac1 = new CartaLacaio(9, "lacaio1", 5, 3, 4);
		CartaLacaio lac2 = new CartaLacaio(5, "lacaio2", 7, 1, 2);
		CartaLacaio lac3 = new CartaLacaio(8, "lacaio3", 3, 8, 9);
		
		Baralho bar1 = new Baralho();
		BaralhoArrayList bar2 = new BaralhoArrayList();
		bar1.adicionarCarta(lac1);
		bar1.adicionarCarta(lac2);
		bar1.adicionarCarta(lac3);
		//Teste tarefa 1:
		//bar1.adicionarCarta(lac1);
		//bar1.adicionarCarta(lac2);
		//bar1.adicionarCarta(lac3);
		//bar1.adicionarCarta(lac1);
		//bar1.adicionarCarta(lac2);
		//bar1.adicionarCarta(lac3);
		//bar1.adicionarCarta(lac1);
		//bar1.adicionarCarta(lac2);
		//bar1.adicionarCarta(lac3);
		//bar1.adicionarCarta(lac1);
		//bar1.adicionarCarta(lac2);
		//bar1.adicionarCarta(lac3);
		bar2.adicionarCarta(lac1);
		bar2.adicionarCarta(lac2);
		bar2.adicionarCarta(lac3);
		
		//bar1.embaralhar();
		bar2.embaralhar();
		
		System.out.println(bar2.comprarCarta());
		
		Util.buffar(lac1, 10);
		Util.buffar(lac2, 5, 6);
		
		System.out.println(lac1);
		System.out.println(lac2);
		
		//Tarefa 2°:
		//bar1.comprarCarta();
		
		
	}

}
