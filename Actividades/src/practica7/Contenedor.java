package practica7;

import java.util.ArrayList;
import java.util.List;

public class Contenedor {

	private int MAXIMO = 10;
	private final List<int[]> datos = new ArrayList<>();
	

	synchronized public void put(int[] valor) {
		datos.add(valor);
	}
	
	synchronized public int[] get(){
		int[] valor = datos.get(0); 
		this.datos.remove(0);
		return valor;
	}
	
	synchronized public boolean maximoAlcanzado() {
		return datos.size() == MAXIMO;
	}
	
	synchronized public boolean vacio() {
		return datos.isEmpty();
	}
}
