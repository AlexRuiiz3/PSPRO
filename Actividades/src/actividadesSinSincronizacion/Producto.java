package actividadesSinSincronizacion;

public class Producto {

	private int cantidad;
	private double precio;
	private String tipo;
	
	public Producto(int cantidad, double precio, String tipo) {
		this.cantidad = cantidad;
		this.precio = precio;
		this.tipo = tipo;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
