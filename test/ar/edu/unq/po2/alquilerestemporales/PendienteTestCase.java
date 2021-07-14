package ar.edu.unq.po2.alquilerestemporales;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.alquilerestemporales.publicacion.calificable.Calificacion;
import ar.edu.unq.po2.alquilerestemporales.publicacion.calificable.Usuario;
import ar.edu.unq.po2.alquilerestemporales.reserva.Aceptada;
import ar.edu.unq.po2.alquilerestemporales.reserva.Cancelada;
import ar.edu.unq.po2.alquilerestemporales.reserva.EstadoReserva;
import ar.edu.unq.po2.alquilerestemporales.reserva.Pendiente;
import ar.edu.unq.po2.alquilerestemporales.reserva.Reserva;

class PendienteTestCase {

	private Pendiente state;
	private Reserva reserva;
	private EstadoReserva cancelada;
	private EstadoReserva aceptada;
	private Usuario propietario;
	private LocalDate fecIng;
	private LocalDate fecSal;
	private LocalDate fechaIngresoDeReserva;
	private LocalDate fechaSalidaDeReserva;
	private Calificacion calificacionInmueble;
	private Calificacion calificacionInquilino;
	private Calificacion calificacionPropietario;
	
	@BeforeEach
	void setUp() throws Exception {
		state = new Pendiente();
		reserva = mock(Reserva.class);
		mock(Cancelada.class);
		cancelada = mock(Cancelada.class);
		aceptada = mock (Aceptada.class);
		propietario = mock(Usuario.class);
		fecIng = LocalDate.parse("2022-01-15");
		fecSal = LocalDate.parse("2022-01-18");
		fechaIngresoDeReserva= LocalDate.parse("2022-01-16");
		fechaSalidaDeReserva= LocalDate.parse("2022-01-17");
		this.calificacionInmueble = mock(Calificacion.class);
		this.calificacionInquilino = mock(Calificacion.class);
		this.calificacionPropietario = mock(Calificacion.class);
	}
	
	@Test
	void testCreation() {
		assertNotNull(state);
	}
	
		
	@Test
    void testAceptarPendiente() {
		state.aceptar(reserva);
		
		verify(reserva).informarUsuario("Se ha aceptado una de sus reservas", reserva.getInquilino());
		verify(reserva).notificarConcretada();
    }
	
	@Test
    void testRechazarPendiente(){
		state.rechazar(reserva);
		
		verify(reserva).informarUsuario("Se ha rechazado una de sus reservas", reserva.getInquilino());
    }
	
	@Test
	void testCancelarPendiente() {
		when(this.reserva.getEstadoDeReserva()).thenReturn(cancelada);
		this.state.cancelar(reserva);
		
		assertTrue(reserva.getEstadoDeReserva().getClass().equals(cancelada.getClass()));
	}
	
	
	@Test
    void testConcluirPendiente() throws Exception  {
		assertThrows(Exception.class, () -> {
            this.state.concluir(reserva);
        });
    }
		
	@Test
	void testEstadoDeReservaPendienteCalificaPropietario() {
		assertThrows(Exception.class, () -> {
			this.state.calificarInquilinato(reserva, calificacionInquilino);
		});
	}
	
	@Test
	void testEstadoDeReservaPendienteCalificaInquilino() {
		assertThrows(Exception.class, () -> {
			this.state.calificarEstadia(reserva, calificacionPropietario, calificacionInmueble);
		});
	}
	
	@Test
	void testEstadoDeReservaRechazadaNoEstaOcupadaConOtraReserva() {
		assertFalse(this.state.estaOcupadaCon(fecIng, fecSal, reserva));
	}
		
}