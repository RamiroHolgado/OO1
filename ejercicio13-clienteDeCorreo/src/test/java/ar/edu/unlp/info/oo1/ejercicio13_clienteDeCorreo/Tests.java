package ar.edu.unlp.info.oo1.ejercicio13_clienteDeCorreo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Tests {

	ClienteDeCorreo cli;

	@BeforeEach
	public void setup() {
		cli = new ClienteDeCorreo();
	}

	@Test
	public void testRecibir() {
		Email e = new Email("email 1", "cuerpo 1");
		cli.recibir(e);
		assertTrue(cli.getCarpetas().get(0).getEmails().contains(e));
	}

	@Test
	public void testMoverYAgregarCarpeta() {
		Carpeta c = new Carpeta("carpeta1");
		cli.agregarCarpeta(c);
		assertTrue(cli.getCarpetas().contains(c));
		Email e = new Email("email 1", "cuerpo 1");
		cli.mover(e, cli.getCarpetas().get(0), c);
		assertFalse(cli.getCarpetas().get(0).getEmails().contains(e));
		assertTrue(cli.getCarpetas().get(1).getEmails().contains(e));
	}

	@Test
	public void testBusacar() {
		Email e1 = new Email("email 1", "cuerpo 1");
		Email e2 = new Email("email 2", "cuerpo 2");
		Email e3 = new Email("email 3", "cuerpo 3");
		cli.getCarpetas().get(0).agregarEmail(e3);
		cli.getCarpetas().get(0).agregarEmail(e1);
		cli.getCarpetas().get(0).agregarEmail(e2);
		assertEquals(e2, cli.buscar("cuerpo 2"));
	}

	@Test
	public void testEspacioOcupado() {
		Email e1 = new Email("email 1", "cuerpo 1");
		Email e2 = new Email("email 2", "cuerpo 2");
		Email e3 = new Email("email 3", "cuerpo 3");
		cli.getCarpetas().get(0).agregarEmail(e3);
		cli.getCarpetas().get(0).agregarEmail(e1);
		cli.getCarpetas().get(0).agregarEmail(e2);
		assertEquals(0, cli.espacioOcupado(), 1000);
		System.out.println(cli.espacioOcupado());
	}
}
