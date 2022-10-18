package ar.edu.unlp.info.oo1.ejercicio15_alquilerDePropiedades;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Tests {
	Sistema s;
	Usuario u1,u2;
	Propiedad p1,p2,p3;
	Reserva r1,r2,r3;
	
	@BeforeEach
	public void setup() {
		s = new Sistema();
		u1 = new Usuario("usuario 1", "dir 1", 1);
		u2 = new Usuario("usuario 2", "dir 2", 2);
		p1 = new Propiedad("p1", "desc 1", 100, "dir p1", u1);		
		p2 = new Propiedad("p2", "desc 2", 200, "dir p2", u1);		
		p3 = new Propiedad("p3", "desc 3", 300, "dir p3", u1);
				
	}
	
	@Test
	public void tests() {
		s.agregarUsuario(u1);
		s.agregarUsuario(u2);
		assertEquals(2, s.getUsuarios().size());
		
		s.registrarPropiedad(p1);
		s.registrarPropiedad(p2);
		s.registrarPropiedad(p3);
		assertEquals(3, s.getPropiedades().size());
		
		DateLapse dl = new DateLapse(LocalDate.now(), LocalDate.of(2022, 11, 18));
		assertEquals(3, s.disponiblesEnPeriodo(dl).size());
		
		s.hacerReserva(p1, dl, u2);
		s.hacerReserva(p2, dl, u2);
		s.hacerReserva(p3, dl, u2);
		assertEquals(3, u1.getEnAlquiler().size());
		assertEquals(3, u2.getReservas().size());
		assertEquals(3000, p1.getReservas().get(0).calcularPrecio(), 3100);
		
		DateLapse dl2 = new DateLapse(LocalDate.of(2022, 10, 28), LocalDate.of(2022, 11, 16));
		Reserva r = new Reserva(p3, dl2, u2);
		s.eliminarReserva(r);
//		assertEquals(2, u2.getReservas().size());
		
		assertEquals(10000, s.ingresosDePropietario(u1, LocalDate.now(), LocalDate.of(2022, 11, 30)), 20000);
		
		
	}
}
