package practica1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		
		//Runtime sirve para interactuar con el proceso(hilo) actual en ejecucion
		Runtime runtime = Runtime.getRuntime();
		
		//Muestra el numero de procesadores que tiene el ordenador
		System.out.println(String.format("Numero de procesadores %d", runtime.availableProcessors()));
		
		//Muestra el numero de memoria que tiene el ordenador disponible 
		System.out.println(String.format("Memoria disponible %d", runtime.freeMemory()));
		
		//Muestra la memoria maxima que tiene el ordenador 
		System.out.println(String.format("Memoria mazima %d", runtime.maxMemory()));
		
		//Muestra la memoria total que tiene el ordenador 
		System.out.println(String.format("Memoria mazima %d", runtime.totalMemory()));
		
	
		try {
			//Para ejecutar comnados
			Process ejecucionComando = runtime.exec("cmd /c dir"); //Creamos un proceso nuevo
			
			ejecucionComando.waitFor();//Esperamos a que termine
			
			BufferedReader br = new BufferedReader(new InputStreamReader(ejecucionComando.getInputStream()));
			String linea = "";
			
			while((linea = br.readLine()) != null) {
				
				System.out.println(linea);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) { //La genera el waitfor
			e.printStackTrace();
		}
		
	}

}
