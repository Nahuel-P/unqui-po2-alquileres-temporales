package ar.edu.unq.po2.alquilerestemporales;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CancelacionGratuitaTestCase {

	private CancelacionGratuita cancelacion; 
	private Reserva reserva;
	
	@BeforeEach
	void setUp() throws Exception {
		cancelacion= new CancelacionGratuita();
		reserva= mock(Reserva.class);

	}
	
	@Test
	void testCancelacionGratuitaEnPlazo() {
		when(this.reserva.enPlazoDeCancelacion()).thenReturn(true);
		
		float resultado = this.cancelacion.aplicarCostosDeCancelacion(reserva);
		assertEquals(0f, resultado);
	}
	
	@Test
	void testCancelacionGratuitaFueraDePlazoSeCobraDosDias() {
		when(this.reserva.enPlazoDeCancelacion()).thenReturn(false);
		when(this.reserva.costoPorDia()).thenReturn(200f);
		
		float resultado = this.cancelacion.aplicarCostosDeCancelacion(reserva);
		assertEquals(400f, resultado);
	}
	

}