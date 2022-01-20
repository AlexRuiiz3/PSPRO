package practica2;

import static java.net.InetAddress.getLocalHost;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main4 {

	public static void main(String[] args) {

	try {

		InetAddress inetAddress = (InetAddress.getByName("www.marca.com"));
		System.out.println(inetAddress.getHostAddress());
		

	} catch (UnknownHostException e) {
		e.printStackTrace();
	}
		
	}

}
