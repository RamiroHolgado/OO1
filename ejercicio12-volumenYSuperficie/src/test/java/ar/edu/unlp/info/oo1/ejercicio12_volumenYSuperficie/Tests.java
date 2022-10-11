package ar.edu.unlp.info.oo1.ejercicio12_volumenYSuperficie;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Tests {
	ReporteDeConstruccion rep;
	Cilindro c;
	Esfera e;
	PrismaRectangular pr;

	@BeforeEach
	public void setup() {
		rep = new ReporteDeConstruccion();
		c = new Cilindro("hierro", "rojo", 10, 5);
		e = new Esfera("hierro", "verde", 15);
		pr = new PrismaRectangular("acero", "rojo", 5, 3, 2);

		rep.agregarPieza(c);
		rep.agregarPieza(e);
		rep.agregarPieza(pr);
	}

	@Test
	public void testAgregarPieza() {
		Esfera e = new Esfera("plomo", "negro", 30);
		rep.agregarPieza(e);
		assertTrue(rep.getPiezas().contains(e));
	}

	@Test
	public void tests() {
		System.out.println(rep.volumenDeMaterial("hierro"));
		System.out.println(rep.superficieDeColor("rojo"));
		assertEquals(0, rep.volumenDeMaterial("hierro"), 100000);
		assertEquals(0, rep.superficieDeColor("rojo"), 100000);
	}
}
