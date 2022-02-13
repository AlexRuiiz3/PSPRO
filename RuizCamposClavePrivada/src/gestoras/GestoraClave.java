package gestoras;

import java.io.FileOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.SecretKeySpec;

import validaciones.Validacion;

public class GestoraClave {

    public static final String CLAVE_AES  ="AES";
    public static final String CLAVE_DES = "DES";
    public static final String CLAVE_DESede = "DESede";
    
    private static final String ALGORITMO_GENERACION_ALEATATORIO = "SHA1PRNG";
	
    
    public static void genenarClave() {
    	String tipoAlgoritmo = Validacion.leerValidarClaveSimetrica();
    	String nombreFicheroConClave;
    	byte[] claveEnBytes;
    	
    	if(!tipoAlgoritmo.equals("")) {
    		System.out.println("Ingrese el nombre del fichero de la clave (No especifique la extension)");
    		nombreFicheroConClave = Validacion.leerCadena() + ".raw";
    		
        	SecretKey claveSecret = generarKey(tipoAlgoritmo);
        	SecretKeyFactory claveSecretFactory = generarSecretKeyFactory(tipoAlgoritmo);
        	
        	claveEnBytes = determinarClaseKey(tipoAlgoritmo,claveSecret,claveSecretFactory);
    		guardarClaveEnFichero(nombreFicheroConClave,claveEnBytes);
    	}else {
    		System.out.println("Saliendo...");
    	}
    }
    
    private static byte[] usarDesKeySpec(SecretKeyFactory keySpecFactory,SecretKey clave) {
        byte[] claveEnBytes = null;

        try {
            DESKeySpec des = (DESKeySpec) keySpecFactory.getKeySpec(clave,DESKeySpec.class);
            claveEnBytes = des.getKey();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return claveEnBytes;
    }
    
    private static byte[] usarDesedeSpec(SecretKeyFactory keySpecFactory,SecretKey clave) {
        byte[] claveEnBytes = null;

        try {
            DESedeKeySpec desSede = (DESedeKeySpec) keySpecFactory.getKeySpec(clave, DESedeKeySpec.class);
            claveEnBytes = desSede.getKey();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return claveEnBytes;
    }
    
    private static byte[] usarAesKeySpec(SecretKey clave) {
        byte[] claveEnBytes = clave.getEncoded();

        SecretKeySpec skeySpec = new SecretKeySpec(claveEnBytes, CLAVE_AES);
        return skeySpec.getEncoded();
    }
    
    private static byte[] determinarClaseKey(String tipoAlgoritmo,SecretKey claveSecret, SecretKeyFactory claveSecretFactory){
        byte[] claveEnBytes = null;

        switch(tipoAlgoritmo){
            case CLAVE_AES: 
            	claveEnBytes = usarAesKeySpec(claveSecret);
            break;
            case CLAVE_DES:  
            	claveEnBytes = usarDesKeySpec(claveSecretFactory,claveSecret);
            break;
            case CLAVE_DESede: 
            	claveEnBytes = usarDesedeSpec(claveSecretFactory,claveSecret);
            break;
        }
        return claveEnBytes;
    }
    
    private static SecretKey generarKey(String tipoAlgoritmo){
        SecretKey clave = null;

        try {
            KeyGenerator genClaves = KeyGenerator.getInstance(tipoAlgoritmo);
            SecureRandom srand = SecureRandom.getInstance(ALGORITMO_GENERACION_ALEATATORIO);
            genClaves.init(srand);
            clave = genClaves.generateKey();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return clave;
    }
    
    private static SecretKeyFactory generarSecretKeyFactory(String tipoAlgoritmo){
        SecretKeyFactory keySpecFactory = null;

        try {
            if(!tipoAlgoritmo.equals(CLAVE_AES)){
                keySpecFactory = SecretKeyFactory.getInstance(tipoAlgoritmo);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return keySpecFactory;
    }
    
    private static void guardarClaveEnFichero(String nombreFichero,byte[] claveEnBytes){
        try(FileOutputStream fos = new FileOutputStream(nombreFichero)) {
            fos.write(claveEnBytes);
            System.out.println("Clave guardada con exito");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
