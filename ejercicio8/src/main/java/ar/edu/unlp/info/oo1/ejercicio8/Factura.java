package ar.edu.unlp.info.oo1.ejercicio8;

import java.time.LocalDate;

public class Factura {
	private double montoEnergiaActiva;
	private double descuento;
	private LocalDate fecha;
	private Usuario usuario;
	
	
	public Factura(double montoEnergiaActiva, double descuento, Usuario usuario) {
		this.montoEnergiaActiva = montoEnergiaActiva;
		this.descuento = descuento;
		this.fecha = LocalDate.now();
		this.usuario = usuario;
	}

	public double montoTotal() {
		if (this.descuento != 0)
			return this.getMontoEnergiaActiva() * (this.getDescuento() / 100);
		return this.getMontoEnergiaActiva();
	}
	

	public LocalDate getFecha() {
		return fecha;
	}

	public double getDescuento() {
		return descuento;
	}

	public double getMontoEnergiaActiva() {
		return montoEnergiaActiva;
	}

	public Usuario getUsuario() {
		return usuario;
	}


}

