package gestoras;

public class Utilidades {
	
	 public static String determinarAlgoritmoEnFichero(byte[] bytesFichero) {
	    String algoritmo = "";
		
		switch(bytesFichero.length) {
		
		case 8:
			algoritmo = "DES";
		break;
		
		case 16:
			algoritmo = "AES";
		break;
		
		case 24:
			algoritmo = "DESede";
		break;
		}
		return algoritmo;
	}
}
