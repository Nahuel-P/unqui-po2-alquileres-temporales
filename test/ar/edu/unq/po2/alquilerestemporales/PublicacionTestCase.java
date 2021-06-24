package ar.edu.unq.po2.alquilerestemporales;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PublicacionTestCase {
	
	private Publicacion publicacion;
	private static LocalTime checkIn;
	private static LocalTime checkOut;
	private static LocalTime checkOut2;
	private double precioBase;
	private Inmueble inmueble;
	private ArrayList <Foto> fotos;
	private Foto foto1;
	private Foto foto2;
	private Foto foto3;
	private Foto foto4;
	private Foto foto5;
	private Foto foto6;
	private Usuario usuario;
	private ArrayList <FormaDePago> formasDePago;
	private Debito debito;
	private Credito credito;
	private Efectivo efectivo;
	private PrecioTemporal precioTemporal;
	private Publicacion publicacion2;
	private Observer observador;
	private IPriceObserver iobservador;
	LocalDate fechaInicioPublicacion;
	LocalDate fechaFinPublicacion;

	@BeforeEach
	void setUp() throws Exception {
		
		usuario = mock(Usuario.class);
		inmueble = mock(Inmueble.class);
		checkIn = LocalTime.of(13, 0);
		checkOut = LocalTime.of(10, 0);
		checkOut2 = LocalTime.of(16, 0);
		fechaInicioPublicacion = LocalDate.parse("2019-09-10");
		fechaFinPublicacion = LocalDate.parse("2025-09-10");
		foto1 = new Foto (12,6);
		foto2 = new Foto (12,6);
		foto3 = new Foto (12,6);
		foto4 = new Foto (12,6);
		foto5 = new Foto (12,6);
		foto6 = new Foto (12,6);
		debito = mock(Debito.class);
		credito = mock(Credito.class);
		efectivo = mock(Efectivo.class);
		formasDePago = new ArrayList <FormaDePago>(); 
		fotos = new ArrayList <Foto>() ;
		precioBase = 500;
		publicacion = new Publicacion(inmueble, usuario, precioBase, checkIn, checkOut, fotos, formasDePago, fechaInicioPublicacion,fechaFinPublicacion);
		publicacion2 = mock(Publicacion.class);
		precioTemporal = mock(PrecioTemporal.class);
		observador = new Observer();
		iobservador = mock(IPriceObserver.class);
	}
	
	@Test
	void testCreation() {
		assertNotNull(this.publicacion);
	}

	@Test
	void testAgregarInmueble() {
		this.publicacion.setInmueble(inmueble);
		assertEquals(this.inmueble, this.publicacion.getInmueble());
	}
	
	@Test
	void testSetCheckInYCheckOut() {
		this.publicacion.setCheckIn(checkIn);
		this.publicacion.setCheckOut(checkOut);
		
		assertEquals(checkIn , this.publicacion.getCheckIn());
		assertEquals(checkOut , this.publicacion.getCheckOut());
	}
	
	@Test
	void testNoAgregaUnCheckoutMayorAlCheckin() {
		this.publicacion.setCheckIn(checkIn);
		this.publicacion.setCheckOut(checkOut2);
		
		assertEquals(LocalTime.of(10, 0), this.publicacion.getCheckOut());
		
	}
	
	@Test
	void testSetPrecioBase() {
		this.publicacion.setPrecioBase(200);
		
		assertEquals(this.publicacion.getPrecioBase(), 200);
	}
	
	@Test
	void testSeAgreganDosFotos() {
		this.fotos.add(foto1);
		this.fotos.add(foto2);
		this.publicacion.setFotos(fotos);
		
		int resultado = this.publicacion.getFotos().size();
		assertEquals(resultado, 2);
	}
	
	@Test
	void testNoAgregaUnaFotoExistente() {
		this.fotos.add(foto1);
		this.fotos.add(foto2);
		this.publicacion.setFotos(fotos);
		this.publicacion.agregarUnaFoto(foto1);
		
		int resultado2 = this.publicacion.getFotos().size();
		assertEquals(resultado2, 2);
	}
	
	@Test
	void testNoAgregaMasDe5Fotos(){
		this.publicacion.agregarUnaFoto(foto1);
		this.publicacion.agregarUnaFoto(foto2);
		this.publicacion.agregarUnaFoto(foto3);
		this.publicacion.agregarUnaFoto(foto4);
		this.publicacion.agregarUnaFoto(foto5);
		this.publicacion.agregarUnaFoto(foto6);
		
		int resultado3 = this.publicacion.getFotos().size();
		assertEquals(resultado3, 5);
	}
	
	@Test
	void testPublicacionTieneTresFormasDePago() {
		this.formasDePago.add(credito);
		this.formasDePago.add(debito);
		this.formasDePago.add(efectivo);
		this.publicacion.setFormasDePago(formasDePago);
		
		ArrayList<FormaDePago> resultado4 = this.publicacion.getFormasDePago();
		assertTrue(resultado4.containsAll(formasDePago));
	}
	
	@Test
	void testPublicacionConFechaCoincidenteConPrecioTemporal() {
		double precioTest = 100;
		when(this.precioTemporal.getPrecio()).thenReturn(precioTest);
		when(this.precioTemporal.getInicio()).thenReturn(LocalDate.of(2021,01,01));
		when(this.precioTemporal.getFinal()).thenReturn(LocalDate.of(2021,10,20));
		
		this.publicacion.establecerPrecioTemporal(precioTemporal);
		this.publicacion.verificadorDePrecio();
		
		double precioFinal = this.publicacion.getPrecioBase();
		assertEquals(precioFinal, precioTemporal.getPrecio());
		
	}
	
	@Test
	void testPublicacionConFechaNOCoincidenteConPrecioTemporal() {
	double precioTest = 100;
		when(this.precioTemporal.getPrecio()).thenReturn(precioTest);
		when(this.precioTemporal.getInicio()).thenReturn(LocalDate.of(2021,10,20));
		when(this.precioTemporal.getFinal()).thenReturn(LocalDate.of(2021,10,25));
		
		this.publicacion.establecerPrecioTemporal(precioTemporal);
		this.publicacion.verificadorDePrecio();
		
		double precioFinal = this.publicacion.getPrecioBase();
		assertEquals(precioFinal, 500);
	}

	@Test
	void testPublicacionBajaDePrecio() {
		this.publicacion.bajarDePrecio(50);
		
		double resultado = this.publicacion.getPrecioBase();
		assertEquals(resultado, 50);
	}
	
	@Test
	void testPublicacionNoBajaDePrecioSiElImporteColocadoEsMayorAlExistente() {
		this.publicacion.bajarDePrecio(1000);
		
		double resultado = this.publicacion.getPrecioBase();
		assertEquals(resultado, 500);
	}
	
	@Test
	void testPublibacionBajaDePrecioYNotificaAObservador() {
		this.publicacion.setObervador(observador);
		this.observador.attach(iobservador);
		this.publicacion.bajarDePrecio(50);
		
		verify(iobservador).update(this.publicacion);
	}
	
	@Test
	void publicacionMuestraDatos() {
		ArrayList<String> servicios = new ArrayList <String>();
		servicios.add("Wifi");
		servicios.add("Aire acondicionado");
		
		when(inmueble.getServicios()).thenReturn(servicios);
		
		this.publicacion.mostrarDatos();
	}
	
	@Test
	void publicacionContemporadasEspecialesMuestraDatosEIncluyeAvisoDeTemporada() {
		ArrayList<String> servicios = new ArrayList <String>();
		servicios.add("Wifi");
		servicios.add("Aire acondicionado");
		
		when(inmueble.getServicios()).thenReturn(servicios);
		
		this.publicacion.establecerPrecioTemporal(precioTemporal);
		this.publicacion.mostrarDatos();
	}
	
	@Test
	void testFechasDeInicioDePublicacion() {
		LocalDate fechaDeInicioDePublicacion = this.publicacion.getFechaInicio();
		assertEquals(this.fechaInicioPublicacion, fechaDeInicioDePublicacion);
	}
	
	@Test
	void testFechasDeFinDePublicacion() {
		LocalDate fechaDeFinDePublicacion = this.publicacion.getFechaFin();
		assertEquals(this.fechaFinPublicacion, fechaDeFinDePublicacion);
	}
	
	@Test
	void testPropietarioDePublicacion() {
		Usuario propietarioDeLaPublicacion = this.publicacion.getPropietario();
		assertEquals(this.usuario, propietarioDeLaPublicacion);
	}
	
	@Test
	void testCiudadDePublicacion() {
		when(this.inmueble.getCiudad()).thenReturn("Avellaneda");
		String ciudadDeInmueble = this.inmueble.getCiudad();
		String ciudadDePublicacion = this.publicacion.getCiudad();
		assertEquals(ciudadDeInmueble, ciudadDePublicacion);
	}
	
	@Test
	void testCapacidadDePublicacion() {
		when(this.inmueble.getCapacidad()).thenReturn(5);
		int capacidadDeInmueble = this.inmueble.getCapacidad();
		int cantidadDePublicacion = this.publicacion.getCantHabitantes();
		assertEquals(capacidadDeInmueble, cantidadDePublicacion);
	}
}
