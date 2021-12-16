package actividadesSinSincronizacion;

import java.util.ArrayList;


public class MainAct3 {

	public static void main(String[] args) {

		ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();

		for (int i = 0; i < 100000; i++) {
			listaPedidos.add(new Pedido());
		}
		
		ArrayList<Pedido> subParteListaPedidos = new ArrayList();
		int procesadoresDisponibles = Runtime.getRuntime().availableProcessors();
		int indiceMinimo = 0;
		int indiceMaximo = listaPedidos.size()/procesadoresDisponibles;
		
		ArrayList<Resultado> resultadosHilos = new ArrayList<Resultado>();
		
		ArrayList<Thread> listaHilos = new ArrayList<Thread>();
		for(int i = 0; i < procesadoresDisponibles; i++) {
			subParteListaPedidos = new ArrayList<Pedido>(listaPedidos.subList(indiceMinimo, indiceMaximo));
			indiceMinimo = indiceMaximo;
			indiceMaximo += listaPedidos.size()/procesadoresDisponibles;
			listaHilos.add(new Thread(new HiloAct3(subParteListaPedidos,resultadosHilos)));
		}
		
		for (int i = 0; i < listaHilos.size(); i++) {
			listaHilos.get(i).start();
		}
		
		for(int i = 0; i < resultadosHilos.size(); i++) {
			System.out.println("Hilo "+(i+1));
			System.out.println("Importe Herramientas--> "+resultadosHilos.get(i).getImporteH());
			System.out.println("Importe Recambios--> "+resultadosHilos.get(i).getImporteR());
			System.out.println("Importe Limpieza--> "+resultadosHilos.get(i).getImporteL());
		}
	}
}
