package ar.edu.unlp.info.oo1.ejercicio8;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DistribuidoraTest {
	private Distribuidora d, dVacia;
	private Usuario u1,u2,u3;
	private Consumo a,b,c;
	
	@BeforeEach
	public void setUp() {
		d = new Distribuidora(10);
		dVacia = new Distribuidora(10);
		
		u1 = new Usuario("usuario 1", "domicilio 1");
		u2 = new Usuario("usuario 2", "domicilio 2");
		u3 = new Usuario("usuario 3", "domicilio 3");
				
		a = new Consumo(100, 10);
		b = new Consumo(1000, 10);
		c = new Consumo(10000, 10);
		
		d.agregarUsuario(u1);
		d.agregarUsuario(u2);
		d.agregarUsuario(u3);
	}
	
	@Test
	public void testAgregarUsuario() {
		Usuario u4 = new Usuario("usuario 4", "domicilio 4");
		this.d.agregarUsuario(u4);
		assertTrue(this.d.getUsuarios().contains(u4));
	}
	
	@Test
	public void testConsumoTotalActiva() {
		this.u1.agregarMedicion(a);
		this.u2.agregarMedicion(b);
		this.u3.agregarMedicion(c);
		assertEquals(11100, this.d.consumoTotalActiva());
	}
	
	@Test
	void tests() {		
		assertEquals(10, this.d.getPrecioKWh());
		assertEquals(0, this.d.consumoTotalActiva());
		assertTrue(this.dVacia.facturar().isEmpty());
		assertTrue(this.dVacia.getUsuarios().isEmpty());
	}
}
