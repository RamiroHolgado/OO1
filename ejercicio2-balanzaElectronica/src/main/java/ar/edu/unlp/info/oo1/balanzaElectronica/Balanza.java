package ar.edu.unlp.info.oo1.balanzaElectronica;

import java.util.ArrayList;

public class Balanza {
	private int cantidadDeProductos;
	private double precioTotal;
	private double pesoTotal;
	private ArrayList<Producto> productos;
	
	public Balanza() {}
	
	public void ponerEnCero() {
		this.pesoTotal = 0;
		this.precioTotal = 0;
		this.cantidadDeProductos = 0;
		this.productos = new ArrayList<Producto>();
	}

	public void agregarProducto(Producto p) {
		this.cantidadDeProductos++;
		this.precioTotal += p.getPrecio();
		this.pesoTotal += p.getPeso();
		this.productos.add(p);
	}
	
	public Ticket emitirTicket() {
		return new Ticket(this.cantidadDeProductos,this.pesoTotal,this.precioTotal,getProductos());
	}

	public int getCantidadDeProductos() {
		return cantidadDeProductos;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public double getPesoTotal() {
		return pesoTotal;
	}	
		
	public ArrayList<Producto> getProductos(){
		return this.productos;
	}
}
