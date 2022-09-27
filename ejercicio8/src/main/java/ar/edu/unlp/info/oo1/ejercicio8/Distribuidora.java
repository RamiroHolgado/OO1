package ar.edu.unlp.info.oo1.ejercicio8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Distribuidora {
	private double precioKWh;
	private List<Usuario> usuarios;
	
	public Distribuidora(double precioKWh) {
		this.precioKWh = precioKWh;
		this.usuarios = new ArrayList<Usuario>();
	}
	public void agregarUsuario(Usuario u) {
		usuarios.add(u);
	}
	
	public List<Factura> facturar(){
		List<Factura> l = this.usuarios.stream().map(u -> u.facturarEnBaseA(this.getPrecioKWh()))
				.collect(Collectors.toList());	
		return l;
	}
	
	public double consumoTotalActiva() {
		return this.usuarios.stream().mapToDouble(u -> u.ultimoConsumoActiva()).sum();
	}

	public double getPrecioKWh() {
		return precioKWh;
	}

	public List<Usuario> getUsuarios() {
		return new ArrayList<>(this.usuarios);
	} 	
	
	
}
