package ar.edu.unq.po2.alquilerestemporales;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
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
		//
		publi1 = mock(Publicacion.class);
		publi2 = mock(Publicacion.class);
		publi3 = mock(Publicacion.class);
		//
		publicaciones.add(publi1);
		publicaciones.add(publi2);
		publicaciones.add(publi3);
		//
		filtradas1.add(publi1);
		filtradas1.add(publi2);
		//
		filtradas2.add(publi1);


	}
	
	@Test
	void testConstructor() {
		assertNotNull(this.buscador);
	}
	
	@Test
	void testBuscadorConFiltroBasico() {
		when(this.filtroB.filtrarPublicaciones(publicaciones)).thenReturn(filtradas1);
		System.out.println(filtradas1.size());
		int resultado = buscador.buscar(publicaciones,filtroB,filtrosExtra).size();
		assertEquals(resultado,2);
	}
	
	@Test
	void testBuscadorConFiltroBasicoYDePrecio() {
		when(this.filtroB.filtrarPublicaciones(publicaciones)).thenReturn(filtradas1);
		filtrosExtra.add(filtroP);
		this.buscador.buscar(publicaciones,filtroB,filtrosExtra).size();
		verify(filtroP).filtrarPublicaciones(publicaciones);
	}
	
	@Test
	void testBuscadorConFiltroBasicoDePrecioYDeHuspedes() {
		when(this.filtroB.filtrarPublicaciones(publicaciones)).thenReturn(filtradas1);
		filtrosExtra.add(filtroP);
		filtrosExtra.add(filtroH);
		this.buscador.buscar(publicaciones,filtroB,filtrosExtra).size();
		verify(filtroP).filtrarPublicaciones(publicaciones);
		verify(filtroH).filtrarPublicaciones(publicaciones);
	}
	
	@Test
	void testBuscadorConFiltroBasicoDeDeHuspedesYNoDePrecio() {
		when(this.filtroB.filtrarPublicaciones(publicaciones)).thenReturn(filtradas1);
		filtrosExtra.add(filtroH);
		this.buscador.buscar(publicaciones,filtroB,filtrosExtra).size();
		verify(filtroP,never()).filtrarPublicaciones(publicaciones);
		verify(filtroH).filtrarPublicaciones(publicaciones);
	}

	
	
	
	

}
