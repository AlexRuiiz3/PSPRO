package hilos;

public class LanzaHilos {

	public static void main (String[] args) {
		
		Thread h1 = new Thread(new Hilo("H1"));
		Thread h2 = new Thread(new Hilo("H2"));
		
		h1.start();
		h2.start();
		
		try {
			h1.join();
			h2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
		System.out.println("Hilo principal terminado.");
		
	}
	
}
