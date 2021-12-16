package actividadesSinSincronizacion;

import java.util.ArrayList;

public class HiloAct3 implements Runnable{

	private int id;
	private ArrayList<Pedido> pedidos;
	private static int idIncremento = 1;

	private ArrayList<Resultado> resultados;
	
	public HiloAct3(ArrayList<Pedido> pedidos, ArrayList<Resultado> resultados) {	
		id = idIncremento++;
		this.pedidos = pedidos;
		this.resultados = resultados;
	}

	@Override
	public void run() {		
		calculos();
	}

	private void calculos() {	
		double importeHerramientas = 0;
		double importeRecambios = 0;
		double importeLimpieza = 0;
		for (int i = 0; i < pedidos.size(); i++) {
			
			for(int j = 0; j < pedidos.get(0).getProductos().size(); j++) {
				switch(pedidos.get(0).getProductos().get(j).getTipo()) {
					case "Herramienta":
						importeHerramientas += pedidos.get(0).getProductos().get(j).getPrecio();
					break;
					
					case "Limpieza":
						importeLimpieza += pedidos.get(0).getProductos().get(j).getPrecio();
					break;
					
					case "Recambios":
						importeRecambios += pedidos.get(0).getProductos().get(j).getPrecio();
					break;
				}
			}
		}
		resultados.add(new Resultado(importeHerramientas,importeRecambios,importeLimpieza));
	}
}
