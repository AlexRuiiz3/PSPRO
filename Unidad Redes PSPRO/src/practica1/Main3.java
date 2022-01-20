package practica1;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.List;



public class Main3 {

	public static void main(String[] args) {
		try {
			Enumeration<NetworkInterface> valores  = NetworkInterface.getNetworkInterfaces();
			List<InterfaceAddress> valoresInterfaceAddress;
			NetworkInterface networkInterface;
			InetAddress inteAddress;
			
			
			byte[] iPbytes;
			while(valores.hasMoreElements()) {
				
				networkInterface = valores.nextElement();
				valoresInterfaceAddress = networkInterface.getInterfaceAddresses();
				
				for (InterfaceAddress interfaceAddress : valoresInterfaceAddress) {
					inteAddress = interfaceAddress.getAddress();
					if(inteAddress instanceof Inet4Address) {
						iPbytes = inteAddress.getAddress();
							for(int i = 1 ; i <= 255; i++) {
								iPbytes[iPbytes.length-1] = (byte) i;
								try {
									if(InetAddress.getByAddress(iPbytes).isReachable(1000)) {
										System.out.println("Accesible Nº"+i);
									}
								} catch (UnknownHostException e) {
									e.printStackTrace();
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
					}
				}

			}
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
}
