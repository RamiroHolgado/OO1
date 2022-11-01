package ar.edu.unlp.info.oo1.ejercicio18_liquidacionDeHaberes;

import java.time.LocalDate;

public class DePlanta extends Contrato {
	private double sueldo;
	private double montoXconyuge;
	private double montoXhijos;

	public DePlanta(Empleado empleado, LocalDate inicio, LocalDate fin, double sueldo, double montoXconyuge,
			double montoXhijos) {
		super(empleado, inicio, null);
		this.sueldo = sueldo;
		this.montoXconyuge = montoXconyuge;
		this.montoXhijos = montoXhijos;
	}

	public double getSueldo() {
		return sueldo;
	}

	public double getMontoXconyuge() {
		return montoXconyuge;
	}

	public double getMontoXhijos() {
		return montoXhijos;
	}

	@Override
	public boolean estaActivo() {
		return super.getFin() == null;
	}

	private double calcularSueldoXantiguedad() {
		int antiguedad = LocalDate.now().getYear() - super.getInicio().getYear();
		switch (antiguedad) {
		case 5:
			return this.sueldo * 1.3;

		case 10:
			return this.sueldo * 1.5;

		case 15:
			return this.sueldo * 1.7;

		case 20:
			return this.sueldo * 2;

		default:
			return this.sueldo;
		}
	}

	@Override
	public double calcularSueldo() {
		double total = this.calcularSueldoXantiguedad();
		if (super.getEmpleado().isTieneConyuge())
			total += this.montoXconyuge;
		if (super.getEmpleado().isTieneHijos())
			total += this.montoXhijos;
		return total;
	}

}
