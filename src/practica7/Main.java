//Ordenar vector de enteros creando 8 hilos
package practica7;

public class Main {

	public static void main(String[] args) {
		
		Contenedor c = new Contenedor();

		Thread productor = new Thread(new Productor(c));
		Thread consumidor = new Thread(new Consumidor(c));
		
		productor.start();
		consumidor.start();
		
	}
}
