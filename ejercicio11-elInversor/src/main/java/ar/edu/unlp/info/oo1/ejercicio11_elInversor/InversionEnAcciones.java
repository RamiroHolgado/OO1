package ar.edu.unlp.info.oo1.ejercicio11_elInversor;

public class InversionEnAcciones implements Inversion {
	
	private String nombre;
	private int cantidad;
	private double valorUnitario;

	public InversionEnAcciones(String nombre, int cantidad, double valorUnitario) {
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.valorUnitario = valorUnitario;
	}

	public String getNombre() {
		return nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	@Override
	public double valorActual() {
		return this.valorUnitario * this.cantidad;
	}

}
