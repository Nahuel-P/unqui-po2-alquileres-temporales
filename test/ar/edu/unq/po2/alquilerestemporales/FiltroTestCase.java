package ar.edu.unq.po2.alquilerestemporales;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FiltroTestCase {
	
	private Filtro filtro;
	private float precioMax;
	private float precioMin;
	private int maxHabitante;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private String ciudad;
	private ArrayList<Publicacion> publicaciones;
	private Publicacion publi1;
	private Publicacion publi2;
	private Publicacion publi3;
	
	@BeforeEach
	void setUp() throws Exception {
		precioMin= 1000.00f;
		precioMax= 2000.00f;
		maxHabitante = 5;
		fechaInicio= LocalDate.of(2021,01,01);
		fechaFin= LocalDate.of(2021,12,30);
		ciudad= "Wilde";
		publi1= mock(Publicacion.class);
		publi2= mock(Publicacion.class);
		publi3= mock(Publicacion.class);
		publicaciones= new ArrayList<Publicacion>();
		publicaciones.add(publi1);
		publicaciones.add(publi2);
		publicaciones.add(publi3);
		
	}
	
	@Test
	void testCreationPolimorficoParaPrecio() {
		filtro = new FiltroPrecio(precioMax,precioMin);
		assertNotNull(this.filtro);
	}
	
	@Test
	void testCreationPolimorficoParaHabitantes() {
		filtro = new FiltroCantidadDeHabitantes(maxHabitante);
		assertNotNull(this.filtro);
	}
	
	@Test
	void testCreationPolimorficoParaBasico() {
		filtro = new FiltroBasico(fechaInicio,fechaFin,ciudad);
		assertNotNull(this.filtro);
	}
	
	@Test
	void testFiltroPorPrecio() {
		when(publi1.getPrecioBase()).thenReturn(1500.00f);
		when(publi2.getPrecioBase()).thenReturn(2100.00f);
		when(publi3.getPrecioBase()).thenReturn(3000.00f);
		filtro = new FiltroPrecio(precioMax,precioMin);
		int resultado = filtro.filtrarPublicaciones(publicaciones).size();
		assertEquals(resultado,1);
	}
}
