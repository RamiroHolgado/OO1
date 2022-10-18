package ar.edu.unlp.info.oo1.ejercicio15_alquilerDePropiedades;

public class Reserva {
	private Propiedad propiedad;
	private DateLapse periodo;
	private Usuario inquilino;
	
	public Reserva(Propiedad propiedad, DateLapse periodo, Usuario inquilino) {
		this.propiedad = propiedad;
		this.periodo = periodo;
		this.inquilino = inquilino;
	}

	public Propiedad getPropiedad() {
		return propiedad;
	}

	public DateLapse getPeriodo() {
		return periodo;
	}

	public Usuario getInquilino() {
		return inquilino;
	}
		
	public double calcularPrecio() {	
		return this.periodo.sizeInDays() * this.propiedad.getPrecioXnoche();
	}
	
}
