package ar.edu.unlp.info.oo1.ejercicio15_alquilerDePropiedades;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sistema {
	private List<Usuario> usuarios;

	public Sistema() {
		this.usuarios = new ArrayList<>();
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public List<Propiedad> getPropiedades() {
		return this.usuarios.stream().flatMap(u -> u.getEnAlquiler().stream()).collect(Collectors.toList());

	}

	public void agregarUsuario(Usuario u) {
		this.usuarios.add(u);
	}

	public void agregarReserva(Reserva r, Usuario inquilino) {
		inquilino.agregarReserva(r);
		r.getPropiedad().agregarReserva(r);
	}

	public List<Propiedad> disponiblesEnPeriodo(DateLapse dl) {
		return this.getPropiedades().stream().filter(p -> p.estaDisponible(dl)).collect(Collectors.toList());
	}

	public List<Reserva> reservasDeUsuario(Usuario u) {
		return this.usuarios.get(this.usuarios.indexOf(u)).getReservas();
	}

}
