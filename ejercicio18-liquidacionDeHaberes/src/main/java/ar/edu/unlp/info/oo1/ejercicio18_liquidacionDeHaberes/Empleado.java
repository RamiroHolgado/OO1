package ar.edu.unlp.info.oo1.ejercicio18_liquidacionDeHaberes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Empleado {
	private String nombre;
	private String apellido;
	private int cuil;
	private LocalDate nacimiento;
	private boolean tieneConyuge;
	private boolean tieneHijos;
	private List<Contrato> contratos;

	public Empleado(String nombre, String apellido, int cuil, LocalDate nacimiento, boolean tieneConyuge,
			boolean tieneHijos) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.cuil = cuil;
		this.nacimiento = nacimiento;
		this.tieneConyuge = tieneConyuge;
		this.tieneHijos = tieneHijos;
		this.contratos = new ArrayList<>();
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

	public LocalDate getNacimiento() {
		return nacimiento;
	}

	public boolean isTieneConyuge() {
		return tieneConyuge;
	}

	public boolean isTieneHijos() {
		return tieneHijos;
	}

	public List<Contrato> getContratos() {
		return contratos;
	}

	public Contrato ultimoContrato() {
		return this.contratos.get(this.contratos.size() - 1);
	}

	public void agregarContrato(Contrato c) {
		this.contratos.add(c);
	}

	public boolean contratoVencido() {
		return this.contratos.get(this.contratos.size() - 1).estaActivo();
	}

	public Recibo generarRecibo() {
		double monto = this.contratos.get(this.contratos.size() - 1).calcularSueldo();
		return new Recibo(this.nombre, this.apellido, this.cuil, ultimoContrato().getInicio(), LocalDate.now(), monto);
	}

}
