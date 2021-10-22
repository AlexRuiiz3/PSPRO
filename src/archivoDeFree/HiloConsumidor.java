package archivoDeFree;

public class HiloConsumidor implements Runnable {
    final Contenedor<Integer>cont;
    String miNombre;

    public HiloConsumidor(Contenedor<Integer> cont, String miNombre) {
        this.cont = cont;
        this.miNombre = miNombre;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this.cont) {
                while (!this.cont.datoDisponible()) {
                    try {
                        this.cont.wait();
                    } catch (InterruptedException ex) {
                    }
                }
                Integer dato = this.cont.get();
                this.cont.notify();
                System.out.println("Hilo "+this.miNombre+" consume valor\n"+dato);
            }
        }
    }
}
