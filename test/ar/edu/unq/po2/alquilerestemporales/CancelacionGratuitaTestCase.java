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
		when(this.reserva.enPlazoDeCancelacion()).thenReturn(false);
		double resultado = this.cancelacion.aplicarCostosDeCancelacion(reserva);
		assertEquals(0, resultado);
	}
	
	@Test
	void testCancelacionGratuitaFueraDelPlazo() {
		when(this.reserva.enPlazoDeCancelacion()).thenReturn(false);
		when(this.reserva.costoDeCancelacion()).thenReturn(200.00);
		double resultado = this.cancelacion.aplicarCostosDeCancelacion(reserva);
		assertEquals(200.00, resultado);
	}
}