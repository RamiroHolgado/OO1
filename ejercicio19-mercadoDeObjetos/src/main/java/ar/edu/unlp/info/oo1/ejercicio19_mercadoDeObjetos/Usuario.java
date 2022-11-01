package ar.edu.unlp.info.oo1.ejercicio19_mercadoDeObjetos;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String nombre;
	private String direccion;
	private List<Producto> productos;
	private List<Pedido> pedidos;

	public Usuario(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.productos = new ArrayList<>();
		this.pedidos = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void agregarProducto(Producto p) {
		this.productos.add(p);
	}

	public List<Producto> buscarProducto(String nombre) {
		return this.productos.stream().filter(p -> p.getNombre().equals(nombre)).toList();
	}

	public void crearPedido(Producto p, int cant, String formaDePago, String formaDeEnvio) {
		if (p.getUnidadesDisponibles() >= cant) {
			Pedido p1 = new Pedido(this, p, cant, formaDePago, formaDeEnvio);
			this.pedidos.add(p1);
			p.setUnidadesDisponibles(p.getUnidadesDisponibles() - cant);
		}
	}
}
