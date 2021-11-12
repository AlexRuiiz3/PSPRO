package actividadesSinSincronizacion;

import java.util.ArrayList;

public class MainAct2 {

	public static void main(String[] args) {	
		ArrayList<Thread> listaHilos = new ArrayList<Thread>();
		boolean hilosVivos = false;
		for (int i = 0; i < 20; i++) {
			listaHilos.add(new Thread(new HiloAct2(generarArrayEntero())));
		}		
		 for (Thread hiloAct2 : listaHilos) {
			hiloAct2.start();
		}
		 
		 try {
			Thread.sleep(60);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 
		 for (Thread hiloAct2 : listaHilos) {
			if (hiloAct2.isAlive()) {
				hilosVivos = true;
				hiloAct2.interrupt();
			}
		}
		 
		 if(hilosVivos) {
			System.out.println("Calculos no terminado ");
		 }
	}
	
	private static int[] generarArrayEntero() {
		int array[] = new int[1000000];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = (int)(Math.random()*10000+1);
		}
		
		return array;
	}
}
