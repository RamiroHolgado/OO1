package ar.edu.unlp.info.oo1.ejercicio18_liquidacionDeHaberes;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Empleado> empleados;

	public Sistema() {
		this.empleados = new ArrayList<>();
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void agregarEmpleado(Empleado e) {
		this.empleados.add(e);
	}

	public void eliminarEmpleado(Empleado e) {
		this.empleados.remove(e);
	}

	public Empleado buscarEmpleado(int cuil) {
		return this.empleados.stream().filter(e -> e.getCuil() == cuil).findAny().orElse(null);
	}

	public List<Empleado> getEmpleadosConContratoVencido() {
		return this.empleados.stream().filter(e -> !e.contratoVencido()).toList();
	}
}
