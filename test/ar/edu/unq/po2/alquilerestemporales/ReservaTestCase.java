package ar.edu.unq.po2.alquilerestemporales;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.alquilerestemporales.publicacion.PrecioTemporal;
import ar.edu.unq.po2.alquilerestemporales.publicacion.Publicacion;
import ar.edu.unq.po2.alquilerestemporales.publicacion.calificable.Inmueble;
import ar.edu.unq.po2.alquilerestemporales.publicacion.calificable.Usuario;
import ar.edu.unq.po2.alquilerestemporales.publicacion.formasDePago.Credito;
import ar.edu.unq.po2.alquilerestemporales.publicacion.formasDePago.FormaDePago;
import ar.edu.unq.po2.alquilerestemporales.reserva.Aceptada;
import ar.edu.unq.po2.alquilerestemporales.reserva.Cancelada;
import ar.edu.unq.po2.alquilerestemporales.reserva.Concluida;
import ar.edu.unq.po2.alquilerestemporales.reserva.EstadoReserva;
import ar.edu.unq.po2.alquilerestemporales.reserva.IBookingListener;
import ar.edu.unq.po2.alquilerestemporales.reserva.Pendiente;
import ar.edu.unq.po2.alquilerestemporales.reserva.Rechazada;
import ar.edu.unq.po2.alquilerestemporales.reserva.Reserva;

class ReservaTestCase {
	private Reserva reserva;
	private String fechaDeIngreso;
	private String fechaDeSalida;
	private LocalDate fechaDeIngresoDate;
	private LocalDate fechaDeSalidaDate;
	private Usuario inquilino;
	private Publicacion publicacion;
	private Usuario propietario;
	private FormaDePago credito;
	private LocalDate fecha1;
	private PrecioTemporal precioTemporal;
	private List <PrecioTemporal> temporadasEspeciales;
	private EstadoReserva estadoReservaAceptada;
	private EstadoReserva estadoReservaRechazada;
	private EstadoReserva estadoReservaCondicional;
	private EstadoReserva estadoReservaCancelada;
	private EstadoReserva estadoReservaConcluida;
	private EstadoReserva estadoReservaPendiente;
	private IBookingListener bookingListener;
	private IBookingListener bookingListener2;
	
	
	@BeforeEach
	void setUp() throws Exception {
		this.fecha1 = LocalDate.parse("2022-01-15");
		this.fechaDeIngreso = "2022-01-28";
		this.fechaDeSalida = "2022-01-30";
		this.fechaDeIngresoDate = LocalDate.parse(fechaDeIngreso);
		this.fechaDeSalidaDate = LocalDate.parse(fechaDeSalida);
		this.estadoReservaAceptada = mock(Aceptada.class);
		this.estadoReservaRechazada = mock(Rechazada.class);
		this.estadoReservaCancelada = mock(Cancelada.class);
		this.estadoReservaConcluida = mock(Concluida.class);
		this.estadoReservaPendiente = mock(Pendiente.class);
		this.bookingListener = mock(IBookingListener.class);
		this.bookingListener2 = mock(IBookingListener.class);
		this.inquilino = mock(Usuario.class);
		this.publicacion = mock(Publicacion.class);
		this.propietario = mock(Usuario.class);
		this.credito = mock(Credito.class);
		this.precioTemporal = mock(PrecioTemporal.class);
		this.temporadasEspeciales = new ArrayList<PrecioTemporal>();
		this.reserva = new Reserva(fecha1, inquilino, fechaDeIngresoDate, fechaDeSalidaDate, estadoReservaPendiente, publicacion, credito);		
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
		when(this.precioTemporal.getPrecio()).thenReturn(2500.00f);
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
	void testCostoPorDiaEnReserva() {
		when(this.publicacion.getPrecioBase()).thenReturn(2000.00f);
		float costoPorDiaDeReserva = this.reserva.costoPorDia();
		assertEquals(2000.00f, costoPorDiaDeReserva);
	}
		
	@Test
	void testEstadoDeReservaAceptada() {
		this.reserva.setEstado(estadoReservaAceptada);
		EstadoReserva estadoDeReserva = this.reserva.getEstadoDeReserva();
		assertEquals(this.estadoReservaAceptada, estadoDeReserva);
	}
	
	@Test
	void testEstadoDeReservaRechazada() {
		this.reserva.setEstado(estadoReservaRechazada);
		EstadoReserva estadoDeReserva = this.reserva.getEstadoDeReserva();
		assertEquals(this.estadoReservaRechazada, estadoDeReserva);
	}
	@Test
	void testEstadoDeReservaCondicional() {
		this.reserva.setEstado(estadoReservaCondicional);
		EstadoReserva estadoDeReserva = this.reserva.getEstadoDeReserva();
		assertEquals(this.estadoReservaCondicional, estadoDeReserva);
	}
	
	@Test
	void testEstadoDeReservaCancelada() {
		this.reserva.setEstado(estadoReservaCancelada);
		EstadoReserva estadoDeReserva = this.reserva.getEstadoDeReserva();
		assertEquals(this.estadoReservaCancelada, estadoDeReserva);
	}
	
	@Test
	void testEstadoDeReservaConcluida() {
		this.reserva.setEstado(estadoReservaConcluida);
		EstadoReserva estadoDeReserva = this.reserva.getEstadoDeReserva();
		assertEquals(this.estadoReservaConcluida, estadoDeReserva);
	}
	
	
	@Test
	void testEstadoDeReservaPendiente() {
		this.reserva.setEstado(estadoReservaPendiente);
		EstadoReserva estadoDeReserva = this.reserva.getEstadoDeReserva();
		assertEquals(this.estadoReservaPendiente, estadoDeReserva);
	}
	
	@Test
	void testReservaTieneUnListener() {
		this.reserva.addListener(bookingListener);
		List<IBookingListener> listeners = this.reserva.getListeners();
		int cantidadDeListeners = listeners.size();
		assertEquals(1, cantidadDeListeners);
	}
	
	@Test
	void testReservaSeLeAgregan2ListenersYSeBorra1() {
		this.reserva.addListener(bookingListener);
		this.reserva.addListener(bookingListener2);
		this.reserva.removeListener(bookingListener);
		List<IBookingListener> listeners = this.reserva.getListeners();
		int cantidadDeListeners = listeners.size();
		assertEquals(1, cantidadDeListeners);
	}
	
	@Test
	void testInmuebleDeReserva() {
		Inmueble inmuebleDePublicacion = this.publicacion.getInmueble();
		Inmueble inmuebleDeReserva = this.reserva.getInmueble();
		assertEquals(inmuebleDePublicacion, inmuebleDeReserva );
	}
	
	@Test
	void testBookingListenerRecibeMensajeReservaConcretada() {
		this.reserva.addListener(bookingListener);
		this.reserva.notificarConcretada();
		verify(bookingListener).reservaConcretada(this.reserva, fechaDeIngresoDate, fechaDeSalidaDate);
	}

	@Test
	void testBookingListenerRecibeMensajeReservaCancelada() {
		this.reserva.addListener(bookingListener);
		this.reserva.notificarCancelada();
		verify(bookingListener).reservaCancelada(this.reserva, fechaDeIngresoDate, fechaDeSalidaDate);
	}
	
	@Test
	void testReservaEnEstadoPendienteEsAceptada() {
		this.reserva.setEstado(estadoReservaPendiente);
		this.reserva.aceptar();
		verify(this.estadoReservaPendiente).aceptar(reserva);
	}
	
	@Test
	void testReservaEnEstadoPendienteEsRechazada() {
		this.reserva.setEstado(estadoReservaPendiente);
		this.reserva.rechazar();
		verify(this.estadoReservaPendiente).rechazar(reserva);
	}
	
	@Test
	void testReservaEnEstadoConcluidaEsCancelada() {
		this.reserva.setEstado(estadoReservaConcluida);
		this.reserva.cancelar();
		verify(this.estadoReservaConcluida).cancelar(reserva);
	}
	
	@Test
	void testUsuarioDeReservaCoincideConElUsuarioRecibidoPorParametro() {
		Usuario usuario = this.inquilino;
		assertTrue(this.reserva.esReservaDeUsuario(usuario));
	}
}
