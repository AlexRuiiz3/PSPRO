package practica6;

public class Calculo {

	private Object obj = new Object();
	private Object obj2 = new Object();
	private Object obj3 = new Object();
	private Object obj4 = new Object();
	
	 public void calcular1() {
		synchronized (obj) {
			try {
				System.out.println(String.format("Iniciando calculo 1 del hilo: %s", Thread.currentThread().getId()));
				Thread.sleep(1000);
				System.out.println("Finalizando calculo 1");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	 public void calcular2() {
		synchronized (obj2) {	
			try {
				System.out.println(String.format("Iniciando calculo 2 del hilo: %s", Thread.currentThread().getId()));
				Thread.sleep(1000);
				System.out.println("Finalizando calculo 2");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	 public void calcular3() {
		synchronized (obj3) {
			try {
				System.out.println(String.format("Iniciando calculo 3 del hilo: %s", Thread.currentThread().getId()));
				Thread.sleep(1000);
				System.out.println("Finalizando calculo 3");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	  public void calcular4() {
		synchronized (obj4) {
			try {
				System.out.println(String.format("Iniciando calculo 4 del hilo: %s", Thread.currentThread().getId()));				
				Thread.sleep(1000);
				System.out.println("Finalizando calculo 4");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	 }
}
