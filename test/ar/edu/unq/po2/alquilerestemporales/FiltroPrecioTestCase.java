package ar.edu.unq.po2.alquilerestemporales;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.alquilerestemporales.filtro.Filtro;
import ar.edu.unq.po2.alquilerestemporales.filtro.FiltroPrecio;
import ar.edu.unq.po2.alquilerestemporales.publicacion.Publicacion;

class FiltroPrecioTestCase {

	private Filtro filtro;
	private float precioMax;
	private float precioMin;
	
	private ArrayList<Publicacion> publicaciones;
	private Publicacion publi1;
	private Publicacion publi2;
	private Publicacion publi3;
	
	@BeforeEach
	void setUp() throws Exception {
		precioMin= 1000.00f;
		precioMax= 2000.00f;
	
		filtro = new FiltroPrecio(precioMax,precioMin);
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
	void testPrecios() {
		when(publi1.getPrecioBase()).thenReturn(1500.00f);
		when(publi2.getPrecioBase()).thenReturn(2100.00f);
		when(publi3.getPrecioBase()).thenReturn(3000.00f);
		
		int resultado = filtro.filtrarPublicaciones(publicaciones).size();
		assertEquals(resultado,1);
	}

}
