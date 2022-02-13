package validaciones;

import java.util.Scanner;

public class Validacion {
	private static Scanner tecladoNormal = new Scanner(System.in);
	private static Scanner tecladoCadenas = new Scanner(System.in);
	
	public static int leerValidarNumeroEnteroEntreRango(int min, int max) {
		int numero = 0;
		
		if(min < max) {
			do{
				numero = tecladoNormal.nextInt();
				if (numero < min || numero > max) {
					System.out.println("Opcion ingresada no valida, vuelva a intentarlo");
				}
			}while(numero < min || numero > max);
		}
		
		return numero;
	}
	
	public static String leerValidarClaveSimetrica() {
		String claveSimetrica = "";
		int opcion;
		
		System.out.println("1) DES");
		System.out.println("2) DESede");
		System.out.println("3) AES");
		System.out.println("0) Salir");
		opcion = leerValidarNumeroEnteroEntreRango(0,3);
			
		switch(opcion) {
		case 1:
			claveSimetrica = "DES";
		break;
		
		case 2:
			claveSimetrica = "DESede";
		break;
		case 3:
			claveSimetrica = "AES";
		break;
		}
		return claveSimetrica;
	}
	
	public static String leerCadena() {
		return tecladoCadenas.nextLine();
	}
}
