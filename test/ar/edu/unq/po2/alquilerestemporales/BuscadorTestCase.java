package ar.edu.unq.po2.alquilerestemporales;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BuscadorTestCase {

	private Buscador buscador;
	private FiltroBasico filtroB;
	private Filtro filtroP;
	private Filtro filtroH;
	private ArrayList<Publicacion> publicaciones;
	private ArrayList<Filtro> filtrosExtra;
	private ArrayList<Publicacion> filtradas1;
	private ArrayList<Publicacion> filtradas2;
	private ArrayList<Publicacion> filtradas3;
	private Publicacion publi1;
	private Publicacion publi2;
	private Publicacion publi3;
	private Publicacion publi4;
	private Publicacion publi5;
	@BeforeEach
	void setUp() throws Exception {
		buscador = new Buscador();
		filtroB = mock(FiltroBasico.class);
		filtroP = mock(FiltroPrecio.class);
		filtroH = mock(FiltroCantidadDeHabitantes.class);
		publicaciones= new ArrayList<Publicacion>();
		filtrosExtra= new ArrayList<Filtro>();
		filtradas1= new ArrayList<Publicacion>();
		filtradas2= new ArrayList<Publicacion>();
		filtradas3= new ArrayList<Publicacion>();
		//
		publicaciones.add(publi1);
		publicaciones.add(publi2);
		publicaciones.add(publi3);
		publicaciones.add(publi4);
		publicaciones.add(publi5);
		//
		filtradas1.add(publi1);
		filtradas1.add(publi2);
		filtradas1.add(publi3);
		filtradas2.add(publi3);
		filtradas2.add(publi4);
		filtradas3.add(publi5);

	}
	
	@Test
	void testConstructor() {
		assertNotNull(this.buscador);
	}
	
	@Test
	void testBuscadorConFiltroBasico() {
		when(this.filtroB.filtrarPublicaciones(publicaciones)).thenReturn(filtradas1);
		int resultado = buscador.buscar(publicaciones,filtroB,filtrosExtra).size();
		assertEquals(resultado,3);
	}
}
