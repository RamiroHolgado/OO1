package ar.edu.unlp.info.oo1.ejercicio8;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsuarioTest {

	private Usuario u;
	private Consumo c1, c2, c3;
	
	@BeforeEach
	public void setup() {
		u = new Usuario("user1","domicilio1");
		c1 = new Consumo(1000,10);
		c2 = new Consumo(2000,20);
		c3 = new Consumo(3000,30);
		
		u.agregarMedicion(c1);
//		u.agregarMedicion(c2);
//		u.agregarMedicion(c3);
	}
	
	@Test
	public void testAgregarMedicion() {
		Consumo c4 = new Consumo(4000,40);
		u.agregarMedicion(c4);
		assertTrue(this.u.getConsumos().contains(c4));
	}
	
	@Test
	public void testUltimoConsumoActiva() {
		assertEquals(c1.getConsumoEnergiaActiva(), this.u.ultimoConsumoActiva());
	}
	
	@Test
	public void testFacturar() {
		Factura f = this.u.facturarEnBaseA(10);
		assertEquals(10000, f.getMontoEnergiaActiva());
		assertEquals(10, f.getDescuento());
		assertEquals(LocalDate.now(), f.getFecha());
		assertEquals(u, f.getUsuario());
	}
	
}
