package navidades_ejercicios;

import entrada.Teclado;

public class romanos {
	
	// start pasar a arabiga
	public static int devolverNumero(char caracter) {
		switch (caracter) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		}
		return -1;
	}
	
	public static int obtenerBase(char caracter) {
		int base = 0;
		if (caracter == 'V' || caracter == 'L' || caracter == 'D' ) {
			base = 5;
		}

		if (caracter == 'I' || caracter == 'X' || caracter == 'C' || caracter == 'M' ) {
			base = 10;
		}
		
		return base;
	}
	
	public static boolean esValido(String cadena) {
		int cuenta = 0;
		
		for (int i = 0; i < cadena.length() - 1; i++) {
			char caracter = cadena.charAt(i);
			char sigcaracter = cadena.charAt(i + 1);
			
			if (obtenerBase(caracter) == 10 && caracter == sigcaracter) {
				cuenta = cuenta + 1;
			} else if (obtenerBase(caracter) == 10 && caracter != sigcaracter) {
				cuenta = 0;
			}
			
			if (obtenerBase(caracter) == 5 && caracter == sigcaracter) {
				return false;
			} else if (obtenerBase(caracter) == 10 && caracter == sigcaracter && cuenta > 2) {
				return false;
			}
			
			if (caracter < 10 && devolverNumero(sigcaracter) > 10) {
				return false;
			}
		}
		return true;
	}
	
	public static int calcularArabiga(String cadena) {
		int resultado = 0;
		if (esValido(cadena)) {
			if (devolverNumero(cadena.charAt(0)) >= devolverNumero(cadena.charAt(1))) {
				resultado = devolverNumero(cadena.charAt(0));
			}
			
			for (int i = 0; i < cadena.length() - 1; i++) {
				char caracter = cadena.charAt(i);
				char sigcaracter = cadena.charAt(i + 1);
				
				if (devolverNumero(caracter) < devolverNumero(sigcaracter)) {
					resultado = resultado + (devolverNumero(sigcaracter) - devolverNumero(caracter));
				} else {
					resultado = resultado + devolverNumero(sigcaracter);
				}
			}
		} else {			
			resultado = -1;
		}
		return resultado;
	}
	
	// fin pasar a arabiga

	// calcular romano
	public static String calcularRomano(int numero) {
		String resultado = "";
		
		do {
			if (numero >= 1000) {
				resultado += "M";
				numero = numero - 1000;
			} else if (numero >= 900) {
				resultado += "CM";
				numero = numero - 900;
			} else if (numero >= 500) {
				resultado += "D";
				numero = numero - 500;
			} else if (numero >= 400) {
				resultado += "CD";
				numero -= 400;
			} else if (numero >= 100) {
				resultado += "C";
				numero = numero - 100;
			} else if (numero >= 50) {
				resultado += "L";
				numero = numero - 50;
			} else if (numero >= 40) {
				resultado += "XL";
				numero -= 40;
			} else if (numero >= 10) {
				resultado += "X";
				numero = numero - 10;
			} else if (numero == 9) {
				numero = numero - 9;
				resultado += "IX";
			} else if (numero >= 5) {
				numero = numero - 5;
				resultado += "V";
			} else if (numero == 4) {
				resultado += "IV";
				numero = numero - 4;
			} else if (numero <= 3) {
				numero = numero - 1;
				resultado += "I";
			}
		} while (numero > 0);
		
		return resultado;
	}
	
	public static void generarMenu() {
		System.out.println("-----------------------------------------");
		System.out.println(" 1) Pasar numero Arabigo a romano");
		System.out.println(" 2) Pasar numero Romano a aragibo");
		System.out.println(" 0) Salir");
		System.out.println("-----------------------------------------");
	}
	
	public static void main(String[] args) {
		int opcion = 1;
		do {
			System.out.println();
			generarMenu();
			opcion = Teclado.leerEntero("-> ");
			switch (opcion) {
			case 0:
				break;
			case 1:
				int numero = Teclado.leerEntero("Inserta un numero Arabigo > ");
				System.out.println("Conversion : " + calcularRomano(numero));
				break;
			case 2:
				String romano = Teclado.leerCadena("Inserta un numero Romano > ");
				System.out.println("Conversion : " + calcularArabiga(romano));
				break;
			case 3:
				break;
			default:
				System.err.println("Unicamente existen 3 opciones!");
				break;
			}	
		} while (opcion > 0);
	}
}
