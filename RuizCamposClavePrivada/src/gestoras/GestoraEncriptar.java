package gestoras;

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

import validaciones.Validacion;

public class GestoraEncriptar {

	public static void encriptar() {
		String algoritmo,ficheroEncriptar,ficheroResultado;
		byte[] claveEnBytes;
		Cipher cifrado;
		
		System.out.println("Ingrese el nombre del fichero de la clave (No especifique la extension)");
		String nombreFicheroConClave = Validacion.leerCadena() + ".raw";
		
		claveEnBytes = obtenerClave(nombreFicheroConClave);
		algoritmo = Utilidades.determinarAlgoritmoEnFichero(claveEnBytes);
		cifrado = crearCifrado(algoritmo, claveEnBytes);

		System.out.println("Ingrese el nombre del fichero que va a encriptar (Incluya la extension)");
		ficheroEncriptar = Validacion.leerCadena();
		System.out.println("Ingrese el nombre del fichero una vez encriptado (sin extension)");
		ficheroResultado = Validacion.leerCadena();
		prepararFicheroCifrado(ficheroEncriptar,ficheroResultado,cifrado);
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
    
    private static Cipher crearCifrado(String algoritmo, byte[] valorClave) {
        SecretKeySpec claveSecrepSpec = new SecretKeySpec(valorClave, algoritmo);
        SecretKey claveSecret;
        Cipher cifrado = null;

        try {
        	claveSecret = new SecretKeySpec(claveSecrepSpec.getEncoded(), algoritmo);
            cifrado = Cipher.getInstance(algoritmo);
            cifrado.init(Cipher.ENCRYPT_MODE, claveSecret);
        }catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        }
        return cifrado;
    }
    
    private static void prepararFicheroCifrado(String inputFichero,String outputFichero, Cipher cifrado){
        File fi = new File(inputFichero), fo = new File(outputFichero + ".encript");

        try (FileInputStream fis = new FileInputStream(fi);
             FileOutputStream fos = new FileOutputStream(fo)){
            byte[] buffer = new byte[64];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                byte[] output = cifrado.update(buffer, 0, bytesRead);
                if (output != null) {
                    fos.write(output);
                }
            }
            byte[] outputBytes = cifrado.doFinal();
            if (outputBytes != null) {
                fos.write(outputBytes);
            }
            System.out.println("Encriptacion realizada con exito");
        } catch (IOException | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }
    }
}
