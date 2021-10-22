package archivoDeFree;

public class Contenedor<T> {
    private T dato;

    synchronized public T get() {
        T result = this.dato;
        this.dato = null;
        return result;
    }

    synchronized public void put(T valor) {
        this.dato = valor;
    }

    synchronized boolean datoDisponible() {
        return (this.dato != null);
    }
}

