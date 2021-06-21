package ar.edu.unq.po2.alquilerestemporales;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AdministradorTestCase {

	private WebReservas web;
	private Administrador admin;
	
	@BeforeEach
	void setUp() throws Exception {
		web= mock(WebReservas.class);
		admin= new Administrador(web);
	}
	
	@Test
	void testCreation() {
		assertNotNull(this.admin);
	}
	
	@Test
	void testCrearTipoDeInmueble() {
		this.admin.crearTipoDeInmueble("Departamento");
		int resultado = this.web.getTiposDeInmueble().size();
		assertEquals(1, resultado);
	}
	
	@Test
	void testNoSePuedeCrearTipoDeInmuebleRepetidosEnUnSitioWeb() {
		this.admin.crearTipoDeInmueble("Departamento");
		this.admin.crearTipoDeInmueble("Departamento");
		this.admin.crearTipoDeInmueble("Casa");
		int resultado = this.web.getTiposDeInmueble().size();
		assertEquals(2, resultado);
	}
	
	@Test
	void testCrearServicio() {
		this.admin.crearServicio("WI-FI");
		int resultado = this.web.getServicios().size();
		assertEquals(1, resultado);
	}
	
	@Test
	void testNoSePuedeCrearServicioRepetidosEnUnSitioWeb() {
		this.admin.crearServicio("WI-FI");
		this.admin.crearServicio("Agua corriente");
		this.admin.crearServicio("WI-FI");
		int resultado = this.web.getServicios().size();
		assertEquals(2, resultado);
	}
	
	@Test
	void testCrearCategoriaRankeable() {
		this.admin.crearCategoria("Inquilino");
		int resultado = this.web.getCategoriasCalificables().size();
		assertEquals(1, resultado);
	}
	
	@Test
	void testNoSePuedeCrearCategoriaRankeableRepetidasEnUnSitioWeb() {
		this.admin.crearCategoria("Inquilino");
		this.admin.crearCategoria("Inquilino");
		this.admin.crearCategoria("Propietario");
		int resultado = this.web.getCategoriasCalificables().size();
		assertEquals(2, resultado);
	}
	
	

}
