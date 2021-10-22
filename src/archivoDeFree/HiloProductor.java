package archivoDeFree;

public class HiloProductor implements Runnable {
    final Contenedor<Integer>cont;
    String miNombre;

    public HiloProductor(Contenedor<Integer> cont, String miNombre) {
        this.cont = cont;
        this.miNombre = miNombre;
    }

    @Override
    public void run() {
        for (int i = 1; ; i++) {
            synchronized (this.cont) {
                while (this.cont.datoDisponible()) {
                    try {
                        this.cont.wait();
                    } catch (InterruptedException ex) {
                    }
                }
                System.out.println("Hilo "+this.miNombre+" produce valor\n"+i); 
                this.cont.put(i);
                this.cont.notify();
            }
        }
    }
}