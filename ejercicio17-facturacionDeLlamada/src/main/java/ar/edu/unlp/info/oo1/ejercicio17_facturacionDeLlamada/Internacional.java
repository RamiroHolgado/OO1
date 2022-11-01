package ar.edu.unlp.info.oo1.ejercicio17_facturacionDeLlamada;

import java.time.LocalDate;
import java.time.LocalTime;

public class Internacional extends Llamada {

	private String paisOrigen;
	private String paisDestino;

	public Internacional(LocalDate fecha, LocalTime hora, int duracion, int numeroEmisor, int numeroReceptor,
			String paisOrigen, String paisDestino) {
		super(fecha, hora, duracion, numeroEmisor, numeroReceptor);
		this.paisOrigen = paisOrigen;
		this.paisDestino = paisDestino;
	}

	public String getPaisOrigen() {
		return paisOrigen;
	}

	public String getPaisDestino() {
		return paisDestino;
	}

	private int diurnoONocturno(LocalTime d) {
		if (d.getHour() >= 8 && d.getHour() <= 20)
			return 4;
		else
			return 3;
	}

	public double calcularCosto() {
		return super.getDuracion() * this.diurnoONocturno(super.getHora());
	}

}
