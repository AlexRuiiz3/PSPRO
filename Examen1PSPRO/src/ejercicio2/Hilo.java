package ejercicio2;

public class Hilo implements Runnable{

	private Tarjeta tarjeta;
	private double importeGastado = 0;
	
	public Hilo(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}
	@Override
	public void run() {
		double precioCompra = generarPrecioCompra();
		
		while(tarjeta.comprobar(precioCompra = generarPrecioCompra())) {
			importeGastado += precioCompra;
		}
		
		System.out.println("Importe gastado "+importeGastado+" euros");
	}
	 private double generarPrecioCompra() { 
		 return (Math.random()*1 + 51);
	 }
}
