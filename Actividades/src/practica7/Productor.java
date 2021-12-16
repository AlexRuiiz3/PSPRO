package practica7;

public class Productor implements Runnable{

	private final Contenedor datos;
	
	public Productor(Contenedor datos) {
		this.datos = datos;
	}
	
	@Override
	public void run() {
		
		boolean interrumpido = false;
		while(!Thread.currentThread().isInterrupted() && !interrumpido) {
			
			int[] datoo = producirDato();
			synchronized (this.datos) {
				
				
				while(!Thread.currentThread().isInterrupted() && datos.maximoAlcanzado()) {
					
					try {
						datos.wait();
					} catch (InterruptedException e) {
						interrumpido = true;
						System.out.println("****INTERRUMPIDO Productor**** ");
					}
				}
				datos.put(datoo);
				datos.notifyAll();
			}			
		}
	}
	
	private int[] producirDato() {
		int[] dato = new int[1000];
		
		for (int i = 0; i < dato.length; i++) {
			dato[i] = (int) (Math.random() * 10001); //Entre 0 y 10000 excluido en 10001
		}
	
		return dato;
	}
	
}
