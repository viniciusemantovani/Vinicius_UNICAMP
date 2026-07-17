
public class Main {

	public static void main(String[] args) {
		
		CartaLacaio lac1 = new CartaLacaio(1, "Frodo Bolseiro", 2, 1, 1);
		CartaLacaio lac2 = new CartaLacaio(2, "Aaragorn", 5, 7, 6);
		CartaLacaio lac3 = new CartaLacaio(3, "Legolas", 8, 4, 6);
		CartaLacaio lac4 = new CartaLacaio(6, "Lacaio teste", 8);
		CartaLacaio lac5 = new CartaLacaio(lac2);
		CartaMagia mag1 = new CartaMagia(4, "You shall not pass", 4, true, 7);
		CartaMagia mag2 = new CartaMagia(5, "Telecinese", 3, false, 2);
		
		lac1.setAtaque(lac3.getAtaque());		
		
		//1°
		
		System.out.println("Lacaio 4:\n"+lac4);
		
		//2°
		
		System.out.println("Lacaio 1:\n"+lac1);
		
		//3°
		
		System.out.println("Magia 1:\n"+mag1);
		
		//4°
		
		System.out.println("Lacaio 2:\n"+lac2);
		
		//5°
		
		System.out.println("Lacaio 5:\n"+lac5);
		
		//6°
		
		System.out.println(mag1.nome);
		System.out.println(mag1.getNome());
		
		//7°
		
		lac3.buffar(5);
		lac4.buffar(2);
		System.out.println("Lacaio 3:\n"+lac3);
		System.out.println("Lacaio 4:\n"+lac4);
		
		//8°
		
		lac1.buffar(5, 4);
		lac2.buffar(2, 6);
		System.out.println("Lacaio 1:\n"+lac1);
		System.out.println("Lacaio 2:\n"+lac2);
	}

}
