package ar.edu.unlp.info.oo1.balanzaElectronica;

import java.time.LocalDate;
import java.util.ArrayList;

public class Ticket {
	private LocalDate fecha;
	private int cantidadDeProductos;
	private double pesoTotal;
	private double precioTotal;
	private ArrayList<Producto> productos;
	
	
	public Ticket( int cantidadDeProductos, double pesoTotal, double precioTotal, ArrayList<Producto> productos) {
		this.fecha = LocalDate.now();
		this.cantidadDeProductos = cantidadDeProductos;
		this.pesoTotal = pesoTotal;
		this.precioTotal = precioTotal;
		this.productos = productos;
	}

	public double impuesto() {
		return this.precioTotal*0.21;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public int getCantidadDeProductos() {
		return cantidadDeProductos;
	}

	public double getPesoTotal() {
		return pesoTotal;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}
		
}
