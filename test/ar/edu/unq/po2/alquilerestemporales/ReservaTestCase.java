package ar.edu.unq.po2.alquilerestemporales;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;

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
	private FormaDePago credito;
	private LocalDate fecha1;
	private PrecioTemporal precioTemporal;
	private ArrayList <PrecioTemporal> temporadasEspeciales;
	
	@BeforeEach
	void setUp() throws Exception {
		this.fecha1 = LocalDate.parse("2022-01-15");
		this.fechaDeIngreso = "2022-01-28";
		this.fechaDeSalida = "2022-01-30";
		this.fechaDeIngresoDate = LocalDate.parse(fechaDeIngreso);
		this.fechaDeSalidaDate = LocalDate.parse(fechaDeSalida);
		this.estadoReservaAceptada = mock(Aceptada.class);
		this.inquilino = mock(Usuario.class);
		this.publicacion = mock(Publicacion.class);
		this.propietario = mock(Usuario.class);
		this.credito = mock(Credito.class);
		this.precioTemporal = mock(PrecioTemporal.class);
		this.temporadasEspeciales = new ArrayList<PrecioTemporal>();
		this.reserva = new Reserva(fecha1, inquilino, fechaDeIngresoDate, fechaDeSalidaDate, estadoReservaAceptada, publicacion, credito);		
	}
	
	@Test
	void testConstructor() {
		assertNotNull(this.reserva);
	}
	
	@Test
	void testReservaTieneFechaDeIngreso() {
		LocalDate fechaDeIngresoDeReserva = this.reserva.getFechaDeIngreso();
		assertEquals(this.fechaDeIngresoDate,fechaDeIngresoDeReserva);
	}
	
	@Test
	void testReservaTieneFechaDeSalida() {
		LocalDate fechaDeSalidaDeReserva = this.reserva.getFechaDeSalida();
		assertEquals(this.fechaDeSalidaDate,fechaDeSalidaDeReserva);
	}
	
	@Test
	void testDiferenciaDeDiasEnReserva() {
		int diferenciaDeDias = this.reserva.getDiferenciaDeDias();
		assertEquals(2, diferenciaDeDias);
	}
	

	@Test
	void testReservaTieneUnInquilino() {
		Usuario inquilinoDeReserva = this.reserva.getInquilino();
		assertEquals(this.inquilino, inquilinoDeReserva);
	}
	
	@Test
	void testReservaTieneUnPropietarioDePublicacion(){
		when(this.publicacion.getPropietario()).thenReturn(this.propietario);
		Usuario propietarioDeReserva = this.reserva.getPropietario();
		assertEquals(this.propietario, propietarioDeReserva);
		verify(this.publicacion).getPropietario();
	}
	
	@Test
	void testReservaTieneFormaDePagoCredito() {
		when(this.credito.getTipo()).thenReturn("Credito");
		String tipoDePago = this.reserva.getFormaDePago().getTipo();
		assertEquals("Credito", tipoDePago);
	}
	
	@Test
	void testDiasRestantesHastaReserva() {
		int diasRestantes = this.reserva.diasQueFaltan();
		assertEquals(13, diasRestantes );
	}
	
	@Test
	void testCostoPorDiaEnTemporada() {
		when(this.precioTemporal.getInicio()).thenReturn(LocalDate.parse("2020-06-20"));
		when(this.precioTemporal.getFinal()).thenReturn(LocalDate.parse("2023-06-20"));
		when(this.precioTemporal.getPrecio()).thenReturn(2500.00);
		when(this.publicacion.getTemporadasEspeciales()).thenReturn(this.temporadasEspeciales);
		this.temporadasEspeciales.add(precioTemporal);
		float resultado = reserva.precioEnElDia(LocalDate.now());
		assertEquals(2500.00f, resultado);
	}
	
	@Test
	void testCostoPorDiaFueraDeTemporada() {
		when(this.publicacion.getPrecioBase()).thenReturn(2000.00f);
		float resultado = reserva.precioEnElDia(LocalDate.now());
		assertEquals(2000.00f, resultado);
	}
	
	@Test
	void testCostoTotalAlquilando2Dias() {
		when(this.publicacion.getPrecioBase()).thenReturn(2000.00f);
		float resultado = this.reserva.costoTotal();
		assertEquals(4000.00f, resultado);
	}
	
	@Test
	void testEstadoDeReservaAceptada() {
		this.reserva.setEstado(estadoReservaAceptada);
		assertEquals(this.estadoReservaAceptada, this.reserva.getEstadoDeReserva());
	}	
}
