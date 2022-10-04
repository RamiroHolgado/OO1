package ar.edu.unlp.info.oo1.ejercicio11_elInversor;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;

public class PlazoFijo implements Inversion {

	private LocalDate fechaDeConstitucion;
	private double montoDepositado;
	private double porcentajeDeInteresDiario;

	public PlazoFijo(LocalDate fechaDeConstitucion, double montoDepositado, double porcentajeDeInteresDiario) {
		this.fechaDeConstitucion = fechaDeConstitucion;
		this.montoDepositado = montoDepositado;
		this.porcentajeDeInteresDiario = porcentajeDeInteresDiario;
	}

	public LocalDate getFechaDeConstitucion() {
		return fechaDeConstitucion;
	}

	public double getMontoDepositado() {
		return montoDepositado;
	}

	public double getPorcentajeDeInteresDiario() {
		return porcentajeDeInteresDiario;
	}

	private double porcentajeTotal() {
		return this.montoDepositado * this.porcentajeDeInteresDiario / 100;
	}

	@Override
	public double valorActual() {	
		long dias = DAYS.between(this.fechaDeConstitucion, LocalDate.now());
		return this.montoDepositado + (porcentajeTotal() * dias);

	}

}
