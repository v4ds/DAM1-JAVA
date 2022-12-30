
public class E3X01 {

	public static long factorial = 1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int a = 1; a <= 20; a++) {
			System.out.printf("(ITERATIVO) Factorial de %2d: %20d\t",  a, calcularFactorialI(a));
			System.out.printf("(RECURSIVO) Factorial de %2d: %20d\n",  a, calcularFactorialR(a));		
		}
	}
	
	public static long calcularFactorialI(int numero) {
		long operacion = 1;
		for (int a = 1; a <= numero; a++) {
			operacion = operacion * a;
		}
		return operacion;
	}
	
	public static long calcularFactorialR(int numero) {
		if (numero != 0) {
			factorial = factorial * numero;
			return calcularFactorialR(numero - 1);
		} else {
			long resultado = factorial;
			factorial = 1;
			return resultado;
		}
	}
}
