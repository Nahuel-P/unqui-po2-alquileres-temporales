package ar.edu.unq.po2.alquilerestemporales;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.alquilerestemporales.publicacion.calificable.Calificacion;
import ar.edu.unq.po2.alquilerestemporales.reserva.Concluida;
import ar.edu.unq.po2.alquilerestemporales.reserva.EstadoReserva;
import ar.edu.unq.po2.alquilerestemporales.reserva.Reserva;

class EstadoDeReservaConcluidaTestCaseTest {

	private EstadoReserva estadoReservaConcluida;
	private Reserva reserva;
	private String fechaDeIngreso;
	private String fechaDeSalida;
	private LocalDate fechaDeIngresoDate;
	private LocalDate fechaDeSalidaDate;
	private Calificacion calificacionInmueble;
	private Calificacion calificacionInquilino;
	private Calificacion calificacionPropietario;
	
	@BeforeEach
	void setUp() throws Exception {
		estadoReservaConcluida = new Concluida();
		reserva = mock(Reserva.class);
		this.fechaDeIngreso = "2022-01-28";
		this.fechaDeSalida = "2022-01-30";
		this.fechaDeIngresoDate = LocalDate.parse(fechaDeIngreso);
		this.fechaDeSalidaDate = LocalDate.parse(fechaDeSalida);
		this.calificacionInmueble = mock(Calificacion.class);
		this.calificacionInquilino = mock(Calificacion.class);
		this.calificacionPropietario = mock(Calificacion.class);
	}
	
	@Test
	void testEstadoDeReservaRechazadaAceptaReserva() {
		assertThrows(Exception.class, () -> {
			this.estadoReservaConcluida.aceptar(reserva);
		});
	}
	
	@Test
	void testEstadoDeReservaRechazadaRechazaReserva() {
		assertThrows(Exception.class, () -> {
			this.estadoReservaConcluida.rechazar(reserva);
		});
	}
	
	@Test
	void testEstadoDeReservaRechazadaCancelaReserva() {
		assertThrows(Exception.class, () -> {
			this.estadoReservaConcluida.cancelar(reserva);
		});
	}
	
	@Test
	void testEstadoDeReservaRechazadaConcluirReserva() {
		assertThrows(Exception.class, () -> {
			this.estadoReservaConcluida.concluir(reserva);
		});
	}
	
	@Test
	void testEstadoDeReservaRechazadaNoEstaOcupadaConOtraReserva() {
		assertFalse(this.estadoReservaConcluida.estaOcupadaCon(fechaDeIngresoDate, fechaDeSalidaDate, reserva));
	}
	
	@Test
	void testEstadoDeReservaConcluidaCalificaPropietario() {
		this.estadoReservaConcluida.calificarInquilino(reserva, calificacionInquilino);
		verify(reserva).calificarInquilino(calificacionInquilino);

	}
	
	@Test
	void testEstadoDeReservaConcluidaCalificaInquilino() {
		this.estadoReservaConcluida.calificarPropietario(reserva, calificacionPropietario, calificacionInmueble);
		verify(reserva).calificarPublicacion(calificacionPropietario, calificacionInmueble);
	}
}
