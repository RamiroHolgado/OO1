package ar.edu.unlp.info.oo1.ejercicio12_volumenYSuperficie;

public class Cilindro extends Pieza {

	private int radio;
	private int altura;

	public Cilindro(String material, String color, int radio, int altura) {
		super(material, color);
		this.radio = radio;
		this.altura = altura;
	}

	public int getRadio() {
		return radio;
	}

	public int getAltura() {
		return altura;
	}

	@Override
	public double volumen() {
		return Math.PI * Math.pow(this.radio, 2) * this.altura;
	}

	@Override
	public double superficie() {
		return 2 * Math.PI * this.radio * this.altura + 2 * Math.pow(this.radio, 2);
	}

}
