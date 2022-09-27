package ar.edu.unlp.info.oo1.ejercicio8;

import java.time.LocalDate;

public class Consumo {
	private LocalDate fecha;
	private double consumoEnergiaActiva;
	private double consumoEnergiaReactiva;
	
	
	public Consumo(double consumoEnergiaActiva, double consumoEnergiaReactiva) {		
		this.fecha = LocalDate.now();
		this.consumoEnergiaActiva = consumoEnergiaActiva;
		this.consumoEnergiaReactiva = consumoEnergiaReactiva;
	}

	public double costoEnBaseA(double precioKWh) {
		return precioKWh * getConsumoEnergiaActiva();
	}
	
	public double factorDePotencia() {
		return getConsumoEnergiaActiva() / Math.sqrt(Math.pow(getConsumoEnergiaActiva(), 2)
				+ Math.pow(getConsumoEnergiaReactiva(), 2));
	}

	
	public double getConsumoEnergiaReactiva() {
		return consumoEnergiaReactiva;
	}

	public double getConsumoEnergiaActiva() {
		return consumoEnergiaActiva;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	
}
