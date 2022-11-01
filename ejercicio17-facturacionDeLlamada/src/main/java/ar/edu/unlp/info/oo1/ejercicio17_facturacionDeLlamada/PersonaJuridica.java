package ar.edu.unlp.info.oo1.ejercicio17_facturacionDeLlamada;

import java.time.LocalDate;

public class PersonaJuridica extends Cliente {
	private int cuit;
	private String tipo;

	public PersonaJuridica(String nombre, String direccion, int numero, int cuit, String tipo) {
		super(nombre, direccion, numero);
		this.cuit = cuit;
		this.tipo = tipo;
	}

	public int getCuit() {
		return cuit;
	}

	public String getTipo() {
		return tipo;
	}

	@Override
	public Factura facturarLlamadas(DateLapse d) {
		double monto = super.getLlamadas().stream().filter(l -> d.includesDate(l.getFecha()))
				.mapToDouble(l -> l.calcularCosto()).sum();

		return new Factura(this, LocalDate.now(), d, monto);
	}

}
