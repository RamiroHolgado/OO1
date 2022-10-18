package ar.edu.unlp.info.oo1.ejercicio15_alquilerDePropiedades;

import java.util.ArrayList;

public class Usuario {
	private String nombre;
	private String direccion;
	private int dni;
	private ArrayList<Propiedad> enAlquiler;
	private ArrayList<Reserva> reservas;
	
	public Usuario(String nombre, String direccion, int dni) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.dni = dni;
		this.enAlquiler = new ArrayList<>();
		this.reservas = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public int getDni() {
		return dni;
	}

	public ArrayList<Propiedad> getEnAlquiler() {
		return enAlquiler;
	}

	public ArrayList<Reserva> getReservas() {
		return reservas;
	}
	
	public void agregarPropiedad(Propiedad p) {
		this.enAlquiler.add(p);
	}
	
	public void agregarReserva(Reserva r) {
		this.reservas.add(r);
	}
		
}
