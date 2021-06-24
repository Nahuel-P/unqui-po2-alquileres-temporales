package ar.edu.unq.po2.alquilerestemporales;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FiltroPrecioTestCase {

	private FiltroPrecio filtro;
	private float precioMax1;
	private float precioMax2;
	private float precioMin1;
	private float precioMin2;
	private ArrayList<Publicacion> publicaciones;
	private Publicacion publi1;
	private Publicacion publi2;
	private Publicacion publi3;
	
	@BeforeEach
	void setUp() throws Exception {
		precioMin1= 1000.00f;
		precioMax1= 2000.00f;
		//
		precioMin2= 1500.00f;
		precioMax2= 6000.00f;
		//
		filtro = new FiltroPrecio(precioMax1,precioMax2);
		publi1= mock(Publicacion.class);
		publi2= mock(Publicacion.class);
		publi3= mock(Publicacion.class);
		publicaciones= new ArrayList<Publicacion>();
		publicaciones.add(publi1);
		publicaciones.add(publi2);
		publicaciones.add(publi3);
		
	}
	
	@Test
	void testCreation() {
		assertNotNull(this.filtro);
	}
	
	@Test
	void testFiltroFecha() {
		when(publi1.getPrecioBase()).thenReturn(1500.00f);
		assertTrue(filtro.estaEnFecha(publi1));
	}

}
