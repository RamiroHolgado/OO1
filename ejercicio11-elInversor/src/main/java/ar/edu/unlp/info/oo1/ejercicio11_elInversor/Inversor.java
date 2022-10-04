package ar.edu.unlp.info.oo1.ejercicio11_elInversor;

import java.util.ArrayList;
import java.util.List;

public class Inversor implements Inversion {

	private String nombre;
	private List<Inversion> inversiones;

	public Inversor(String nombre) {
		this.nombre = nombre;
		this.inversiones = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}
	
	public void agregarInversion(Inversion i) {
		this.inversiones.add(i);
	}

	@Override
	public double valorActual() {
		return this.inversiones.stream().mapToDouble(i -> i.valorActual()).sum();
	}

}
