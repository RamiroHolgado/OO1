package ar.edu.unlp.info.oo1.ejercicio6_RedDeAlumbrado;

import java.util.ArrayList;
import java.util.List;

public class Farola {
	private List<Farola> l;
	private boolean on;

	/*
	 * Crear una farola. Debe inicializarla como apagada
	 */
	public Farola() {
		this.l = new ArrayList<Farola>();
		this.on = false;
	}

	/*
	 * Crea la relación de vecinos entre las farolas. La relación de vecinos entre
	 * las farolas es recíproca, es decir el receptor del mensaje será vecino de
	 * otraFarola, al igual que otraFarola también se convertirá en vecina del
	 * receptor del mensaje
	 */
	public void pairWithNeighbor(Farola otraFarola) {
		this.l.add(otraFarola);
		otraFarola.getNeighbors().add(this);
	}

	/*
	 * Retorna sus farolas vecinas
	 */
	public List<Farola> getNeighbors() {
		return l;
	}

	/*
	 * Si la farola no está encendida, la enciende y propaga la acción.
	 */
	public void turnOn() {
		if (!this.on) {
			this.on = true;
			getNeighbors().forEach(f -> f.turnOn()); // f.on = true
		}
	}

	/*
	 * Si la farola no está apagada, la apaga y propaga la acción.
	 */
	public void turnOff () {
		if (this.on) {
			this.on = false;
			this.l.forEach(v -> v.turnOff());
		}
	}

	/*
	 * Retorna true si la farola está encendida.
	 */
	public boolean isOn () {
		return this.on;
	}
	
}