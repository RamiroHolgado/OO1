package ar.edu.unlp.info.oo1.ejercicio19_mercadoDeObjetos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Tests {
	Sistema s;
	Usuario u1, u2;
	Producto producto1, producto2;

	@BeforeEach
	public void setup() {
		s = new Sistema();
		u1 = new Usuario("USUARIO 1", "DIR 1");
		u2 = new Usuario("USUARIO 2", "DIR 2");
		s.agregarUsuario(u1);
		s.agregarUsuario(u2);

		producto1 = new Producto("MESA", "DESCRIPCION MESA", 10000, 3, u1);
		producto2 = new Producto("SILLA", "DESCRIPCION SILLA", 3000, 18, u1);
		u1.agregarProducto(producto1);
		u1.agregarProducto(producto2);

	}

	@Test
	public void testBuscarUsuario() {
		assertEquals(u1, s.buscarUsuario("USUARIO 1"));
	}

	@Test
	public void testBuscarProducto() {
		assertTrue(u1.buscarProducto("MESA").contains(producto1));
	}

	@Test
	public void testCrearPedidoYcalcularCosto() {
		u2.crearPedido(producto1, 1, "cuotas", "express a domicilio");
		u2.crearPedido(producto2, 6, "cuotas", "express a domicilio");

		assertEquals(2, u2.getPedidos().size());
		assertEquals(1000, u2.getPedidos().get(0).calcularCostoTotal(), 100000);
		assertEquals(1000, u2.getPedidos().get(1).calcularCostoTotal(), 100000);
	}

}
