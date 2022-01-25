

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;


public class EchoCliente {

  private final static int MAX_BYTES = 1400;
  private final static String COD_TEXTO = "UTF-8";

  public static void main(String[] args) {

    try (DatagramSocket clientSocket = new DatagramSocket();
            InputStreamReader isrStdIn = new InputStreamReader(System.in, COD_TEXTO);
            BufferedReader brStdIn = new BufferedReader(isrStdIn)) {

      String lineaLeida;

      System.out.println("Introducir l�neas. L�nea vac�a para terminar.");
      System.out.print("L�nea>");

      while ((lineaLeida = brStdIn.readLine()) != null
              && lineaLeida.length() > 0) {

        InetAddress IPServidor = InetAddress.getByName("192.168.0.161");
        byte[] b = lineaLeida.getBytes(COD_TEXTO);
        DatagramPacket paqueteEnviado = new DatagramPacket(b, b.length,
                IPServidor, 99);

        clientSocket.connect(IPServidor, 99);
        clientSocket.send(paqueteEnviado);

        byte[] datosRecibidos = new byte[MAX_BYTES];
        DatagramPacket paqueteRecibido
                = new DatagramPacket(datosRecibidos, datosRecibidos.length);
        clientSocket.receive(paqueteRecibido);
        String respuesta
                = new String(paqueteRecibido.getData(),
                        0, paqueteRecibido.getLength(), COD_TEXTO);

        System.out.printf("Datagrama recibido de %s:%d: %s\n",
                paqueteRecibido.getAddress().getHostAddress(), paqueteRecibido.getPort(),
                respuesta);
        System.out.print("L�nea>");

      }

    } catch (SocketException ex) {
      System.out.println("Excepci�n de sockets");
      ex.printStackTrace();
    } catch (IOException ex) {
      System.out.println("Excepci�n de E/S");
      ex.printStackTrace();
    }
  }
}
