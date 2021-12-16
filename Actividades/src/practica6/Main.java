package practica6;

import hilos.HiloInverso;

public class Main {

	public static void main(String[] args) {
		
		Calculo calculo = new Calculo();
		Calculo calculo2 = new Calculo();

		Thread h1 = new Thread(new Hilo(calculo));
		Thread h2 = new Thread(new Hilo(calculo));
		Thread h3 = new Thread(new Hilo(calculo));
		Thread h4 = new Thread(new Hilo(calculo));
		Thread h5 = new Thread(new Hilo(calculo));
		
		Thread hi1 = new Thread(new HiloInverso(calculo2));
		Thread hi2 = new Thread(new HiloInverso(calculo2));
		Thread hi3 = new Thread(new HiloInverso(calculo2));
		Thread hi4 = new Thread(new HiloInverso(calculo2));
		Thread hi5 = new Thread(new HiloInverso(calculo2));
		
		h1.start();
		h2.start();
		h3.start();
		h4.start();
		h5.start();
		
		hi1.start();
		hi2.start();
		hi3.start();
		hi4.start();
		hi5.start();
		
	}
}
