package actividadesSinSincronizacion;

import java.security.SecureRandom;
import java.util.ArrayList;

public class MainAct1 {

	public static void main(String[] args) {	
		ArrayList<Thread> listaHilos = new ArrayList<Thread>();
		
		for (int i = 0; i < 20; i++) {
			listaHilos.add(new Thread(new HiloAct1(generarArrayEntero())));
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
