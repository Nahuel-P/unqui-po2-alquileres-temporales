package ar.edu.unq.po2.alquilerestemporales;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EfectivoTestCase {

	
	private Efectivo efectivo;
	private String tipo;
	

	
	@BeforeEach
	void setUp() throws Exception {
		
		efectivo = new Efectivo();
		tipo = "Efectivo";
		
	}
	
	@Test
	void testConstructor() {
		
		assertNotNull(this.efectivo);
		
	}
	
	@Test
	void testTipoDeTarjeta() {
		
		assertEquals(this.tipo, this.efectivo.getTipo());
		
	}
}
