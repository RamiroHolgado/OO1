package ar.edu.unlp.info.oo1.ejercicio15_alquilerDePropiedades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Propiedad {
	private String nombre;
	private String descripcion;
	private double precioXnoche;
	private String direccion;
	private Usuario propietario;
	private List<Reserva> reservas;

	public Propiedad(String nombre, String descripcion, double precioXnoche, String direccion, Usuario propietario) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioXnoche = precioXnoche;
		this.direccion = direccion;
		this.propietario = propietario;
		this.reservas = new ArrayList<Reserva>();
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public double getPrecioXnoche() {
		return precioXnoche;
	}

	public String getDireccion() {
		return direccion;
	}

	public Usuario getPropietario() {
		return propietario;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void agregarReserva(Reserva r) {
		this.reservas.add(r);
	}

	public boolean estaDisponible(DateLapse dl) {
		return this.reservas.stream().noneMatch(r -> r.getPeriodo().overlaps(dl));
	}

	public double ingresosPorReservas(LocalDate f1, LocalDate f2) {
		return this.reservas.stream().filter(r -> r.getPeriodo().getFrom().isBefore(f2) && r.getPeriodo().getTo().isAfter(f1))
				.mapToDouble(r -> r.calcularPrecio()).sum();
	}

}
