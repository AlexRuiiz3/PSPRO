package ejercicio2;

import java.util.ArrayList;
import java.util.List;


public class Main {

	private final static int NUMERO_HILOS = 10;
	
	public static void main(String[] args) {
		List<Thread> hilos = crearHilos();
		
		iniciarHilos(hilos);
	}
	
	private static List<Thread> crearHilos(){
		Tarjeta tarjeta = new Tarjeta();
		List<Thread> hilos = new ArrayList<Thread>();
		
		for(int i = 0; i < NUMERO_HILOS; i++) {
			hilos.add(new Thread(new Hilo(tarjeta)));
		}
		
		return hilos;
	}
	
	private static void iniciarHilos(List<Thread> hilos){
		for(Thread hilo :hilos) {
			hilo.start();
		}
	}
}
