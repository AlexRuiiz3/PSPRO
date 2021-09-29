package practica2;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

//Un proceso abrir bloc de nota y tienes un maxido de 30 segundos para crear un txt hola y ver si existe o no 
public class Main {

	public static void main(String[] args) {
		
		ProcessBuilder procesoBuilder = new ProcessBuilder("notepad");
		Process proceso = null;
		

			try {
				proceso = procesoBuilder.start(); //Se inicia el proceso
				
				proceso.waitFor(10, TimeUnit.SECONDS); //Se espera el tiempo que indique
				
				File file = new File("C:\\Users\\aruiz\\Documents\\GitHub\\PSPRO\\Hola2.txt");
				
				if(file.exists()) {
					System.out.println("Existe el fichero");
				}else {
					System.out.println("No existe el fichero2");
				}
				
				proceso.destroy(); //Sirve para terminar el processo y que en este caso se cierre el bloc de notas 
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		
	}

}


