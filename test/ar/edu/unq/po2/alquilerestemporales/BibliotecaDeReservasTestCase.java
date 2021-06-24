package ar.edu.unq.po2.alquilerestemporales;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BibliotecaDeReservasTestCase {

	private BibliotecaDeReservas biblioteca;
	private Reserva reserva1;
	private Reserva reserva2;
	private Usuario usuario;
	
	
	@BeforeEach
	void setUp() throws Exception {
		biblioteca= new BibliotecaDeReservas();
		reserva1 = mock(Reserva.class);
		reserva2 = mock(Reserva.class);
		usuario = mock(Usuario.class);
	}
	
	@Test
	void testConstructor() {
		assertNotNull(this.biblioteca);
	}
	
	@Test
	void testAgregarReservas() {
		biblioteca.crearReserva(usuario, reserva1);
		biblioteca.crearReserva(usuario, reserva2);
		int resultado = biblioteca.getTodasReservas().size();
		assertEquals(2,resultado);
	}
	
	@Test
	void testNoAgregarReservasRepetidas() {
		biblioteca.crearReserva(usuario, reserva1);
		biblioteca.crearReserva(usuario, reserva1);
		int resultado = biblioteca.getTodasReservas().size();
		assertEquals(1,resultado);
	}
	

}
