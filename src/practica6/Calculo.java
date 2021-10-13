package practica6;

public class Calculo {

	synchronized public void calcular1() {
		try {
			System.out.println("Inician calculo 1");
			Thread.sleep(1000);
			System.out.println("Finalizando calculo 1");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	synchronized public void calcular2() {
		try {
			System.out.println("Inician calculo 2");
			Thread.sleep(1000);
			System.out.println("Finalizando calculo 2");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	synchronized public void calcular3() {
		try {
			System.out.println("Inician calculo 3");
			Thread.sleep(1000);
			System.out.println("Finalizando calculo 3");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	 synchronized public void calcular4() {
		try {
			System.out.println("Inician calculo 4");
			Thread.sleep(1000);
			System.out.println("Finalizando calculo 4");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}
