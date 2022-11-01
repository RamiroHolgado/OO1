package ar.edu.unlp.info.oo1.ejercicio18_liquidacionDeHaberes;

import java.time.LocalDate;

public abstract class Contrato {
	private Empleado empleado;
	private LocalDate inicio;
	private LocalDate fin;

	public Contrato(Empleado empleado, LocalDate inicio, LocalDate fin) {
		this.empleado = empleado;
		this.inicio = inicio;
		this.fin = fin;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public LocalDate getInicio() {
		return inicio;
	}

	public LocalDate getFin() {
		return fin;
	}

	public abstract boolean estaActivo();

	public abstract double calcularSueldo();
}
