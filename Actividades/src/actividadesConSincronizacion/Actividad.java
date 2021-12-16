//Act4
package actividadesConSincronizacion;

public class Actividad implements Runnable {

	private Herramienta[] listaHerramientas;
	
	public Actividad (Herramienta... listaHerramientas) {
		this.listaHerramientas = listaHerramientas;
	}

	@Override
	public void run() {
		
		for (int i = 0; i < listaHerramientas.length; i++) {
			listaHerramientas[i].usar();
		}
	}
}
