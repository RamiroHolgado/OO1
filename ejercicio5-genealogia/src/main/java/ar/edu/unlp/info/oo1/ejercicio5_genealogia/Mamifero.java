package ar.edu.unlp.info.oo1.ejercicio5_genealogia;

import java.time.LocalDate;

public class Mamifero {
	private String identificador;
	private String especie;
	private LocalDate nacimiento;
	private Mamifero padre;
	private Mamifero madre;
	
	public Mamifero() {}
	
	public Mamifero(String identificador) {
		this.identificador = identificador;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public LocalDate getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(LocalDate nacimiento) {
		this.nacimiento = nacimiento;
	}

	public Mamifero getPadre() {
		return padre;
	}

	public void setPadre(Mamifero padre) {
		this.padre = padre;
	}

	public Mamifero getMadre() {
		return madre;
	}

	public void setMadre(Mamifero madre) {
		this.madre = madre;
	}
	
	public Mamifero getAbueloMaterno() {
		if (this.getMadre() != null) {
			return this.getMadre().getPadre();			
		}else {
			return null;
		}
	}
	
	public Mamifero getAbuelaMaterna() {
		if (this.getMadre() != null) {
			return this.getMadre().getMadre();			
		}else {
			return null;
		}
	}
	
	public Mamifero getAbueloPaterno() {
		if (this.getPadre() != null) {
			return this.getPadre().getPadre();			
		}else {
			return null;
		}
	}
	
	public Mamifero getAbuelaPaterna() {
		if (this.getPadre() != null) {
			return this.getPadre().getMadre();			
		}else {
			return null;
		}
	}
	
	
//	public boolean tieneComoAncestroA(Mamifero m) {
//		if (m.equals(getMadre()) || m.equals(getPadre()) || m.equals(getAbuelaMaterna()) || 
//				m.equals(getAbuelaPaterna()) || m.equals(getAbueloMaterno()) || m.equals(getAbueloPaterno())) {
//			return true;
//		}else {
//			return false;
//		}
//	}
	
	public boolean ancestro(Mamifero x, Mamifero m) {
		return (x != null) && (x.equals(m) || x.tieneComoAncestroA(m));
	}
	
	public boolean tieneComoAncestroA(Mamifero m) {
		return ancestro(this.getMadre(), m) || ancestro(this.getPadre(), m);
	}
}
