package ar.edu.unq.po2.alquilerestemporales;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.alquilerestemporales.filtro.Filtro;
import ar.edu.unq.po2.alquilerestemporales.filtro.FiltroBasico;
import ar.edu.unq.po2.alquilerestemporales.publicacion.Publicacion;
import ar.edu.unq.po2.alquilerestemporales.publicacion.calificable.Inmueble;
import ar.edu.unq.po2.alquilerestemporales.publicacion.calificable.Usuario;
import ar.edu.unq.po2.alquilerestemporales.reserva.Concluida;
import ar.edu.unq.po2.alquilerestemporales.reserva.Reserva;
import ar.edu.unq.po2.alquilerestemporales.webReservas.BibliotecaDePublicaciones;
import ar.edu.unq.po2.alquilerestemporales.webReservas.BibliotecaDeReservas;
import ar.edu.unq.po2.alquilerestemporales.webReservas.WebReservas;

class WebReservasTestCase {
	
	private WebReservas web;
	private Usuario usu1;
	private Usuario usu2;
	private Publicacion publi1;
	private Inmueble inmueble1;
	private Concluida concluida;
	private Reserva reserva1;
	private LocalDate hoy;
	private BibliotecaDeReservas bibliotecaDeReserva;
	private BibliotecaDePublicaciones bibliotecaDePublicaciones;
	private FiltroBasico filtroBasico;
	private ArrayList<Filtro> filtrosExtra;
	private ArrayList<Publicacion> resultado;
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		usu1= mock(Usuario.class);
		usu2= mock(Usuario.class);
		publi1= mock(Publicacion.class);
		inmueble1= mock(Inmueble.class);
		reserva1=mock(Reserva.class);
		bibliotecaDeReserva=mock(BibliotecaDeReservas.class);
		bibliotecaDePublicaciones=mock(BibliotecaDePublicaciones.class);
		web= new WebReservas();
		web.setBibliotecaDePublicaciones(bibliotecaDePublicaciones);
		web.setBibliotecaDeReservas(bibliotecaDeReserva);
		filtroBasico= mock(FiltroBasico.class);
		resultado = new ArrayList<Publicacion>();
		filtrosExtra = new ArrayList<Filtro>();
		hoy= LocalDate.now();
	}
	
	@Test
	void testCreation() {
		assertNotNull(this.web);
	}
	
	@Test
	void testAgregarUsuario() {
		this.web.registrarUsuario(usu1);
		int resultado = this.web.getUsuarios().size();
		assertEquals(1, resultado);
	}
				
	@Test
	void testPublicar() {
		this.web.publicar(publi1);
		verify(bibliotecaDePublicaciones).cargarPublicacion(publi1);
	}
	
	
	@Test
	void testSeObtieneListadoDePublicaciones() {
		this.web.getPublicaciones();
		verify(bibliotecaDePublicaciones).getPublicaciones();
	}
	
	@Test
	void testUsuarioCreaUnaReserva() {
		this.web.solicitarReserva(reserva1);	
		verify(bibliotecaDeReserva).crearReserva(reserva1);
	}
		
	@Test
	void testAceptarUnaReserva() {
		this.web.aceptarReserva(reserva1);	
		verify(bibliotecaDeReserva).concretarReserva(reserva1);
	}
	
	
	@Test
	void testRechazarUnaReserva() {
		this.web.rechazarReserva(reserva1);	
		verify(bibliotecaDeReserva).rechazarReserva(reserva1);
	}
		
	@Test
	void testUnInquilinoCancelaUnaReservaPropia() {
		this.web.cancelarReserva(reserva1);	
		verify(bibliotecaDeReserva).declinarReserva(reserva1);
	}
	
	@Test
	void testSeDioDeAltaUnTipoDeInmueble() {
		this.web.agregarTipoDeInmueble("PH");
		this.web.agregarTipoDeInmueble("Casa");
		int resultado = web.getTiposDeInmueble().size();
		assertEquals(2,resultado);
	}
	
	@Test
	void testSeDioDeAltaUnServicio() {
		this.web.agregarServicio("Agua Corriente");
		this.web.agregarServicio("Wi-Fi");
		int resultado = web.getServicios().size();
		assertEquals(2,resultado);
	}
	
	@Test
	void testSeDioDeAltaUnaCategoriaCalificable() {
		this.web.agregarCategoriaCalificable("Inquilino");
		int resultado = web.getCategoriasCalificables().size();
		assertEquals(1,resultado);
	}
	
	@Test
	void testUsuarioHaceBusqueda() {
		this.web.registrarUsuario(usu1);
		web.hacerBusqueda(filtroBasico, filtrosExtra);
		verify(usu1).ultimaBusqueda(resultado);
	}
	
	@Test
	void testUsuarioNoRegistradoNoHaceBusqueda() {
		web.hacerBusqueda(usu1, filtroBasico, filtrosExtra);
		verify(usu1,never()).ultimaBusqueda(resultado);
	}
	
	@Test
	void testSeAgregaUnaCategoriaNueva() {
		web.agregarCategoriaCalificable("Propietario");
		int resultado = web.getCategoriasCalificables().size();
		assertEquals(1,resultado);
	}
	
	@Test
	void testNoSeAgregaUnaCategoriaRepetida() {
		web.agregarCategoriaCalificable("Inquilino");
		web.agregarCategoriaCalificable("Inquilino");
		int resultado = web.getCategoriasCalificables().size();
		assertEquals(1,resultado);
	}
	
	@Test
	void testSeAgregaUnServicioNuevo() {
		web.agregarServicio("Wi-Fi");
		int resultado = web.getServicios().size();
		assertEquals(1,resultado);
	}
	
	@Test
	void testNoAgregaUnServicioRepetido() {
		web.agregarServicio("Gas");
		web.agregarServicio("Gas");
		int resultado = web.getServicios().size();
		assertEquals(1,resultado);
	}
	
	@Test
	void testSeAgregaUnNuevoTipoDeInmueble() {
		web.agregarTipoDeInmueble("Casa");
		int resultado = web.getTiposDeInmueble().size();
		assertEquals(1,resultado);
	}
	
	@Test
	void testNoSeAgregaUnTipoDeInmuebleRepetido() {
		web.agregarTipoDeInmueble("Departamento");
		web.agregarTipoDeInmueble("Departamento");
		int resultado = web.getTiposDeInmueble().size();
		assertEquals(1,resultado);
	}
	
	@Test
	void testUsuarioRegistradoBuscaReservasFuturas() {
		this.web.registrarUsuario(usu1);
		web.reservasFuturas(usu1);
		verify(this.bibliotecaDeReserva).reservasPosteriores(usu1,this.hoy);
	}
	
	@Test
	void testUsuarioNoRegistradoNoPuedeBuscarReservasFuturas() {
		web.reservasFuturas(usu1);
		verify(this.bibliotecaDeReserva,never()).reservasPosteriores(usu1,this.hoy);
	}
	
	@Test
	void testUsuarioRegistradoBuscaReservasPropias() {
		this.web.registrarUsuario(usu1);
		web.reservasDeUsuario(usu1);
		verify(this.bibliotecaDeReserva).reservasDelUsuario(usu1);
	}
	
	@Test
	void testUsuarioNoRegistradoNoPuedeBuscarReservas() {
		web.reservasDeUsuario(usu1);
		verify(this.bibliotecaDeReserva,never()).reservasDelUsuario(usu1);
	}

}
