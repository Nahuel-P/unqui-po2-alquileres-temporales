package ar.edu.unq.po2.alquilerestemporales;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReservaTestCase {
	private Reserva reserva;
	private String fechaDeIngreso;
	private String fechaDeSalida;
	private LocalDate fechaDeIngresoDate;
	private LocalDate fechaDeSalidaDate;
	private Aceptada estadoReservaAceptada;
	
	@BeforeEach
	void setUp() throws Exception {
		this.fechaDeIngreso = "2022-01-30";
		this.fechaDeSalida = "2022-03-15";
		this.fechaDeIngresoDate = LocalDate.parse(fechaDeIngreso);
		this.fechaDeSalidaDate = LocalDate.parse(fechaDeSalida);
		this.estadoReservaAceptada = mock(Aceptada.class);
		this.reserva = new Reserva(fechaDeIngresoDate, fechaDeSalidaDate, estadoReservaAceptada);		
	}
	
	@Test
	void testConstructor() {
		assertNotNull(this.reserva);
	}
	
	@Test
	void testReservaTieneFechaDeIngreso() {
		assertEquals(this.fechaDeIngresoDate,this.reserva.getFechaDeIngreso());
	}
	
	@Test
	void testReservaTieneFechaDeSalida() {
		assertEquals(this.fechaDeSalidaDate,this.reserva.getFechaDeSalida());
	}
	
	@Test
	void testDiferenciaDeDiasEnReserva() {
		assertEquals(44, this.reserva.getDiferenciaDeDias());
	}
	
	@Test
	void testEstadoDeReservaAceptada() {
		this.reserva.setEstado(estadoReservaAceptada);
		assertEquals(this.estadoReservaAceptada, this.reserva.getEstadoDeReserva());
	}
	
	
}
