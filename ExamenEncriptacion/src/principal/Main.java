package principal;

import gestion.GestoraDesencriptar;
import gestion.GestoraHash;



public class Main {

	private static final String RUTA_FICHERO_MENSAJE = "mensaje.txt.encript";
	private static final String RUTA_FICHERO_MENSAJE_DESENCRIPTADO = "mensaje_claro.txt";
	private static final String HASH_FICHERO_HASH = "304bb3864b2c3f438c517bc49f54782f53e24aa2d34044dcb3ea8423c77125";
	
	public static void main(String[] args) {

		byte[] bytesFicheroMensaje = GestoraHash.obtenerBytesHash(GestoraHash.leerBytesFichero(RUTA_FICHERO_MENSAJE));
				
        String hashFichero = GestoraHash.pasarArrayBytesAString(bytesFicheroMensaje);

        if(hashFichero.equals(HASH_FICHERO_HASH)) {
        	System.out.println("La comprobación de la integridad del fichero es correcta");
        }else {
        	System.out.println("El fichero no es el esperado");
        }
        
        GestoraDesencriptar.desencriptar(RUTA_FICHERO_MENSAJE, RUTA_FICHERO_MENSAJE_DESENCRIPTADO);
	}
}
