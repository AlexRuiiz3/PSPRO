package practica2;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main4 {

	public static void main(String[] args) {

	try {

		InetAddress inetAddress = (InetAddress.getByName("www.marca.com"));
		System.out.println("Ejercicio1 IP: "+inetAddress.getHostAddress());


		InetAddress inetAddressIP = (InetAddress.getByAddress(new byte[] {(byte) 151,(byte)101,(byte)133,(byte)50}));
		System.out.println("Ejercicio2 Host: "+inetAddress.getHostName());


	} catch (UnknownHostException e) {
		e.printStackTrace();
	}
		
	}

}
