package supuestosExamenMultihilo.Actividad3;

public class Hilo implements Runnable{

	@Override
	public void run() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
