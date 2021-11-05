package practica9_Basico;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		List<Thread> hilos = new ArrayList<Thread>();
		
		//Thread hilo1 = new Thread(new IA()); //Asi se crea un hilo, se asigna a la pila, como parametro necesita de un clase que implemente runnable
		
		int procesadoresDisponibles = Runtime.getRuntime().availableProcessors();
		for(int i = 0; i < procesadoresDisponibles * 2 ; i++) {
			hilos.add(new Thread(new IA(i)));
		}
		
		for (int i = 0; i < hilos.size(); i++) {
			hilos.get(i).start();
		}
		
		for (int i = 0; i < hilos.size(); i++) {
			try {
				hilos.get(i).join(); //Para esperar que acaben los hilos
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Hilos finalizados");
	}
}
