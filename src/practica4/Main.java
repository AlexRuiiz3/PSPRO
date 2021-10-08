//Cambiar la entrada y salida de un proceso
package practica4;

import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

public class Main {

	public static void main(String[] args) {
		
		try {
			
			ProcessBuilder procesoBuilder = new ProcessBuilder("cmd");
			//procesoBuilder.inheritIO();// Es lo mismo que pones procesoBuilder.redirectOutput(Redirect.INHERIT)
			procesoBuilder.redirectInput(new File("comandos.txt")); //La entrada de datos sera desde el fichero que se especifico como parametro
			
			//procesoBuilder.redirectOutput(new File(".ficheroSalida.txt")); //Para que la salida a un fichero
			procesoBuilder.redirectOutput(Redirect.INHERIT); //Para que la salida salga en la consola
			Process proceso;
			
			proceso = procesoBuilder.start(); //Se inicia el proceso
				
			} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
