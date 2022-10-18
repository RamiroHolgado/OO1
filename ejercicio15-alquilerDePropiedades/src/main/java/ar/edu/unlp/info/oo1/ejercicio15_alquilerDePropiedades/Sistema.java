package ar.edu.unlp.info.oo1.ejercicio15_alquilerDePropiedades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sistema {
	private List<Usuario> usuarios;
	private List<Propiedad> propiedades;

	public Sistema() {
		this.usuarios = new ArrayList<>();
		this.propiedades = new ArrayList<>();
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public List<Propiedad> getPropiedades() {
		return this.propiedades;

	}

	public void agregarUsuario(Usuario u) {
		this.usuarios.add(u);
	}

	public void registrarPropiedad(Propiedad propiedad) {
		this.usuarios.get(this.usuarios.indexOf(propiedad.getPropietario())).agregarPropiedad(propiedad);
		this.propiedades.add(propiedad);
	}

	public List<Propiedad> disponiblesEnPeriodo(DateLapse dl) {
		return this.getPropiedades().stream().filter(p -> p.estaDisponible(dl)).collect(Collectors.toList());
	}

	public void hacerReserva(Propiedad p, DateLapse dl, Usuario u) {
		if (getPropiedades().get(getPropiedades().indexOf(p)).estaDisponible(dl)) {
			Reserva r = new Reserva(p, dl, u);

			getPropiedades().get(getPropiedades().indexOf(p)).agregarReserva(r);
			this.usuarios.get(this.usuarios.indexOf(u)).agregarReserva(r);
		}
	}

	public void eliminarReserva(Reserva r) {
		if (r.getPeriodo().getFrom().isBefore(LocalDate.now())) {
			getPropiedades().stream().filter(p -> p.equals(r.getPropiedad())).map(p -> p.getReservas().remove(r));
			this.usuarios.get(this.usuarios.indexOf(r.getInquilino())).getReservas().remove(r);
		}
	}

	public List<Reserva> reservasDeUsuario(Usuario u) {
		return this.usuarios.get(this.usuarios.indexOf(u)).getReservas();
	}

	public double ingresosDePropietario(Usuario u, LocalDate f1, LocalDate f2) {
		return this.usuarios.get(this.usuarios.indexOf(u)).getEnAlquiler().stream()
				.mapToDouble(p -> p.ingresosPorReservas(f1, f2)).sum();
	}

}
