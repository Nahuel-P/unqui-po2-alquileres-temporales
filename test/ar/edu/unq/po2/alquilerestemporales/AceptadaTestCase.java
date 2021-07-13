package ar.edu.unq.po2.alquilerestemporales;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.alquilerestemporales.publicacion.calificable.Usuario;
import ar.edu.unq.po2.alquilerestemporales.reserva.Aceptada;
import ar.edu.unq.po2.alquilerestemporales.reserva.Cancelada;
import ar.edu.unq.po2.alquilerestemporales.reserva.Concluida;
import ar.edu.unq.po2.alquilerestemporales.reserva.EstadoReserva;
import ar.edu.unq.po2.alquilerestemporales.reserva.Reserva;

class AceptadaTestCase {
	
	private Aceptada state;
	private Reserva reserva;
	private EstadoReserva cancelada;
	private EstadoReserva concluida;
	private Usuario propietario;
	private LocalDate fecIng;
	private LocalDate fecSal;
	private LocalDate fechaIngresoDeReserva;
	private LocalDate fechaSalidaDeReserva;
	
	@BeforeEach
	void setUp() throws Exception {
		state = new Aceptada();
		reserva = mock(Reserva.class);
		cancelada = mock(Cancelada.class);
		concluida = mock(Concluida.class);
		propietario = mock(Usuario.class);
		fecIng = LocalDate.parse("2022-01-15");
		fecSal = LocalDate.parse("2022-01-17");
		fechaIngresoDeReserva= LocalDate.parse("2022-01-16");
		fechaSalidaDeReserva= LocalDate.parse("2022-01-17");
	}
	
	@Test
	void testCreation() {
		assertNotNull(state);
	}
	
	@Test
	void testCancelarAceptada() {
		when(this.reserva.getPropietario()).thenReturn(propietario);
		state.cancelar(reserva);
		verify(reserva).informarUsuario("Se ha cancelada una de sus reservas",propietario);
		verify(reserva).notificarCancelada();
		verify(reserva).aplicarPoliticaDeCancelacion();
	}
	
	@Test
    void testAceptarAceptada() throws Exception {
        assertThrows(Exception.class, () -> {
            this.state.aceptar(reserva);
        });
    }
	
	@Test
    void testRechazarAceptada() throws Exception {
        assertThrows(Exception.class, () -> {
            this.state.rechazar(reserva);
        });
    }
	
	@Test
    void testEstaOcupadaConOtraReserva()  {
		when(this.reserva.getFechaDeIngreso()).thenReturn(fechaIngresoDeReserva);
		when(this.reserva.getFechaDeSalida()).thenReturn(fechaSalidaDeReserva);
        boolean resultado = state.estaOcupadaCon(fecIng, fecSal, reserva);
        assertTrue(resultado);
    }


}
