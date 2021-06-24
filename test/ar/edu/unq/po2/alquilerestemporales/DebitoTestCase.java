package ar.edu.unq.po2.alquilerestemporales;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DebitoTestCase {

	private Debito debito;
	private String tipo;
	
	@BeforeEach
	void setUp() throws Exception {
		debito = new Debito();
		tipo = "Debito";
	}
	
	@Test
	void testConstructor() {
		assertNotNull(this.debito);
	}
	
	@Test
	void testTipoDeTarjeta() {
		assertEquals(this.tipo, this.debito.getTipo());
	}

}
