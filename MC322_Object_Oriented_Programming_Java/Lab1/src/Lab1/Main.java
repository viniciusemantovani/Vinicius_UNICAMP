package Lab1;

public class Main {
	public static void main(String [] args) {
		
		CartaLacaio lacaio1 = new CartaLacaio(1, "ogro", 3, 4, 4);
		CartaMagia magia1 = new CartaMagia(1, "fogo", 10, true, 8);
		
		System.out.println("Primeiro lacaio :\n"+lacaio1);
		System.out.println("Primeira magia :\n"+magia1);
	}
}
