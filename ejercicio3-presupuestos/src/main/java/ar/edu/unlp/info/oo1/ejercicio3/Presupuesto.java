package ar.edu.unlp.info.oo1.ejercicio3;

import java.time.LocalDate;
import java.util.ArrayList;

public class Presupuesto {
	private LocalDate fecha;
	private String cliente;
	private ArrayList<Item> items;
	
	public Presupuesto() {
		this.fecha = LocalDate.now();
		items = new ArrayList<Item>();
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public String getCliente() {
		return cliente;
	}

	public Presupuesto cliente(String cliente) {
		this.cliente = cliente;
		return this;
	}
	
	public void agregarItem(Item i) {
		items.add(i);
		
	}
	
	public double calcularTotal() {		
		return items.stream().mapToDouble(total -> total.costo()).sum();
	}
	
	
}
