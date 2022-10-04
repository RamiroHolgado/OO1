package ar.edu.unlp.info.oo1.ejercicio11_elInversor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class Tests {
	Inversor inversor;
	
	InversionEnAcciones iEnAcciones;
	PlazoFijo pf;
	
	@BeforeEach
	public void setup() {
		this.inversor = new Inversor("inversor 1");
		this.iEnAcciones = new InversionEnAcciones("accion", 10, 100);
		this.pf = new PlazoFijo(LocalDate.of(2022, 10, 1), 10000, 1);
		
	}
	
	
	@Test
	public void testInversionEnAcciones() {
		this.inversor.agregarInversion(this.iEnAcciones);
		assertEquals(1000, this.inversor.valorActual());
	}
	
	@Test
	public void testPlazoFijo() {
		this.inversor.agregarInversion(this.pf);
		assertEquals(10300, this.inversor.valorActual());
	}
}
