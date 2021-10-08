package hilos;

public class Hilo implements Runnable{
	
	private final String nombre;
	
	
	Hilo(String nombre){
		this.nombre = nombre;
	}


	@Override
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.printf("Hola, soy el hilo: %s.\n",this.nombre);
		System.out.printf("Hilo %s terminado.\n",this.nombre);
	}
	
}
