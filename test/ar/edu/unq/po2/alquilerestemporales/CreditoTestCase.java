package ar.edu.unq.po2.alquilerestemporales;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreditoTestCase {

	private FormaDePago credito;
	private String tipo;
	
	@BeforeEach
	void setUp() throws Exception {
		credito = new Credito();
		tipo = "Credito";
	}
	
	@Test
	void testConstructor() {
		assertNotNull(this.credito);
	}
	
	@Test
	void testTipoDeTarjeta() {
		assertEquals(this.tipo, this.credito.getTipo());
	}

}
