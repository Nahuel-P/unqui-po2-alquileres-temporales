package ar.edu.unq.po2.alquilerestemporales;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.alquilerestemporales.webReservas.Administrador;
import ar.edu.unq.po2.alquilerestemporales.webReservas.WebReservas;

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
		verify(web).agregarTipoDeInmueble("Departamento");
	}
	
	@Test
	void testCrearCategoriaCalificable() {
		this.admin.crearCategoria("Inquilino");		
		verify(web).agregarCategoriaCalificable("Inquilino");
	}
	
	@Test
	void testCrearServicio() {
		this.admin.crearServicio("Wi-Fi");		
		verify(web).agregarServicio("Wi-Fi");
	}
	
	
	
	
	
	

}
