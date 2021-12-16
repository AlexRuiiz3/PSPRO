package practica3;

import java.io.IOException;
import java.util.Map;


//Un proceso abrir bloc de nota y llamar a environment que devuelve un map y mostrar lo que contiene
public class Main {

	public static void main(String[] args) {
		
		ProcessBuilder procesoBuilder = new ProcessBuilder("notepad");
		Process proceso = null;
		

			try {
				proceso = procesoBuilder.start(); //Se inicia el proceso
				
				Map<String, String> mapa = procesoBuilder.environment();//Devuelve una vista de mapa de cadenas del entorno de este generador de procesos
				
				//Con un for each se muestra un mapa
				for(Map.Entry<String, String> entry : mapa.entrySet()) {
					System.out.println("Clave: "+entry.getKey()+" 		--- Valor: "+entry.getValue());
				}
				
				proceso.destroy(); //Sirve para terminar el processo y que en este caso se cierre el bloc de notas 
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
