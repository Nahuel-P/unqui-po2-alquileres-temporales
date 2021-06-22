package ar.edu.unq.po2.alquilerestemporales;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

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
		verify(web).addTipoDeInmueble("Departamento");
	}
	
	@Test
	void testCrearCategoriaCalificable() {
		this.admin.crearCategoria("Inquilino");		
		verify(web).addCategoriaCalificable("Inquilino");
	}
	
	@Test
	void testCrearServicio() {
		this.admin.crearServicio("Wi-Fi");		
		verify(web).addServicio("Wi-Fi");
	}
	
	
	
	
	
	

}
