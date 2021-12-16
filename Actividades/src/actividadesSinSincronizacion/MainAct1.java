package actividadesSinSincronizacion;

import java.security.SecureRandom;
import java.util.ArrayList;

public class MainAct1 {

	public static void main(String[] args) {	
		ArrayList<Thread> listaHilos = new ArrayList<Thread>();
		int contPrioridad = 10;

		for (int i = 0; i < 25; i++) {
			Thread hilo = new Thread(new HiloAct1(generarArrayEntero()));
			if(i < contPrioridad) {
				hilo.setPriority(Thread.MAX_PRIORITY);
			}
			listaHilos.add(hilo);
		}
		
		 for (Thread hiloAct1 : listaHilos) {
			hiloAct1.start();
		}
	}
	
	private static int[] generarArrayEntero() {
		SecureRandom r = new SecureRandom();
		int array[] = new int[1000000];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(10000 + 1);
		}
		
		return array;
	}
}
