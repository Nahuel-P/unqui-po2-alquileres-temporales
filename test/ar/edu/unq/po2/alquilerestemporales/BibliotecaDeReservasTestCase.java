package ar.edu.unq.po2.alquilerestemporales;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.verification.VerificationMode;

class BibliotecaDeReservasTestCase {

	private BibliotecaDeReservas biblioteca;
	private Reserva reserva1;
	private Reserva reserva2;
	private Usuario usuario;
	private Usuario inquilino;
	private LocalDate hoy;
	private LocalDate mañana;
	
	
	@BeforeEach
	void setUp() throws Exception {
		biblioteca= new BibliotecaDeReservas();
		reserva1 = mock(Reserva.class);
		reserva2 = mock(Reserva.class);
		usuario = mock(Usuario.class);
		inquilino = mock(Usuario.class);
		hoy = LocalDate.now();
		mañana = hoy.plusDays(1);
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
	
	@Test
	void testConcretarReserva() {
		when(this.reserva1.getPropietario()).thenReturn(usuario);
		biblioteca.crearReserva(inquilino, reserva1);
		this.biblioteca.concretarReserva(usuario,reserva1);
		verify(reserva1).aceptar();
	}
	
	@Test
	void testReservaNoExiste() {
		boolean resultado = biblioteca.existeEnBiblioteca(reserva1);
		assertFalse(resultado);
	}
	
	@Test
	void testCancelarReserva() {
		when(this.reserva1.getInquilino()).thenReturn(inquilino);
		biblioteca.crearReserva(inquilino, reserva1);
		this.biblioteca.declinarReserva(inquilino,reserva1);
		verify(reserva1).cancelar();
	}
	
	@Test
	void testNoSePuedeCancelarReserva() {
		when(this.reserva1.getInquilino()).thenReturn(usuario);
		this.biblioteca.declinarReserva(inquilino,reserva1);
		verify(reserva1,never()).cancelar();
	}
	
	@Test
	void testConcluirReservasEnLaFecha() {
		when(this.reserva1.getFechaDeSalida()).thenReturn(this.hoy);
		when(this.reserva2.getFechaDeSalida()).thenReturn(this.mañana);
		when(this.reserva1.getPropietario()).thenReturn(usuario);
		when(this.reserva2.getPropietario()).thenReturn(usuario);
		biblioteca.crearReserva(inquilino, reserva1);
		biblioteca.crearReserva(inquilino, reserva2);
		biblioteca.concluirReservas();
		verify(reserva1).concluir();
		verify(reserva2,never()).concluir();
	}
	
	@Test
	void testRechazarReserva() {
		when(this.reserva1.getPropietario()).thenReturn(usuario);
		biblioteca.crearReserva(inquilino, reserva1);
		this.biblioteca.rechazarReserva(usuario,reserva1);
		verify(reserva1).rechazar();
	}
	
	@Test
	void testNoSePuedeRechazarReserva() {
		when(this.reserva1.getPropietario()).thenReturn(usuario);
		this.biblioteca.rechazarReserva(inquilino,reserva1);
		verify(reserva1,never()).rechazar();
	}
	
	@Test
	void testReservasDeUsuario() {
		when(this.reserva1.getInquilino()).thenReturn(usuario);
		when(this.reserva2.getInquilino()).thenReturn(inquilino);
		this.biblioteca.crearReserva(usuario, reserva1);
		this.biblioteca.crearReserva(inquilino, reserva2);
		int resultado = this.biblioteca.reservasDelUsuario(usuario).size();
		assertEquals(1,resultado);
	}
}
