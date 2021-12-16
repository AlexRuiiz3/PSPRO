package practica9_Basico;

public class IA implements Runnable{

	private int id;
	
	public IA(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	@Override
	public void run() {
		try {
			System.out.println("Calculando IA N� "+id);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
