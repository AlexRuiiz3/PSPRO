package gestion;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GestoraHash {

	
	public static byte[] obtenerBytesHash(byte[] informacion) {
        MessageDigest msd;
        byte[] bytesHash = null;
        try {
            msd = MessageDigest.getInstance("SHA-256");
            if (msd != null && informacion != null){
                msd.update(informacion);
                bytesHash = msd.digest();
            }
        } catch (NoSuchAlgorithmException e) {
            System.out.println("No se pudo encontrar el algoritmo");
        }
        return bytesHash;
    }

    public static String pasarArrayBytesAString(byte[] hash) {
        StringBuilder sb = new StringBuilder();
        if(hash != null) {
	        for (byte b : hash) {
	            sb.append(String.format("%x", b));
	        }
	        
        }
        return sb.toString();
    }

    public static byte[] leerBytesFichero(String nombreFichero) {
    	Path in = Paths.get(nombreFichero);
        byte[] bytesFichero = null;
        try {
        	bytesFichero = Files.readAllBytes(in);
        } catch (IOException e) {
           System.out.println("A ocurrido un error tratando el fichero");
        }
        return bytesFichero;
    }
}
