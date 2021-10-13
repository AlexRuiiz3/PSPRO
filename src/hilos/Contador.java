package hilos;

public class Contador {

	private int cuenta = 0;
	
	synchronized public int getCuenta() {
		return cuenta;
	}
	
	synchronized public void incrementa() {
		cuenta++;
	}
	
}
