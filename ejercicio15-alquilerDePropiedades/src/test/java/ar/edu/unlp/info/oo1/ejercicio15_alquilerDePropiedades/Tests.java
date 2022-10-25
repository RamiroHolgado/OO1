package ar.edu.unlp.info.oo1.ejercicio15_alquilerDePropiedades;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Tests {
	Sistema s;
	Usuario u1, u2, u3;
	Propiedad p1, p2, p3;

	@BeforeEach
	public void setup() {
		s = new Sistema();
		u1 = new Usuario("usuario 1", "dir 1", 1);
		u2 = new Usuario("usuario 2", "dir 2", 2);
		u3 = new Usuario("usuario 3", "dir 3", 3);
		p1 = new Propiedad("p1", "desc 1", "dir p1", 100);
		p2 = new Propiedad("p2", "desc 2", "dir p2", 200);
		p3 = new Propiedad("p3", "desc 3", "dir p3", 300);

		s.agregarUsuario(u1);
		s.agregarUsuario(u2);
		u1.agregarPropiedad(p1);
		u1.agregarPropiedad(p2);

	}

	@Test
	public void testRegistrarUsuario() {
		s.agregarUsuario(u3);
		assertEquals(3, s.getUsuarios().size());
	}

	@Test
	public void testRegistrarPropiedad() {
		u1.agregarPropiedad(p3);
		assertTrue(s.getPropiedades().contains(p3));
	}

	@Test
	public void testDisponiblesEnPeriodo() {
		DateLapse dl = new DateLapse(LocalDate.of(2022, 1, 1), LocalDate.of(2022, 2, 1));
		Reserva r1 = new Reserva(p1, dl);
		s.agregarReserva(r1, u2);

		DateLapse date = new DateLapse(LocalDate.of(2022, 1, 15), LocalDate.of(2022, 1, 30));
		assertEquals(1, s.disponiblesEnPeriodo(date).size());
	}

	@Test
	public void testHacerReserva() {
		DateLapse dl = new DateLapse(LocalDate.of(2022, 1, 1), LocalDate.of(2022, 2, 1));
		Reserva r1 = new Reserva(p1, dl);
		s.agregarReserva(r1, u2);

		assertTrue(u2.getReservas().contains(r1));
		assertTrue(p1.getReservas().contains(r1));
	}

	@Test
	public void testCalcularPrecioDeReserva() {
		DateLapse dl = new DateLapse(LocalDate.of(2022, 1, 1), LocalDate.of(2022, 2, 1));
		Reserva r1 = new Reserva(p1, dl);

		assertEquals(100, r1.calcularPrecio(), 3100);
	}

	@Test
	public void testEliminarReserva() {
		DateLapse dl = new DateLapse(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 2, 1));
		Reserva r1 = new Reserva(p1, dl);
		s.agregarReserva(r1, u2);

		assertTrue(u2.getReservas().contains(r1));
		assertTrue(p1.getReservas().contains(r1));

		u2.eliminarReserva(r1);
		p1.eliminarReserva(r1);

		assertFalse(u2.getReservas().contains(r1));
		assertFalse(p1.getReservas().contains(r1));
	}

	@Test
	public void testCalcularIngresosDeUnPropietario() {
		DateLapse dl = new DateLapse(LocalDate.of(2022, 2, 1), LocalDate.of(2022, 2, 10));
		Reserva r1 = new Reserva(p1, dl);
		p1.agregarReserva(r1);
		p2.agregarReserva(r1);

		DateLapse dl1 = new DateLapse(LocalDate.of(2022, 1, 1), LocalDate.of(2022, 2, 2));
		assertEquals(100, u1.calcularIngresos(dl1), 10000);
		System.out.println("INGRESOS " + u1.calcularIngresos(dl1));

	}

	@Test
	public void testCalcularRembolsos() {
		Flexible pf = new Flexible("Propiedad flexible", "flex", "dir 1", 100);
		Moderada pm = new Moderada("Propiedad moderada", "mod", "dir 2", 100);
		Estricta pe = new Estricta("Propiedad estricta", "est", "dir 3", 100);
		u1.agregarPropiedad(pf);
		u1.agregarPropiedad(pm);
		u1.agregarPropiedad(pe);

		DateLapse dl = new DateLapse(LocalDate.of(2022, 10, 30), LocalDate.of(2022, 11, 10));
		Reserva r1 = new Reserva(pf, dl);
		Reserva r2 = new Reserva(pm, dl);
		Reserva r3 = new Reserva(pe, dl);
		s.agregarReserva(r1, u2);
		s.agregarReserva(r2, u2);
		s.agregarReserva(r3, u2);

		assertEquals(0, pf.retornoDeCancelacion(r1), 100000);
		System.out.println("FLEXIBLE " + pf.retornoDeCancelacion(r1));
		assertEquals(0, pm.retornoDeCancelacion(r2), 100000);
		System.out.println("MODERADA " + pm.retornoDeCancelacion(r2));
		assertEquals(0, pe.retornoDeCancelacion(r3));
		System.out.println("ESTRICTA " + pe.retornoDeCancelacion(r3));

	}

}
