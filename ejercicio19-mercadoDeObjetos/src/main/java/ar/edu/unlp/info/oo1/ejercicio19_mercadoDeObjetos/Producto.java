package ar.edu.unlp.info.oo1.ejercicio19_mercadoDeObjetos;

public class Producto {
	private String nombre;
	private String descripcion;
	private double precio;
	private int unidadesDisponibles;
	private Usuario vendedor;

	public Producto(String nombre, String descripcion, double precio, int unidadesDisponibles, Usuario vendedor) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.unidadesDisponibles = unidadesDisponibles;
		this.vendedor = vendedor;
	}

	public int getUnidadesDisponibles() {
		return unidadesDisponibles;
	}

	public void setUnidadesDisponibles(int unidadesDisponibles) {
		this.unidadesDisponibles = unidadesDisponibles;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public Usuario getVendedor() {
		return vendedor;
	}

}
