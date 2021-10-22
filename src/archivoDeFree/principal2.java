package archivoDeFree;

import archivoDeFree.Contenedor;
import archivoDeFree.HiloConsumidor;
import archivoDeFree.HiloProductor;

class principal2{

public static void main(String[] args) {
        Contenedor<Integer> almacen = new Contenedor<Integer>();
        Thread hprod = new Thread(new HiloProductor(almacen, "P"));
        Thread hcons = new Thread(new HiloConsumidor(almacen, "C")); hprod.start();
        hcons.start();
        
    }
}


