package practica7;

public class Productor implements Runnable{

	private final Contenedor datos;
	
	public Productor(Contenedor datos) {
		this.datos = datos;
	}
	
	@Override
	public void run() {
		while(true) {
			synchronized (this.datos) {
				
				while(!datos.maximoAlcanzado()) {
					
					try {
						datos.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				datos.put(producirDato());
				datos.notifyAll();
			}			
		}
	}
	
	private int[] producirDato() {
		int[] dato = new int[100];
		
		for (int i = 0; i < dato.length; i++) {
			dato[i] = (int) (Math.random() * 10001); //Entre 0 y 10000 excluido en 10001
		}
	
		return dato;
	}
	
}
