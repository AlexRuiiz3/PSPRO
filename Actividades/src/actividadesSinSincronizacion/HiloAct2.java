package actividadesSinSincronizacion;

public class HiloAct2 implements Runnable{

	private int id;
	private int[] arrayDatos;
	
	private static int incrementoId = 15;
	
	public HiloAct2(int[] arrayDatos) {
		id = incrementoId++;
		this.arrayDatos = arrayDatos;
	}

	public int getID() {
		return id;
	}
	
	@Override
	public void run() {
		int max = numeroMaximo(),min = numeroMinimo();
		double media = calcularMedia();
		
		if (!Thread.currentThread().isInterrupted()) {
			System.out.println("Numero maximo del "+id+" --> "+max);
		}
		
		if (!Thread.currentThread().isInterrupted()) {
			System.out.println("Numero minimo del "+id+"--> "+min);
		}
		
		if (!Thread.currentThread().isInterrupted()) {
			System.out.println("Media del "+id+" --> "+media);
		}
		
			
	}
	
	private double calcularMedia() {
		double media = 0;
		double resultado = 0;
		for (int i = 0; i < arrayDatos.length && !Thread.currentThread().isInterrupted(); i++) {
				media += arrayDatos[i];
		}
		
		resultado = media / arrayDatos.length;
		
		return resultado;
	}
	
	private int numeroMaximo() {
		int maximo = 0;
		
		for (int i = 0; i < arrayDatos.length && !Thread.currentThread().isInterrupted(); i++) {
			if(arrayDatos[i] > maximo) {
				maximo = arrayDatos[i];
			}
		}
		return maximo;
	}
	
	private int numeroMinimo() {
		int minimo = 999999;
		
		for (int i = 0; i < arrayDatos.length && !Thread.currentThread().isInterrupted(); i++) {
			if(arrayDatos[i] < minimo) {
				minimo = arrayDatos[i];
			}
		}
		return minimo;
	}
}
