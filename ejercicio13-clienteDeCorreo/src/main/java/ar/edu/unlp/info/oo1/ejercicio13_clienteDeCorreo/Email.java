package ar.edu.unlp.info.oo1.ejercicio13_clienteDeCorreo;

import java.util.ArrayList;
import java.util.List;

public class Email {

	private String titulo;
	private String cuerpo;
	private List<Archivo> archivos;

	public Email(String titulo, String cuerpo) {
		this.titulo = titulo;
		this.cuerpo = cuerpo;
		this.archivos = new ArrayList<>();
	}

	public String getTitulo() {
		return titulo;
	}

	public String getCuerpo() {
		return cuerpo;
	}

	public List<Archivo> getArchivos() {
		return archivos;
	}

	public int tamaño() {
		return this.titulo.length() + this.cuerpo.length()
				+ this.archivos.stream().mapToInt(a -> a.getNombre().length()).sum();
	}
}
