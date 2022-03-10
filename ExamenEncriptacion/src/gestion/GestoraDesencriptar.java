package gestion;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


public class GestoraDesencriptar {

	private static final String ALGORITMO = "DESede";
	private static final String FICHERO_CLAVE = "clave.raw";
	public static void desencriptar(String ficheroEncriptar, String ficheroResultado) {
		byte[] claveEnBytes;
		Cipher cifrado;
		
		claveEnBytes = obtenerClave(FICHERO_CLAVE);
		
		cifrado = crearDesCifrado(ALGORITMO, claveEnBytes);

		hacerFicheroDesencriptado(ficheroEncriptar,ficheroResultado,cifrado);
	}
	
	private static byte[] obtenerClave(String nombreFichero){
    	Path in = Paths.get(nombreFichero);
        byte[] valorClave = null;

        try {
			valorClave = Files.readAllBytes(in);
		} catch (IOException e) {
			e.printStackTrace();
		}

        return valorClave;
    }
    
    private static Cipher crearDesCifrado(String algoritmo, byte[] valorClave) {
        SecretKeySpec claveSecrepSpec = new SecretKeySpec(valorClave, algoritmo);
        SecretKey claveSecret;
        Cipher cifrado = null;

        try {
        	claveSecret = new SecretKeySpec(claveSecrepSpec.getEncoded(), algoritmo);
            cifrado = Cipher.getInstance(algoritmo);
            cifrado.init(Cipher.DECRYPT_MODE, claveSecret);
        }catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        }
        return cifrado;
    }
    
    private static void hacerFicheroDesencriptado(String inputFichero, String outputFichero, Cipher cifrado){
        File fi = new File(inputFichero), fo = new File(outputFichero + ".encript");

        try (FileInputStream fis = new FileInputStream(fi);
             FileOutputStream fos = new FileOutputStream(fo);
             BufferedInputStream is = new BufferedInputStream(fis);
             BufferedOutputStream os = new BufferedOutputStream(fos)) {
            byte[] buff = new byte[cifrado.getBlockSize()];
            while(is.read(buff) != -1) {
                os.write(cifrado.update(buff));
            }
            os.write(cifrado.doFinal());
            System.out.println("Fichero desencriptado y guardado con éxito en el fichero "+outputFichero);
        } catch (IOException | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }
    }
	
}
