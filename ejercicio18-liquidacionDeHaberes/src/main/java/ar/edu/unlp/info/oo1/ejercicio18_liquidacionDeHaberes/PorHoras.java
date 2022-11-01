package ar.edu.unlp.info.oo1.ejercicio18_liquidacionDeHaberes;

import java.time.LocalDate;

public class PorHoras extends Contrato {
	private double valorHora;
	private int horasXmes;

	public PorHoras(Empleado empleado, LocalDate inicio, LocalDate fin, double valorHora, int horasXmes) {
		super(empleado, inicio, fin);
		this.valorHora = valorHora;
		this.horasXmes = horasXmes;
	}

	public double getValorHora() {
		return valorHora;
	}

	public int getHorasXmes() {
		return horasXmes;
	}

	@Override
	public boolean estaActivo() {
		return super.getFin().isAfter(LocalDate.now());
	}

	@Override
	public double calcularSueldo() {
		return this.valorHora * this.horasXmes;
	}

}
