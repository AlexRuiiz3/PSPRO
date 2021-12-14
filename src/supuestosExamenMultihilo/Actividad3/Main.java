package supuestosExamenMultihilo.Actividad3;

import java.util.ArrayList;
import java.util.List;

public class Main {

	private final static int NUMERO_HILOS = 10;
	
	public static void main(String[] args) {
		List<Thread> hilos = crearHilos();
		iniciarHilos(hilos);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if(comprobarFinalizacionHilos(hilos)) {
			System.out.println("Han finalizado");
		}else {
			System.out.println("No han finalizado");
		}
	}
	
	private static List<Thread> crearHilos(){
		List<Thread> hilos = new ArrayList<Thread>();
		
		for(int i = 0; i < NUMERO_HILOS; i++) {
			hilos.add(new Thread(new Hilo()));
		}
		
		return hilos;
	}
	
	private static void iniciarHilos(List<Thread> hilos){
		for(Thread hilo :hilos) {
			hilo.start();
		}
	}

	private static boolean comprobarFinalizacionHilos(List<Thread> hilos){
		boolean hanFinalizado = true;
		
		for(int i = 0; i < hilos.size() && hanFinalizado; i++) {
			if(hilos.get(i).isAlive()) {
				hanFinalizado = false;
			}
		}		
		return hanFinalizado;
	}
}
