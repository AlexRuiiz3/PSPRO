package practica7;

public class Consumidor implements Runnable{

	private final Contenedor datos;
	int sumaTotal = 0;
	
	public Consumidor(Contenedor datos) {
		this.datos = datos;
	}
	
	@Override
	public void run() {
		
		while(true) {
			synchronized (this.datos) {
				
				while(!datos.vacio()) {
					
					try {
						datos.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				consumirDatos();
				datos.notifyAll();
			}			
		}
	}
	
	public int consumirDatos() {
		int[] dato = datos.get();
		int suma = 0;
	
		for (int i = 0; i < dato.length; i++) {
			suma += dato[i];
		}
		return suma;
	}
}
