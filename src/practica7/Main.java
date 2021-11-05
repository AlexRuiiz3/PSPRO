//Ordenar vector de enteros creando 8 hilos
package practica7;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		Contenedor c = new Contenedor();


		List<Thread> listaP = new ArrayList<Thread>();
		List<Thread> listaC = new ArrayList<Thread>();;
		
		for (int i = 0; i < 5; i++) {
			listaP.add( new Thread(new Productor(c)));
		}
		for (int i = 0; i < 5; i++) {
			listaC.add( new Thread(new Consumidor(c,i)));
		}

		for (Thread p: listaP) {
			p.start();
		}
		for (Thread co: listaC) {
			co.start();
		}
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			
		}
	
		for (Thread p: listaP) {
			p.interrupt();
		}
		for (Thread co: listaC) {
			co.interrupt();
		}
		
	}
}
