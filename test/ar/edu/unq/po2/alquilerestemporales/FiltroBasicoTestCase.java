package ar.edu.unq.po2.alquilerestemporales;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FiltroBasicoTestCase {
	
	private FiltroBasico filtro;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private LocalDate fechaInicioTest;
	private LocalDate fechaFinTest;
	private String ciudad1;
	private String ciudad2;
	private ArrayList<Publicacion> publicaciones;
	private Publicacion publi1;
	private Publicacion publi2;
	private Publicacion publi3;
	
	@BeforeEach
	void setUp() throws Exception {
		fechaInicio= LocalDate.of(2021,01,01);
		fechaFin= LocalDate.of(2021,12,30);
		fechaInicioTest= LocalDate.of(2020,01,01);
		fechaFinTest= LocalDate.of(2020,12,30);
		ciudad1= "Avellaneda";
		filtro = new FiltroBasico(fechaInicio,fechaFin,ciudad1);
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
		when(publi1.getFechaInicio()).thenReturn(this.fechaInicio);
		when(publi1.getFechaFin()).thenReturn(this.fechaFin);
		
		assertTrue(filtro.estaEnFecha(publi1));
	}
	
	@Test
	void testFiltroFechaNoCoincide() {
		when(publi1.getFechaInicio()).thenReturn(this.fechaInicioTest);
		when(publi1.getFechaFin()).thenReturn(this.fechaFinTest);
		
		assertFalse(filtro.estaEnFecha(publi1));
	}
	
	@Test
	void testFiltroCiudadYFecha() {
		when(publi1.getCiudad()).thenReturn("Avellaneda");
		when(publi1.getFechaInicio()).thenReturn(this.fechaInicio);
		when(publi1.getFechaFin()).thenReturn(this.fechaFin);
		
		assertTrue(filtro.cumpleCriterios(publi1));
	}
	
	@Test
	void testFiltroCiudadNoCumple() {
		when(publi1.getCiudad()).thenReturn("Burzaco");
		when(publi1.getFechaInicio()).thenReturn(this.fechaInicio);
		when(publi1.getFechaFin()).thenReturn(this.fechaFin);
		
		assertFalse(filtro.cumpleCriterios(publi1));
	}
	
	@Test
	void testBusquedaBasicaFiltraLista() {
		when(publi1.getCiudad()).thenReturn("Avellaneda");
		when(publi1.getFechaInicio()).thenReturn(this.fechaInicioTest);
		when(publi1.getFechaFin()).thenReturn(this.fechaFinTest);
		
		when(publi2.getCiudad()).thenReturn("Avellaneda");
		when(publi2.getFechaInicio()).thenReturn(this.fechaInicio);
		when(publi2.getFechaFin()).thenReturn(this.fechaFin);
		
		when(publi3.getCiudad()).thenReturn("Avellaneda");
		when(publi3.getFechaInicio()).thenReturn(this.fechaInicio);
		when(publi3.getFechaFin()).thenReturn(this.fechaFin);
		
		int resultado = filtro.filtrarPublicaciones(publicaciones).size();
		assertEquals(2,resultado);
	}

}
