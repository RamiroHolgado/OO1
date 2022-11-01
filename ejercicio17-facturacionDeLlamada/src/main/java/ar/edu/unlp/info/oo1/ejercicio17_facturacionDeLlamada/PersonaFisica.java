package ar.edu.unlp.info.oo1.ejercicio17_facturacionDeLlamada;

import java.time.LocalDate;

public class PersonaFisica extends Cliente {
	private int dni;

	public PersonaFisica(String nombre, String direccion, int numero, int dni) {
		super(nombre, direccion, numero);
		this.dni = dni;
	}

	public int getDni() {
		return dni;
	}

	@Override
	public Factura facturarLlamadas(DateLapse d) {
		double monto = super.getLlamadas().stream().filter(l -> d.includesDate(l.getFecha()))
				.mapToDouble(l -> l.calcularCosto()).sum();

		return new Factura(this, LocalDate.now(), d, monto - (monto * 0.10));
	}

}
