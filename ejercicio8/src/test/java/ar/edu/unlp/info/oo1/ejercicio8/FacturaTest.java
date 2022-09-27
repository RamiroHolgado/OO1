package ar.edu.unlp.info.oo1.ejercicio8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FacturaTest {
	private Factura f;
	private Usuario u;
	
	@BeforeEach
	public void setUp() {
		u = new Usuario("user1","direccion1");
		f = new Factura(1000, 10, u);
	}
	
	@Test
	public void testInicializar() {
		assertEquals(10, f.getDescuento());
		assertEquals(1000, f.getMontoEnergiaActiva());
		assertEquals(LocalDate.now(), f.getFecha());
		assertEquals(u, f.getUsuario());
		assertEquals(100, f.montoTotal());
		
	}
	
}
