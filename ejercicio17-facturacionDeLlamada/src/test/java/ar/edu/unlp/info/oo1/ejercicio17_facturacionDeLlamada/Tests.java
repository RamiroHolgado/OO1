package ar.edu.unlp.info.oo1.ejercicio17_facturacionDeLlamada;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Tests {
	Sistema s;
	Cliente pf;
	Cliente pj;
	Llamada local;
	Interurbana interurbana;
	Internacional internacional;

	@BeforeEach
	public void setup() {
		s = new Sistema();
		s.agregarNumero(111);
		s.agregarNumero(222);
		s.agregarNumero(333);

		pf = new PersonaFisica("PERSONA FISICA", "DIR PF", s.getNumeros().get(0), 11111111);
		s.eliminarNumero(pf.getNumero());
		pj = new PersonaJuridica("PERSONA JURIDICA", "DIR PJ", s.getNumeros().get(0), 22222222, "TIPO");
		s.eliminarNumero(pj.getNumero());
		s.agregarCliente(pf);
		s.agregarCliente(pj);

		local = new Llamada(LocalDate.of(2022, 1, 10), LocalTime.of(10, 30), 10, pf.getNumero(), pj.getNumero());
		interurbana = new Interurbana(LocalDate.of(2022, 1, 10), LocalTime.of(10, 30), 10, pf.getNumero(),
				pj.getNumero(), 100);
		internacional = new Internacional(LocalDate.of(2022, 1, 10), LocalTime.of(10, 30), 10, pj.getNumero(),
				pf.getNumero(), "Argentina", "Uruguay");
		pf.agregarLlamada(local);
		pf.agregarLlamada(interurbana);
		pj.agregarLlamada(internacional);
	}

	@Test
	public void testAgregarCliente() {
		Cliente cli1 = new PersonaFisica("CLIENTE", "DIR", s.getNumeros().get(0), 33333333);
		s.agregarCliente(cli1);
		s.eliminarNumero(cli1.getNumero());

		assertTrue(s.getClientes().contains(cli1));
		assertFalse(s.getNumeros().contains(cli1.getNumero()));
	}

	@Test
	public void testAgregarLlamada() {
		Llamada l = new Llamada(LocalDate.of(2022, 10, 10), LocalTime.of(10, 30), 10, pf.getNumero(), pj.getNumero());
		pf.agregarLlamada(l);

		assertTrue(pf.getLlamadas().contains(l));
	}

	@Test
	public void testFacturarLlamadas() {
		DateLapse d = new DateLapse(LocalDate.of(2022, 1, 1), LocalDate.now());
		Factura facturaPF = pf.facturarLlamadas(d);
		Factura facturaPJ = pj.facturarLlamadas(d);

		assertEquals(pf, facturaPF.getCliente());
		assertEquals(pj, facturaPJ.getCliente());

//		System.out.println(s.getClientes().get(1).getCuit());

	}

}
