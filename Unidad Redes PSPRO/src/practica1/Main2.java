package practica1;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.List;

public class Main2 {

	public static void main(String[] args) {
		try {
			Enumeration<NetworkInterface> valores  = NetworkInterface.getNetworkInterfaces();
			List<InterfaceAddress> valoresInterfaceAddress;
			NetworkInterface networkInterface;
			
			while(valores.hasMoreElements()) {
				
				networkInterface = valores.nextElement();
				valoresInterfaceAddress = networkInterface.getInterfaceAddresses();
				
				for (InterfaceAddress interfaceAddress : valoresInterfaceAddress) {
					if(interfaceAddress.getAddress() instanceof Inet4Address) {
						try {
							System.out.println("Mascara: "+interfaceAddress.getNetworkPrefixLength());
							System.out.println("Direccion ip: "+interfaceAddress.getAddress().getLocalHost());
							System.out.println("Broadcast: "+interfaceAddress.getBroadcast().getHostName());
						} catch (UnknownHostException e) {

							e.printStackTrace();
						}
					}
				}

			}
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
}
