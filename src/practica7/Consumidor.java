package practica7;

public class Consumidor implements Runnable {
    private final Contenedor datos;
    private final int númeroConsumidor;
    private boolean interrumpir = false;
    private int[] dato = null;

    public Consumidor(Contenedor datos, int númeroConsumidor) {
        this.númeroConsumidor = númeroConsumidor;
        this.datos = datos;
    }

    @Override
    public void run() {
        while (!interrupciónLanzada()) {
            obtenerDato();
            if (!interrupciónLanzada())
                consumirDato(dato);
        }
        System.out.printf("Hilo consumidor %d interrumpido", númeroConsumidor);
    }

    private void obtenerDato() {
        synchronized (datos) {
            while (datos.vacio() && !interrupciónLanzada()) {
                esperar();
            }
            if (!interrupciónLanzada())
                dato = datos.get();
            datos.notifyAll();
        }
    }

    private void esperar() {
        try {
            datos.wait();
        } catch (InterruptedException ex) {
            interrumpir = true;
        }
    }

    private boolean interrupciónLanzada() {
        return Thread.currentThread().isInterrupted()
                || interrumpir;
    }

    private void consumirDato(int[] dato) {
        int suma = 0;
        for (int i = 0; i < dato.length; i++)
            suma += dato[i];
        System.out.println(suma);
    }
}