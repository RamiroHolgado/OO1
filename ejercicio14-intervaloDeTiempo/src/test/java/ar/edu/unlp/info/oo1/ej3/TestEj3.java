package ar.edu.unlp.info.oo1.ej3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestEj3 {
	DateLapseEj3 d;

	@BeforeEach
	public void setup() {
		d = new DateLapseEj3(LocalDate.of(2020, 10, 10), 10);
	}

	@Test
	public void testSizeInDays() {
		assertEquals(10, d.sizeInDays());
		System.out.println(d.sizeInDays());
	}

	@Test
	public void testIncludesDate() {
		assertTrue(d.includesDate(LocalDate.of(2020, 10, 15)));
		assertFalse(d.includesDate(LocalDate.of(2020, 1, 1)));
	}
}
