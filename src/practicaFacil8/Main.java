package practicaFacil8;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		List<Thread> listaHilos = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			Thread th1 = new Thread(new Hilo(i));
			listaHilos.add(th1);
		}

		for (Thread thread : listaHilos) {
			thread.start();
		}
		
		for (Thread thread : listaHilos) {
			thread.interrupt();	
		}
	}

}
