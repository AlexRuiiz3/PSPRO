package principal;

import gestoras.GestoraClave;
import gestoras.GestoraDesencriptar;
import gestoras.GestoraEncriptar;
import validaciones.Validacion;

public class Main {

	public static void main(String[] args) {
		int opcion;
		
		do {
		System.out.println("Que operacion desea realiar");
		System.out.println("1)Generar clave");
		System.out.println("2)Encriptar");
		System.out.println("3)Desencriptar");
		System.out.println("0)Salir");
		opcion = Validacion.leerValidarNumeroEnteroEntreRango(0, 3);
		
		switch(opcion) {
		case 1:
			GestoraClave.genenarClave();
		break;
		
		case 2:
			GestoraEncriptar.encriptar();
		break;
		
		case 3:
			GestoraDesencriptar.desencriptar();
		break;
		}
		
		}while(opcion != 0);
	}
}
