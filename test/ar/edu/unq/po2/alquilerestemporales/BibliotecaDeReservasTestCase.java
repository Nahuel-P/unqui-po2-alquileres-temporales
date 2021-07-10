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

import ar.edu.unq.po2.alquilerestemporales.publicacion.calificable.Usuario;
import ar.edu.unq.po2.alquilerestemporales.reserva.Reserva;
import ar.edu.unq.po2.alquilerestemporales.webReservas.BibliotecaDeReservas;

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
		biblioteca.crearReserva(reserva1);
		biblioteca.crearReserva(reserva2);
		int resultado = biblioteca.getTodasLasReservas().size();
		assertEquals(2,resultado);
	}
		
	@Test
	void testConcretarReserva() {
		when(this.reserva1.getPropietario()).thenReturn(usuario);
		biblioteca.crearReserva(reserva1);
		this.biblioteca.concretarReserva(reserva1);
		verify(reserva1).aceptar();
	}
		
	@Test
	void testCancelarReserva() {
		when(this.reserva1.getInquilino()).thenReturn(inquilino);
		biblioteca.crearReserva(reserva1);
		this.biblioteca.declinarReserva(reserva1);
		verify(reserva1).cancelar();
	}
	
	@Test
	void testConcluirReservasEnLaFecha() {
		when(this.reserva1.getFechaDeSalida()).thenReturn(this.hoy);
		when(this.reserva2.getFechaDeSalida()).thenReturn(this.mañana);
		when(this.reserva1.getPropietario()).thenReturn(usuario);
		when(this.reserva2.getPropietario()).thenReturn(usuario);
		biblioteca.crearReserva(reserva1);
		biblioteca.crearReserva(reserva2);
		biblioteca.concluirReservas();
		verify(reserva1).concluir();
		verify(reserva2,never()).concluir();
	}
	
	@Test
	void testRechazarReserva() {
		when(this.reserva1.getPropietario()).thenReturn(usuario);
		biblioteca.crearReserva(reserva1);
		this.biblioteca.rechazarReserva(reserva1);
		verify(reserva1).rechazar();
	}

	@Test
	void testReservasDeUsuario() {
		when(this.reserva1.esReservaDeUsuario(usuario)).thenReturn(true);
		when(this.reserva2.esReservaDeUsuario(usuario)).thenReturn(false);
		this.biblioteca.crearReserva(reserva1);
		this.biblioteca.crearReserva(reserva2);
		int resultado = this.biblioteca.getReservasDeUsuario(usuario).size();
		assertEquals(1,resultado);
	}
}
