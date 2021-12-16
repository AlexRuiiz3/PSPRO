package practica7;

public class Consumidor implements Runnable {
    private final Contenedor datos;
    private final int n�meroConsumidor;
    private boolean interrumpir = false;
    private int[] dato = null;

    public Consumidor(Contenedor datos, int n�meroConsumidor) {
        this.n�meroConsumidor = n�meroConsumidor;
        this.datos = datos;
    }

    @Override
    public void run() {
        while (!interrupci�nLanzada()) {
            obtenerDato();
            if (!interrupci�nLanzada())
                consumirDato(dato);
        }
        System.out.printf("Hilo consumidor %d interrumpido", n�meroConsumidor);
    }

    private void obtenerDato() {
        synchronized (datos) {
            while (datos.vacio() && !interrupci�nLanzada()) {
                esperar();
            }
            if (!interrupci�nLanzada())
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

    private boolean interrupci�nLanzada() {
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