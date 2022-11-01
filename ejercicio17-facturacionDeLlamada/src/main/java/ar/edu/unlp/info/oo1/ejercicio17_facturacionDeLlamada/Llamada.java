package ar.edu.unlp.info.oo1.ejercicio17_facturacionDeLlamada;

import java.time.LocalDate;
import java.time.LocalTime;

public class Llamada {

	private LocalDate fecha;
	private LocalTime hora;
	private int duracion;
	private int numeroEmisor;
	private int numeroReceptor;

	public Llamada(LocalDate fecha, LocalTime hora, int duracion, int numeroEmisor, int numeroReceptor) {
		this.fecha = fecha;
		this.hora = hora;
		this.duracion = duracion;
		this.numeroEmisor = numeroEmisor;
		this.numeroReceptor = numeroReceptor;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public int getDuracion() {
		return duracion;
	}

	public int getNumeroEmisor() {
		return numeroEmisor;
	}

	public int getNumeroReceptor() {
		return numeroReceptor;
	}

	public double calcularCosto() {
		return this.duracion;
	}

}
