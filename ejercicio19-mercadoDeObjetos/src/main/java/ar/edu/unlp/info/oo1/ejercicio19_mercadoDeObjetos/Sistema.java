package ar.edu.unlp.info.oo1.ejercicio19_mercadoDeObjetos;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Usuario> usuarios;

	public Sistema() {
		this.usuarios = new ArrayList<>();
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void agregarUsuario(Usuario u) {
		this.usuarios.add(u);
	}

	public Usuario buscarUsuario(String nombre) {
		return this.usuarios.stream().filter(u -> u.getNombre().equals(nombre)).findAny().orElse(null);
	}

}
