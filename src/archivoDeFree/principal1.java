package archivoDeFree;

import archivoDeFree.Contenedor;
import archivoDeFree.HiloConsumidor;
import archivoDeFree.HiloProductor;

public class principal1 {

    public static void main(String[] args) {
        Contenedor<Integer> almacen = new Contenedor<Integer>();
        Thread hprod1 = new Thread(new HiloProductor(almacen, "P1"));
        Thread hprod2 = new Thread(new HiloProductor(almacen, "P2"));
        Thread hcons1 = new Thread(new HiloConsumidor(almacen, "C1"));
        Thread hcons2 = new Thread(new HiloConsumidor(almacen, "C2"));
        hprod1.start();
        hprod2.start();
        hcons1.start();
        hcons2.start();

    }

}
