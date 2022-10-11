package ar.edu.unlp.info.oo1.ejercicio13_clienteDeCorreo;

import java.util.ArrayList;
import java.util.List;

public class Carpeta {

	private String nombre;
	private List<Email> emails;

	public Carpeta(String nombre) {
		this.nombre = nombre;
		this.emails = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Email> getEmails() {
		return emails;
	}

	public void agregarEmail(Email e) {
		this.emails.add(e);
	}

	public int tamaño() {
		return this.emails.stream().mapToInt(e -> e.tamaño()).sum();
	}
}
