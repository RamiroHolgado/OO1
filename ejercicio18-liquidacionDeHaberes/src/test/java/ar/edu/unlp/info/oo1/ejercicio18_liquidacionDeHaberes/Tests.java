package ar.edu.unlp.info.oo1.ejercicio18_liquidacionDeHaberes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Tests {
	Sistema s;
	Empleado e1, e2, e3, e4;
	Contrato c1, c2, c3, c4;

	@BeforeEach
	public void setup() {
		s = new Sistema();
		e1 = new Empleado("EMPLEADO 1", "apellido1", 11111111, LocalDate.of(1950, 1, 1), true, true);
		e2 = new Empleado("EMPLEADO 2", "apellido2", 22222222, LocalDate.of(2000, 1, 1), false, false);
		e3 = new Empleado("EMPLEADO 3", "apellido3", 33333333, LocalDate.of(2000, 1, 1), false, false);
		e4 = new Empleado("EMPLEADO 4", "apellido4", 44444444, LocalDate.of(2000, 1, 1), false, false);
		s.agregarEmpleado(e1);
		s.agregarEmpleado(e2);
		s.agregarEmpleado(e3);
		s.agregarEmpleado(e4);

		c1 = new DePlanta(e1, LocalDate.of(1990, 1, 1), null, 100000, 10000, 10000);
		c2 = new PorHoras(e2, LocalDate.of(2020, 1, 1), LocalDate.of(2023, 1, 1), 4000, 40);
		c3 = new PorHoras(e3, LocalDate.of(2010, 1, 1), LocalDate.of(2020, 1, 1), 4000, 40);
		c4 = new PorHoras(e4, LocalDate.of(2010, 1, 1), LocalDate.of(2020, 1, 1), 4000, 40);
		e1.agregarContrato(c1);
		e2.agregarContrato(c2);
		e3.agregarContrato(c3);
		e4.agregarContrato(c4);
	}

	@Test
	public void testBuscarEmpleado() {
		assertEquals(e3, s.buscarEmpleado(33333333));
	}

	@Test
	public void testDarDeBajaEmpleado() {
		s.eliminarEmpleado(e1);
		assertNotEquals(e1, s.buscarEmpleado(11111111));
	}

	@Test
	public void testCargarContrato() {
		Contrato c = new PorHoras(e3, LocalDate.of(2020, 1, 1), LocalDate.of(2023, 1, 1), 4000, 40);
		e3.agregarContrato(c);
		assertTrue(e3.getContratos().contains(c));
	}

	@Test
	public void testEmpleadosConContratoVencido() {
		assertEquals(2, s.getEmpleadosConContratoVencido().size());
	}

	@Test
	public void testGenerarRecibo() {
		Recibo reciboE1 = e1.generarRecibo();
		Recibo reciboE2 = e2.generarRecibo();
		assertEquals(11111111, reciboE1.getCuil());
		assertEquals(22222222, reciboE2.getCuil());
	}

}
