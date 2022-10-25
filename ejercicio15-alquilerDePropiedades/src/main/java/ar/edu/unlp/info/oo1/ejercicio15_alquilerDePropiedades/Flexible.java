package ar.edu.unlp.info.oo1.ejercicio15_alquilerDePropiedades;

public class Flexible extends Propiedad {

	public Flexible(String nombre, String descripcion, String direccion, double precioXnoche) {
		super(nombre, descripcion, direccion, precioXnoche);
	}

	public double retornoDeCancelacion(Reserva r) {
		return r.calcularPrecio();
	}

}
