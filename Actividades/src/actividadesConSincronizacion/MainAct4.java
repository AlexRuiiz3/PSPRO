package actividadesConSincronizacion;

public class MainAct4 {

	public static void main(String[] args) {
		
		Herramienta herramienta1 = new Herramienta("Taladro");
		Herramienta herramienta2 = new Herramienta("Destornillador");
		Herramienta herramienta3 = new Herramienta("Alicates");

		Actividad actividad1 = new Actividad(herramienta1,herramienta2);
		Actividad actividad2 = new Actividad(herramienta2,herramienta3);
		Actividad actividad3 = new Actividad(herramienta1,herramienta2,herramienta3);
		
		Thread hilo1 = new Thread(actividad1);
		Thread hilo2 = new Thread(actividad2);
		Thread hilo3 = new Thread(actividad3);
		
		hilo1.start();
		hilo2.start();
		hilo3.start();
	}
}
