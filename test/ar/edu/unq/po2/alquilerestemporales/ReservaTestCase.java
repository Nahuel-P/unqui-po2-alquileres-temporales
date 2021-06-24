package ar.edu.unq.po2.alquilerestemporales;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
	private Usuario inquilino;
	private Publicacion publicacion;
	private Usuario propietario;
	
	@BeforeEach
	void setUp() throws Exception {
		this.fechaDeIngreso = "2022-01-30";
		this.fechaDeSalida = "2022-03-15";
		this.fechaDeIngresoDate = LocalDate.parse(fechaDeIngreso);
		this.fechaDeSalidaDate = LocalDate.parse(fechaDeSalida);
		this.estadoReservaAceptada = mock(Aceptada.class);
		this.inquilino = mock(Usuario.class);
		this.publicacion = mock(Publicacion.class);
		this.propietario = mock(Usuario.class);
		this.reserva = new Reserva(inquilino, fechaDeIngresoDate, fechaDeSalidaDate, estadoReservaAceptada, publicacion);		
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
	
	@Test
	void testReservaTieneUnInquilino() {
		assertEquals(this.inquilino, this.reserva.getInquilino());
	}
	
	@Test
	void testReservaTieneUnPropietarioDePublicacion(){
		when(this.publicacion.getPropietario()).thenReturn(this.propietario);
		assertEquals(this.propietario, this.reserva.getPropietario());
		verify(this.publicacion).getPropietario();
	}
	
	
}
