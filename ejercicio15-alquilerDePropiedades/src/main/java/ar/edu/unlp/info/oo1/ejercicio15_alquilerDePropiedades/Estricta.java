package ar.edu.unlp.info.oo1.ejercicio15_alquilerDePropiedades;

public class Estricta extends Propiedad {

	public Estricta(String nombre, String descripcion, String direccion, double precioXnoche) {
		super(nombre, descripcion, direccion, precioXnoche);
	}

	public double retornoDeCancelacion(Reserva r) {
		return 0;
	}

}
