package ejerciciosP5;

import java.util.Scanner;

public class E5X03A {

	public static void main(String[] args) {
		int altura;
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("¿Altura Triangulo? ");
		altura = teclado.nextInt();
		
		for (int a = 0; a < altura; a++) {
			for (int j = a; j < altura; j++) {
				System.out.print(" ");
				for (int x = j; j < altura; x++) {
					System.out.print("*");
				}
			}
			System.out.print("\n");
		}
	}

}
