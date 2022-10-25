package ar.edu.unlp.info.oo1.ejercicio15_alquilerDePropiedades;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Moderada extends Propiedad {

	public Moderada(String nombre, String descripcion, String direccion, double precioXnoche) {
		super(nombre, descripcion, direccion, precioXnoche);
	}

	public double retornoDeCancelacion(Reserva r) {
		int dias = (int) LocalDate.now().until(r.getPeriodo().getFrom(),ChronoUnit.DAYS);
		if (dias >= 7)
			return r.calcularPrecio();
		else if (dias >= 2)
			return r.calcularPrecio()/2;
		else
			return 0;
	}

}
