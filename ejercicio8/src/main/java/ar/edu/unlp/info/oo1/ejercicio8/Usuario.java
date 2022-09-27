package ar.edu.unlp.info.oo1.ejercicio8;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String nombre;
	private String domicilio;
	private List<Consumo> consumos;
	private List<Factura> facturas;
	
	
	
	public Usuario(String nombre, String domicilio) {		
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.consumos = new ArrayList<Consumo>();
		this.facturas = new ArrayList<Factura>();
	}

	public void agregarMedicion(Consumo c) {
		this.consumos.add(c);
	}
	
	public Consumo ultimoConsumo() {
		if (this.consumos.size() != 0)
			return this.consumos.get(this.consumos.size() - 1);
		return null;
	
	}
	
	public double ultimoConsumoActiva() {
		if (this.ultimoConsumo() != null)
			return this.ultimoConsumo().getConsumoEnergiaActiva();
		return 0;
	}
	
	public Factura facturarEnBaseA(double precioKWh) {
		Consumo c = this.ultimoConsumo();
		
		if (c == null)
			return new Factura(0,0,this);
		
		double descuento = 0;
		if (c.factorDePotencia() > 0.8)
			descuento = 10;
		return new Factura(c.costoEnBaseA(precioKWh), descuento, this);
	}
	
	public List<Consumo> getConsumos() {
		return consumos;
	}

	public List<Factura> facturas() {
		return new ArrayList<>(this.facturas);
	}

	
	public String getDomicilio() {
		return domicilio;
	}

	public String getNombre() {
		return nombre;
	}
	
	
}
