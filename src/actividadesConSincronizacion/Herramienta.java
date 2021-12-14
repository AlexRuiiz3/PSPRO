//Act 4
package actividadesConSincronizacion;

public class Herramienta {

	public String nombre;
	
	public Herramienta(String nombre){
		this.nombre = nombre;
		
	}
	
	public synchronized void usar() {
		System.out.println(String.format("Herramienta %s en uso", nombre));
		try {
			Thread.sleep((int) (Math.random()*(50-200+1)+50));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
