package ar.edu.unlp.info.oo1.ejercicio12_volumenYSuperficie;

import java.util.ArrayList;
import java.util.List;

public class ReporteDeConstruccion {

	private List<Pieza> piezas;

	public ReporteDeConstruccion() {
		this.piezas = new ArrayList<>();
	}

	public void agregarPieza(Pieza p) {
		this.piezas.add(p);
	}

	public List<Pieza> getPiezas() {
		return piezas;
	}

	public double volumenDeMaterial(String m) {
		return this.piezas.stream().filter(p -> p.getMaterial().equals(m)).mapToDouble(p -> p.volumen()).sum();
	}

	public double superficieDeColor(String c) {
		return this.piezas.stream().filter(p -> p.getColor().equals(c)).mapToDouble(p -> p.superficie()).sum();
	}

}
