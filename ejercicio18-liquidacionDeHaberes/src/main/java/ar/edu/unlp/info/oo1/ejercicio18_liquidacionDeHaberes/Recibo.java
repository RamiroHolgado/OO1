package ar.edu.unlp.info.oo1.ejercicio18_liquidacionDeHaberes;

import java.time.LocalDate;

public class Recibo {
	private String nombre;
	private String apellido;
	private int cuil;
	private int antiguedad;
	private LocalDate fechaEmision;
	private double monto;

	public Recibo(String nombre, String apellido, int cuil, LocalDate antiguedad, LocalDate fechaEmision,
			double monto) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.cuil = cuil;
		this.antiguedad = LocalDate.now().getYear() - antiguedad.getYear();
		this.fechaEmision = fechaEmision;
		this.monto = monto;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public int getCuil() {
		return cuil;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	public LocalDate getFechaEmision() {
		return fechaEmision;
	}

	public double getMonto() {
		return monto;
	}

}
