package ar.edu.unlp.info.oo1.ejercicio17_facturacionDeLlamada;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Integer> numeros;
	private List<Cliente> clientes;
	
	public Sistema() {
		this.numeros = new ArrayList<>();
		this.clientes = new ArrayList<>();
	}
	
	public List<Integer> getNumeros() {
		return numeros;
	}
	public List<Cliente> getClientes() {
		return clientes;
	}
	
	public void agregarNumero(Integer n) {
		this.numeros.add(n);
	}
	
	public void eliminarNumero(Integer n) {
		this.numeros.remove(n);
	}
	
	public void agregarCliente(Cliente c) {
		this.clientes.add(c);
	}
	
}
