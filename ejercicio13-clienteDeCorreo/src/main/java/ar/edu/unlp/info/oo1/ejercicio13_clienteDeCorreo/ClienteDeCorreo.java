package ar.edu.unlp.info.oo1.ejercicio13_clienteDeCorreo;

import java.util.ArrayList;
import java.util.List;

public class ClienteDeCorreo {

	private List<Carpeta> carpetas = new ArrayList<>();

	public ClienteDeCorreo() {
		this.carpetas.add(new Carpeta("inbox"));

	}

	public List<Carpeta> getCarpetas() {
		return carpetas;
	}

	public void agregarCarpeta(Carpeta c) {
		this.carpetas.add(c);
	}

	public void recibir(Email e) {
		this.carpetas.get(0).agregarEmail(e);
	}

	public void mover(Email e, Carpeta origen, Carpeta destino) {
		destino.agregarEmail(e);
		origen.getEmails().remove(e);
	}

	public Email buscar(String texto) {

		for (Carpeta carpeta : carpetas) {
			for (Email e : carpeta.getEmails()) {
				if (e.getTitulo().equals(texto) || e.getCuerpo().equals(texto))
					return e;
			}
		}

		return null;

	}

	public int espacioOcupado() {
		return this.carpetas.stream().mapToInt(c -> c.tamaño()).sum();

	}

}
