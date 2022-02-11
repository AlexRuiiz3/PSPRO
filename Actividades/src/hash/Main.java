package hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese una cadena a digerir");
		
		byte[] cadena = sc.nextLine().getBytes();
		
		byte[] hash = obtenerHash(cadena);
		imprimirHash(hash);
	}

	
	private static byte[] obtenerHash(byte[] informacion) {
		
		MessageDigest msd = null;
		
		try {
			msd = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		msd.update(informacion);
		return msd.digest();
	}
	
	private static void imprimirHash(byte[] hash) {
		StringBuilder sb = new StringBuilder();
		
		for(byte a : hash) {
			sb.append(String.format("%x", a));
			
		}
		System.out.println("El codigo hash es: "+sb);
	}
}
