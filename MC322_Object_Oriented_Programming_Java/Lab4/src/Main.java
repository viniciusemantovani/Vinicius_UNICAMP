import base.Baralho;
import base.Lacaio;
import base.Magia;

public class Main {

	public static void main(String[] args) {
		
		Lacaio lac1 = new Lacaio("lac1", 5, 3, 8);
		Lacaio lac2 = new Lacaio("lac2", 2, 7, 4);
		Lacaio lac3 = new Lacaio("lac3", 9, 6, 1);
		Lacaio lac4 = new Lacaio("lac4", 4, 5, 2);
		Magia mag1 = new Magia("mag1", 8, true, 5);
		Magia mag2 = new Magia("mag2", 5, false, 2);
		Magia mag3 = new Magia("mag3", 6, true, 4);
		Baralho bar1 = new Baralho();
		
		bar1.adicionarCarta(lac1);
		bar1.adicionarCarta(lac2);
		bar1.adicionarCarta(lac3);
		bar1.adicionarCarta(lac4);
		bar1.adicionarCarta(mag1);
		bar1.adicionarCarta(mag2);
		bar1.adicionarCarta(mag3);

		bar1.embaralhar();
	}

}
