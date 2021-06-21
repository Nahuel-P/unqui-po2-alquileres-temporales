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
	private WebReservas web2;
	private Administrador admin;
	private Administrador admin2;
	private ArrayList<String> tiposDeInmueble;
	
	@BeforeEach
	void setUp() throws Exception {
		web= mock(WebReservas.class);
		admin= new Administrador(web);
		tiposDeInmueble= new ArrayList<String>();
		tiposDeInmueble.add("Departamento");
		tiposDeInmueble.add("Casa");
		web2= new WebReservas();
		admin2= new Administrador(web2);
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
	
	//@Test
	//void testNoSePuedeCrearTipoDeInmuebleRepetidosEnUnSitioWeb() {
	//	when(web.getTiposDeInmueble()).thenReturn(tiposDeInmueble);
	//	this.admin.crearTipoDeInmueble("PH");
	//	this.admin.crearTipoDeInmueble("Departamento");
	//	this.admin.crearTipoDeInmueble("Departamento");
	//	assertEquals(web.getTiposDeInmueble().size(), 2);
	//}
	
	@Test
	void testNoSePuedeCrearTipoDeInmuebleRepetidosEnUnSitioWeb() {
		//when(web.getTiposDeInmueble()).thenReturn(tiposDeInmueble);
		this.admin2.crearTipoDeInmueble("PH");
		this.admin2.crearTipoDeInmueble("Departamento");
		this.admin2.crearTipoDeInmueble("Departamento");
		assertEquals(web2.getTiposDeInmueble().size(), 2);
	}
	
	
	
	
	

}
