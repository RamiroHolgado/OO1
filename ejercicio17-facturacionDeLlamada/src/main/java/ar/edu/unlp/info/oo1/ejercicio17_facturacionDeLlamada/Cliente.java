package ar.edu.unlp.info.oo1.ejercicio17_facturacionDeLlamada;

import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
	private String nombre;
	private String direccion;
	private int numero;
	private List<Llamada> llamadas;

	public Cliente(String nombre, String direccion, int numero) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.numero = numero;
		this.llamadas = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public int getNumero() {
		return numero;
	}

	public List<Llamada> getLlamadas() {
		return llamadas;
	}

	public void agregarLlamada(Llamada l) {
		this.llamadas.add(l);
	}

	public abstract Factura facturarLlamadas(DateLapse d);
}
