package ar.edu.unq.po2.alquilerestemporales;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DebitoTestCase {

	private FormaDePago debito;
	private String tipo;
	private int numeroTarjeta;
	
	@BeforeEach
	void setUp() throws Exception {
		numeroTarjeta = 1234;
		debito = new Debito(numeroTarjeta);
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
	
	/*@Test
	void testNumeroDeTarjeta() {
		this.debito.get
	}*/

}
