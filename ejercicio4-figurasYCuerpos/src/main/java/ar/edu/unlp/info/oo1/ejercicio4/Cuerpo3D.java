package ar.edu.unlp.info.oo1.ejercicio4;

public class Cuerpo3D {
	private double altura;
	private Figura caraBasal;

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public void setCaraBasal(Figura f) {
		this.caraBasal = f;
	}

	public Figura getCaraBasal() {
		return caraBasal;
	}
	
	public double getVolumen() {
		return getCaraBasal().getArea() * getAltura();
	}
	
	public double getSuperficieExterior() {
		return 2 * getCaraBasal().getArea() + getCaraBasal().getPerimetro() * getAltura();
	}
}
