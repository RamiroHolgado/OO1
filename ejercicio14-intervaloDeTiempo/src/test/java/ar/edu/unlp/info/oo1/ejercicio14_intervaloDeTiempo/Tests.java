package ar.edu.unlp.info.oo1.ejercicio14_intervaloDeTiempo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Tests {
	DateLapse d;
	
	@BeforeEach
	public void setup() {
		d = new DateLapse(LocalDate.of(2020, 10, 10), LocalDate.now());
	}
	
	@Test
	public void testSizeInDays() {
		assertEquals(600, d.sizeInDays(), 900);
		System.out.println(d.sizeInDays());
	}
	
	@Test
	public void testIncludesDate() {
		assertTrue(d.includesDate(LocalDate.of(2022, 1, 1)));
		assertFalse(d.includesDate(LocalDate.of(2020, 1, 1)));
	}
}
