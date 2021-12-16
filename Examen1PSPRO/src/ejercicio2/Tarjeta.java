package ejercicio2;

public class Tarjeta {

	private double saldo = 1000000;
	
	public synchronized boolean comprobar(double precio) {
		boolean comprarRealizada = false;
		if(saldo > 0) {
			saldo -= precio;
			comprarRealizada = true;
		}
		
		return comprarRealizada;
	}
}
