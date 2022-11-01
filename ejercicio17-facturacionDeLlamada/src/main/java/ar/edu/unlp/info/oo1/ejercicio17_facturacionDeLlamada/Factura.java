package ar.edu.unlp.info.oo1.ejercicio17_facturacionDeLlamada;

import java.time.LocalDate;

public class Factura {
	private Cliente cliente;
	private LocalDate fecha;
	private DateLapse periodo;
	private double monto;

	public Factura(Cliente cliente, LocalDate fecha, DateLapse periodo, double monto) {
		this.cliente = cliente;
		this.fecha = fecha;
		this.periodo = periodo;
		this.monto = monto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public DateLapse getPeriodo() {
		return periodo;
	}

	public double getMonto() {
		return monto;
	}

}
