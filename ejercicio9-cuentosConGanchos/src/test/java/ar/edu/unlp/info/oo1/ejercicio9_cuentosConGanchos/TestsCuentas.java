package ar.edu.unlp.info.oo1.ejercicio9_cuentosConGanchos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestsCuentas {

	CuentaCorriente cc;
	CajaDeAhorro ca;
	
	@BeforeEach
	public void setup() {
		this.cc = new CuentaCorriente();
		cc.setSaldoNegativo(100);
		this.ca = new CajaDeAhorro();
	}
	
	@Test
	public void testExtraerCuentaCorriente() {
		assertTrue(this.cc.extraer(100));
	}
	
	@Test
	public void testExtraerCajaDeAhorro() {
		this.ca.depositar(120);
		assertTrue(this.ca.extraer(100));
	}
	
	@Test
	public void testTransferir() {
		this.cc.transferirACuenta(100, ca);
		assertEquals(-100, this.cc.getSaldo());
		assertEquals(100, this.ca.getSaldo());
	}
	
}
