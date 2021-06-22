package ar.edu.unq.po2.alquilerestemporales;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestBibliotecaDeCalificaciones {

	private BibliotecaDeCalificaciones bibliotecaDeCalificaciones;
	private Calificacion calificacion1;
	private Calificacion calificacion2;
	private Calificacion calificacion3;
	private String comentarioCalificacionBaja;
	private String comentarioCalificacionMedia;
	private String comentarioCalificacionAlta;
	
	@BeforeEach
	void setUp() throws Exception {
		bibliotecaDeCalificaciones = new BibliotecaDeCalificaciones();
		calificacion1 = mock(Calificacion.class);
		calificacion2 = mock(Calificacion.class);
		calificacion3 = mock(Calificacion.class);
		comentarioCalificacionBaja = "Mal propietario, contestaba mal.";
		comentarioCalificacionMedia = "Propietario normal, me dejó las llaves y se fue.";
		comentarioCalificacionAlta = "Buen propietario, me hizo la cena y todo, re copado el tipo.";
	}
	
	@Test
	void testConstructor() {
		assertNotNull(this.bibliotecaDeCalificaciones);
	}
	
	@Test
	void testDatosCalificaciones() {
		//CalificacionBaja
		when(this.calificacion1.getCalificacion()).thenReturn(1);
		when(this.calificacion1.getComentario()).thenReturn(comentarioCalificacionBaja);
		//CalificacionMedia
		when(this.calificacion2.getCalificacion()).thenReturn(3);
		when(this.calificacion2.getComentario()).thenReturn(comentarioCalificacionMedia);
		//CalificacionAlta
		when(this.calificacion3.getCalificacion()).thenReturn(5);
		when(this.calificacion3.getComentario()).thenReturn(comentarioCalificacionAlta);
		//AgregarCalificacion
		this.bibliotecaDeCalificaciones.addCalificacion(calificacion1);
		this.bibliotecaDeCalificaciones.addCalificacion(calificacion2);
		this.bibliotecaDeCalificaciones.addCalificacion(calificacion3);
		//PromedioCalificacion
		Double promedioUsuario = this.bibliotecaDeCalificaciones.getPromedioCalificacion();
		Double promedioCalificaciones = 3.0;
		//Comentarios
		ArrayList<String> comentarios = new ArrayList<String>();
		comentarios.add(comentarioCalificacionBaja);
		comentarios.add(comentarioCalificacionMedia);
		comentarios.add(comentarioCalificacionAlta);
		// Verify
		assertEquals(promedioCalificaciones, promedioUsuario);
		assertEquals(comentarios, bibliotecaDeCalificaciones.getComentarios());
	}
}
