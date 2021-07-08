package ar.edu.unq.po2.alquilerestemporales;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.alquilerestemporales.filtro.Filtro;
import ar.edu.unq.po2.alquilerestemporales.filtro.FiltroCantidadDeHabitantes;
import ar.edu.unq.po2.alquilerestemporales.publicacion.Publicacion;

class FiltroCantidadDeHabitantesTestCase {

	private Filtro filtro;
	private int cantidad;
	private ArrayList<Publicacion> publicaciones;
	private Publicacion publi1;
	private Publicacion publi2;
	private Publicacion publi3;
	
	@BeforeEach
	void setUp() throws Exception {	
		cantidad=4;
		filtro = new FiltroCantidadDeHabitantes(cantidad);
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
		when(publi1.getCantHabitantes()).thenReturn(4);
		when(publi2.getCantHabitantes()).thenReturn(2);
		when(publi3.getCantHabitantes()).thenReturn(4);
		
		int resultado = filtro.filtrarPublicaciones(publicaciones).size();
		assertEquals(resultado,2);
	}
}
