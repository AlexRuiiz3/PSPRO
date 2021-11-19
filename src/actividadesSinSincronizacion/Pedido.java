package actividadesSinSincronizacion;

import java.util.ArrayList;
import java.util.Random;

public class Pedido {

	private ArrayList<Producto> productos = new ArrayList();
	
	
	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public Pedido() {
		int numeroPedidos = (int)(Math.random()*26+1);
		String tipoProducto = "";
		double precioProducto = 0;
		int cantidadProducto = 0;
		
		for (int i = 0; i < numeroPedidos; i++) {
			cantidadProducto = (int)(Math.random()*50+1);
			tipoProducto = generarTipoProducto();
			precioProducto = generarPrecioProducto(tipoProducto);
			productos.add(new Producto(cantidadProducto,precioProducto,tipoProducto));
		}
	}
	
	private String generarTipoProducto() {
		int random = (int)(Math.random()*3); //0 a 2
		String tipo = "";
		
		switch(random) {
		case 0:
			tipo = "Herramienta";
		break;
		
		case 1:
			tipo = "Recambios";
		break;
		
		case 2:
			tipo = "Limpieza";
		break;
		}
		return tipo;
	}
	private double generarPrecioProducto(String tipo) {
		Random rand = new Random();
		double precio = 0;
		
		switch(tipo) {
		case "Herramienta":
			precio =  4.50 + ( 130 - 4.50 ) * rand.nextDouble();
		break;
		
		case "Recambios":
			precio =  2 + ( 28.90 - 2 ) * rand.nextDouble();
		break;
		
		case "Limpieza":
			precio =  0.45 + ( 14.50 - 0.45 ) * rand.nextDouble();
		break;
		}
		return precio;
	}
}
