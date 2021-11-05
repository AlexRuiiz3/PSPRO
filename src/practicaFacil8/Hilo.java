package practicaFacil8;

public class Hilo implements Runnable{
	
	 private int numeroHilo;
 
	 public Hilo(int numeroHilo) {
		 this.numeroHilo = numeroHilo;
	 }

	@Override
	public void run() {
		while(!Thread.currentThread().isInterrupted()) {

			System.out.println("Calculo hilo "+numeroHilo+" realizado");
		}
		System.out.println("Hilo Interrumpido "+numeroHilo);
	}
}
