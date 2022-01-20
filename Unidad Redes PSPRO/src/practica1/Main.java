package practica1;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class Main {

	public static void main(String[] args) {

		try {
			Enumeration<NetworkInterface> valores  = NetworkInterface.getNetworkInterfaces();
			NetworkInterface networkInterface;

			while(valores.hasMoreElements()) {
				networkInterface = valores.nextElement();
				System.out.println("Nombre: "+networkInterface.getName()+" Nombre descriptivo:"+networkInterface.getDisplayName()+"Mac: Hay que pasar de bits a hexadecimal, con un for...");
			}
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

}
