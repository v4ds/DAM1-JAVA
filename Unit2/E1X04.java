package P1;

public class E1X04 {
	
	public static void main(String[] args) {
		for (int a = 2; a <= 6; a++) {
			for (int b= 1; b < 10; b++) {
				System.out.printf("%d ^ %d = %d", b, a, elevar(b, a));
				System.out.print(", ");
			}
			System.out.print("\n");
		}
	}

	public static int elevar(int base, int exponente) {
		int operacion = 1;
		for (int a = 0; a < exponente; a++) {
			operacion = operacion * base; 
		}
		return operacion;
	}
}
