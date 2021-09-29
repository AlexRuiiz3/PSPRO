package practica2;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

//cada 5 segundo comprobar si esta el proceso vivo y en consola mostrar Proceso en ejecucion
public class MainModificado {
	
	public static void main(String[] args) {
			
			ProcessBuilder procesoBuilder = new ProcessBuilder("notepad"); //Se prepara el proceso del bloc de notas
			Process proceso = null;
	
				try {
					
					proceso = procesoBuilder.start(); //Se inicia el proceso del bloc de notas
					
					while(proceso.isAlive()) {//Se comprueba que el proceso del bloc de notas este vivo
						System.out.println("El proceso esta vivo");	
						Thread.sleep(5000);
					}

					proceso.destroy(); //Sirve para terminar el processo y que en este caso se cierre el bloc de notas 
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
			
	}
	
}
