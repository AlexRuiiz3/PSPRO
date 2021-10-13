package practica6;

public class Hilo implements Runnable{

	private Calculo calculo;
	
	public Hilo(Calculo calculo) {
		this.calculo = calculo;
	}
	
	@Override
	public void run() {
		
		calculo.calcular1();
		calculo.calcular2();
		calculo.calcular3();
		calculo.calcular4();
	
	}
}
