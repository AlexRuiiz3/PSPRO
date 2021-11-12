package actividadesSinSincronizacion;

public class HiloAct1 implements Runnable{

	private int id;
	private int[] arrayDatos;
	
	private static int incrementoId = 1;
	
	public HiloAct1(int[] arrayDatos) {
		id = incrementoId++;
		this.arrayDatos = arrayDatos;
	}

	@Override
	public void run() {
		System.out.println("Soy el hilo "+id);
		
		System.out.println("Numero maximo del "+id+" --> "+numeroMaximo());
		System.out.println("Numero minimo del "+id+"--> "+numeroMinimo());
		System.out.println("Media del "+id+" --> "+calcularMedia());
	}
	
	private double calcularMedia() {
		double media = 0;
		double resultado = 0;
		for (int i = 0; i < arrayDatos.length; i++) {
				media += arrayDatos[i];
		}
		
		resultado = media / arrayDatos.length;
		
		return resultado;
	}
	
	private int numeroMaximo() {
		int maximo = 0;
		
		for (int i = 0; i < arrayDatos.length; i++) {
			if(arrayDatos[i] > maximo) {
				maximo = arrayDatos[i];
			}
		}
		return maximo;
	}
	
	private int numeroMinimo() {
		int minimo = 999999;
		
		for (int i = 0; i < arrayDatos.length; i++) {
			if(arrayDatos[i] < minimo) {
				minimo = arrayDatos[i];
			}
		}
		return minimo;
	}
}
