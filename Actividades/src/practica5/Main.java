package practica5;

import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

public class Main {

	public static void main(String[] args) {
		
			ProcessBuilder procesoBuilder1 = new ProcessBuilder("cmd");
			ProcessBuilder procesoBuilder2 = new ProcessBuilder("cmd");
			ProcessBuilder procesoBuilder3 = new ProcessBuilder("cmd");
			
			
			
			procesoBuilder1.redirectInput(Redirect.INHERIT); 
			
			
			procesoBuilder1.redirectOutput(Redirect.INHERIT); 
			
			/*Process proceso;
			
			proceso = procesoBuilder1.start(); //Se inicia el proceso
				*/

	}

}
