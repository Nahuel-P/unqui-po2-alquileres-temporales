package ar.edu.unq.po2.alquilerestemporales;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.alquilerestemporales.publicacion.calificable.CasillaEmail;

class CasillaDeMailTestCase {

	private CasillaEmail casillaDeMail;
	private String direccion;
	private String nuevoMail;
	
	@BeforeEach
	void setUp() throws Exception {
		direccion = "pepito@gmail.com";
		casillaDeMail = new CasillaEmail(direccion);
		nuevoMail = "Su reserva ha sido concretada";
	}
	
	@Test
	void testConstructor() {
		assertNotNull(this.casillaDeMail);
	}
	
	@Test
	void testGetDatos() {
		String direccionDeCasilla = this.casillaDeMail.getDireccion();
		assertEquals(direccion, direccionDeCasilla);
		assertTrue(this.casillaDeMail.getInbox().isEmpty());
	}
	
	@Test
	void testRecibirMail() {
		this.casillaDeMail.recibirMail(nuevoMail);
		assertTrue(this.casillaDeMail.getInbox().contains(nuevoMail));
	}
	
	@Test 
	void testEnviarMail() {
		this.casillaDeMail.enviarMail(this.casillaDeMail, nuevoMail);
		assertTrue(this.casillaDeMail.getInbox().contains(nuevoMail));
	}

}
