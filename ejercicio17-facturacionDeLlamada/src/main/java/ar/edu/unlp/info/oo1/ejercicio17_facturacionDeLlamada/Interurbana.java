package ar.edu.unlp.info.oo1.ejercicio17_facturacionDeLlamada;

import java.time.LocalDate;
import java.time.LocalTime;

public class Interurbana extends Llamada {

	private double distancia;

	public Interurbana(LocalDate fecha, LocalTime hora, int duracion, int numeroEmisor, int numeroReceptor,
			double distancia) {
		super(fecha, hora, duracion, numeroEmisor, numeroReceptor);
		this.distancia = distancia;
	}

	public double getDistancia() {
		return distancia;
	}

	public double calcularCosto() {
		if (this.distancia < 100)
			return super.getDuracion() * 2 + 5;
		else if (this.distancia >= 100 && this.distancia <= 500)
			return super.getDuracion() * 2.5 + 5;
		else
			return super.getDuracion() * 3 + 5;
	}
}
