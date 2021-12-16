package ejercicio1;

public class Hilo implements Runnable{

	private double[] numeros;
	private double resultado = 0;
	
	public Hilo(double[] numeros) {
		this.numeros = numeros;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < numeros.length; i++) {
			resultado += numeros[i];
		}
		System.out.println("Resultado de la suma "+resultado);
	}
}
