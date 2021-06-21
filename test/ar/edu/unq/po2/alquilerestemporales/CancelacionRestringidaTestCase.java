package ar.edu.unq.po2.alquilerestemporales;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CancelacionRestringidaTestCase {

	private PoliticaDeCancelacion cancelacion; 
	private Reserva reserva;
	
	@BeforeEach
	void setUp() throws Exception {
		cancelacion= new CancelacionRestringida();
		reserva= mock(Reserva.class);

	}
	
	@Test
	void testCancelacionSePagaElTotalAlquilado() {
		when(this.reserva.costoTotal()).thenReturn(1000f);
		
		float resultado = this.cancelacion.aplicarCostosDeCancelacion(reserva);
		assertEquals(1000f, resultado);
	}

}
