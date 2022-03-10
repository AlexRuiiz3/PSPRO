package validacion;

import java.util.Scanner;

public class Validacion {

	private static Scanner tecladoCadenas = new Scanner(System.in);

	
	public static String leerCadena() {
		return tecladoCadenas.nextLine();
	}

	public static String leerValidarCadenaVacia() {
		String cadena = "";
		
		do {
			cadena = tecladoCadenas.nextLine();
			if(cadena.trim().isEmpty()) {
				System.out.println("La cadena no puede estar vacia");
			}
		}while(cadena.trim().isEmpty());
		
		return cadena;
	}
	
	
	public static void cerrarTecladoCadenas() {
		tecladoCadenas.close();
	}

}
