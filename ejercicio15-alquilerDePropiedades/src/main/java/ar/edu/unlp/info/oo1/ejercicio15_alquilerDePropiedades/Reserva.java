package ar.edu.unlp.info.oo1.ejercicio15_alquilerDePropiedades;

public class Reserva {
	private Propiedad propiedad;
	private DateLapse periodo;

	public Reserva(Propiedad propiedad, DateLapse periodo) {
		this.propiedad = propiedad;
		this.periodo = periodo;
	}

	public Propiedad getPropiedad() {
		return propiedad;
	}

	public DateLapse getPeriodo() {
		return periodo;
	}

	public double calcularPrecio() {
		return this.periodo.sizeInDays() * this.propiedad.getPrecioXnoche();
	}

}
