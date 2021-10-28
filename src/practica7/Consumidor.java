package practica7;

public class Consumidor implements Runnable{

	private final Contenedor datos;
	private int[] array;
	private int sumaTotal = 0;
	
	public Consumidor(Contenedor datos) {
		this.datos = datos;
	}
	
	@Override
	public void run() {
		
		while(true) {
			synchronized (this.datos) {
				
				while(datos.vacio()) {
					
					try {
						datos.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				this.datos.notify();
				array = datos.get();
				sumaTotal = consumirDatos(array);
				System.out.println("Total suma: "+sumaTotal);
			}			
		}
	}
	
	public int consumirDatos(int[] dato) {
		int suma = 0;
		int j = 0;
		for (int i = 1; i < dato.length; i++) {
			suma += dato[i] +dato[j];
			j++;
		}
		return suma;
	}
}
