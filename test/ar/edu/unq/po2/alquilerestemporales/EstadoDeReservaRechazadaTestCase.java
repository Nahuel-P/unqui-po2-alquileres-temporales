package ar.edu.unq.po2.alquilerestemporales;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.alquilerestemporales.reserva.EstadoReserva;
import ar.edu.unq.po2.alquilerestemporales.reserva.Rechazada;
import ar.edu.unq.po2.alquilerestemporales.reserva.Reserva;

class EstadoDeReservaRechazadaTestCase {

	private EstadoReserva estadoReservaRechazada;
	private Reserva reserva;
	private String fechaDeIngreso;
	private String fechaDeSalida;
	private LocalDate fechaDeIngresoDate;
	private LocalDate fechaDeSalidaDate;
	
	@BeforeEach
	void setUp() throws Exception {
		estadoReservaRechazada = new Rechazada();
		reserva = mock(Reserva.class);
		this.fechaDeIngreso = "2022-01-28";
		this.fechaDeSalida = "2022-01-30";
		this.fechaDeIngresoDate = LocalDate.parse(fechaDeIngreso);
		this.fechaDeSalidaDate = LocalDate.parse(fechaDeSalida);
	}
	
	@Test
	void testEstadoDeReservaRechazadaAceptaReserva() {
		assertThrows(Exception.class, () -> {
			this.estadoReservaRechazada.aceptar(reserva);
		});
	}
	
	@Test
	void testEstadoDeReservaRechazadaRechazaReserva() {
		assertThrows(Exception.class, () -> {
			this.estadoReservaRechazada.rechazar(reserva);
		});
	}
	
	@Test
	void testEstadoDeReservaRechazadaCancelaReserva() {
		assertThrows(Exception.class, () -> {
			this.estadoReservaRechazada.cancelar(reserva);
		});
	}
	
	@Test
	void testEstadoDeReservaRechazadaConcluirReserva() {
		assertThrows(Exception.class, () -> {
			this.estadoReservaRechazada.concluir(reserva);
		});
	}
	
	@Test
	void testEstadoDeReservaRechazadaNoEstaOcupadaConOtraReserva() {
		assertFalse(this.estadoReservaRechazada.estaOcupadaCon(fechaDeIngresoDate, fechaDeSalidaDate, reserva));
	}
}
