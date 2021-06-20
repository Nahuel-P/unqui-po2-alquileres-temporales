package ar.edu.unq.po2.alquilerestemporales;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WebReservasTestCase {
	
	private WebReservas web;
	private Usuario usu1;
	private Usuario usu2;
	private Publicacion publi1;
	private Inmueble inmueble1;
	
	@BeforeEach
	void setUp() throws Exception {
		web= new WebReservas();
		usu1= mock(Usuario.class);
		usu2= mock(Usuario.class);
		publi1= mock(Publicacion.class);
		inmueble1= mock(Inmueble.class);
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
	void testNoAgregarUsuarioRepetido() {
		this.web.registrarUsuario(usu1);
		this.web.registrarUsuario(usu1);
		int resultado = this.web.getUsuarios().size();
		assertEquals(1, resultado);
	}
	
	@Test
	void testEliminarUsuarioRegistrado() {
		this.web.registrarUsuario(usu1);
		this.web.eliminarUsuario(usu1);
		int resultado = this.web.getUsuarios().size();
		assertEquals(0, resultado);
	}
	
	@Test
	void testUnUsuarioNoRegistradoNoPuedeSerEliminado() {
		this.web.registrarUsuario(usu1);
		this.web.eliminarUsuario(usu2);
		int resultado = this.web.getUsuarios().size();
		assertEquals(1, resultado);
	}
	
	@Test
	void testPublicar() {
		when(publi1.getPropietario()).thenReturn(usu1);
		
		this.web.registrarUsuario(usu1);
		this.web.publicar(usu1,publi1);
		int resultado = this.web.getPublicaciones().size();
		assertEquals(1, resultado);
	}
	
	@Test
	void testSoloSePuedePublicarSiEsUsuarioRegistrado() {
		
		this.web.publicar(usu1,publi1);

		int resultado = this.web.getPublicaciones().size();
		assertEquals(0, resultado);
	}
	
	@Test
	void testUnUsuarioSoloPuedeDarDeAltaUnaPublicacionPropia() {
		when(publi1.getPropietario()).thenReturn(usu2);
		
		this.web.registrarUsuario(usu1);
		this.web.publicar(usu1,publi1);

		int resultado = this.web.getPublicaciones().size();
		assertEquals(0, resultado);
	}
	
	@Test
	void testNoSePuedePublicarDosVecesLoMismo() {
		when(publi1.getInmueble()).thenReturn(inmueble1);
		when(publi1.getPropietario()).thenReturn(usu1);
		
		this.web.registrarUsuario(usu1);
		this.web.publicar(usu1,publi1);
		this.web.publicar(usu1,publi1);
		
		int resultado = this.web.getPublicaciones().size();
		assertEquals(1, resultado);
	}
}
