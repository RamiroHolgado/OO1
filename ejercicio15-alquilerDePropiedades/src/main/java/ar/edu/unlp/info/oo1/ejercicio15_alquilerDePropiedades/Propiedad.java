package ar.edu.unlp.info.oo1.ejercicio15_alquilerDePropiedades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Propiedad {
	private String nombre;
	private String descripcion;
	private String direccion;
	private double precioXnoche;
	private List<Reserva> reservas;

	public Propiedad(String nombre, String descripcion, String direccion, double precioXnoche) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.direccion = direccion;
		this.precioXnoche = precioXnoche;
		this.reservas = new ArrayList<Reserva>();
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getDireccion() {
		return direccion;
	}

	public double getPrecioXnoche() {
		return precioXnoche;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void agregarReserva(Reserva r) {
		this.reservas.add(r);
	}

	public void eliminarReserva(Reserva r) {
		if (r.getPeriodo().getFrom().isAfter(LocalDate.now()))
			this.reservas.remove(r);
	}

	public boolean estaDisponible(DateLapse dl) {
		return this.reservas.stream().noneMatch(r -> r.getPeriodo().overlaps(dl));
	}

	public double calcularIngresos(DateLapse dl) {
		return this.getReservas().stream().filter(r -> r.getPeriodo().overlaps(dl)).mapToDouble(r -> r.calcularPrecio())
				.sum();
	}
}
