package ar.edu.unlp.info.oo1.ejercicio4;

public class Circulo implements Figura {	
	private double radio;
	
	public Circulo() {}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}
	
	public double getDiametro() {
		return getRadio() * 2;
	}
	public double getPerimetro() {
		return Math.PI * getDiametro();
	}
	public double getArea() {
		return Math.PI * Math.pow(getRadio(), 2);		
	}
	
	
}
