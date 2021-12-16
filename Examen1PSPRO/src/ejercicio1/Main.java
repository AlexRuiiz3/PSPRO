package ejercicio1;
import java.util.ArrayList;
import java.util.List;

public class Main {

	private final static int NUMERO_HILOS = 10;
	private final static int LONGITUD_VECTOR = 100000;
	
	public static void main(String[] args) {
		List<Thread> hilos = crearHilos();
		iniciarHilos(hilos);
		
		if(comprobarFinalizacionHilos(hilos)) {
			System.out.println("Hilos han finalizados");
		}else {
			System.out.println("Hilos lentos");
		}
		
	}
	
	private static List<Thread> crearHilos(){
		List<Thread> hilos = new ArrayList<Thread>();
		double[] numeros = generarVectorConNumeros();
		
		for(int i = 0; i < NUMERO_HILOS; i++) {
			hilos.add(new Thread(new Hilo(numeros)));
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
			try {
				hilos.get(i).join(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(hilos.get(i).isAlive()) {
				hanFinalizado = false;
			}
		}		
		return hanFinalizado;
	}
	
	private static double[] generarVectorConNumeros() {
		double[] numeros = new double[LONGITUD_VECTOR];
		
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = (Math.random()*2);
		}
		return numeros;
	}
	
}
