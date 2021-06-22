package ar.edu.unq.po2.alquilerestemporales;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class UsuarioTestCase {
	private String nombreYApellidoDeUsuario;
	private String nombreYApellidoDeUsuario2;
	private String direccion;
	private String telefono;
	private LocalDate fechaDeAlta;
	private Usuario usuario;
	private String direccion2;
	private String telefono2;
	private Calificacion calificacion1;
	private Calificacion calificacion2;
	private Calificacion calificacion3;
	private String comentarioCalificacionBaja;
	private String comentarioCalificacionMedia;
	private String comentarioCalificacionAlta;
	private CasillaEmail casillaEmail;
	private BibliotecaDeCalificaciones bibliotecaDeCalificaciones;
	private ArrayList<Calificacion> listaDeCalificaciones;
	
	
	@BeforeEach
	void setUp() throws Exception {
		this.nombreYApellidoDeUsuario = "Pepito Gomez";
		this.direccion = "Calle Falsa 123";
		this.telefono = "123654789";
		this.fechaDeAlta = LocalDate.now();
		this.nombreYApellidoDeUsuario2 = "Pepita Gomez";
		this.direccion2="Avenida Siempre Viva 742";
		this.telefono2= "987456321";
		calificacion1 = mock(Calificacion.class);
		calificacion2 = mock(Calificacion.class);
		calificacion3 = mock(Calificacion.class);
		comentarioCalificacionBaja = "Mal propietario, contestaba mal.";
		comentarioCalificacionMedia = "Propietario normal, me dejo las llaves y se fue.";
		comentarioCalificacionAlta = "Buen propietario, me hizo la cena y todo, re copado el tipo.";
		casillaEmail = mock(CasillaEmail.class);
		bibliotecaDeCalificaciones = mock(BibliotecaDeCalificaciones.class);
		this.usuario = new Usuario(nombreYApellidoDeUsuario, direccion, telefono, fechaDeAlta, casillaEmail);
		
	}
	
	@Test
	void testConstructor() {
		assertNotNull(this.usuario);
	}
	
	@Test
	void testGetDatos() {
		assertEquals(this.nombreYApellidoDeUsuario, this.usuario.getNombreYApellido());
		assertEquals(this.direccion, this.usuario.getDireccion());
		assertEquals(this.telefono, this.usuario.getTelefono());
		assertEquals(this.fechaDeAlta, this.usuario.getFechaDeAlta());
	}
	
	@Test
	void testSetDatos() {
		this.usuario.setNombreYApellido(this.nombreYApellidoDeUsuario2);
		this.usuario.setDireccion(this.direccion2);
		this.usuario.setTelefono(this.telefono2);
		assertEquals(this.nombreYApellidoDeUsuario2, this.usuario.getNombreYApellido());
	}
	
	@Test
	void testUsuarioRecibeCalificacion() {
		this.usuario.addCalificacion(calificacion1);
		this.usuario.addCalificacion(calificacion2);
		int num = this.usuario.getCalificaciones().size();
		assertEquals(2, num);
	}
	/*
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
		//BibliotecaDeCalificaciones - Lista de calificaciones
		this.listaDeCalificaciones.add(calificacion1);
		this.listaDeCalificaciones.add(calificacion2);
		this.listaDeCalificaciones.add(calificacion3);
		when(this.bibliotecaDeCalificaciones.getCalificaciones()).thenReturn(listaDeCalificaciones);
		when(this.bibliotecaDeCalificaciones.getPromedioCalificacion()).thenReturn(3.0);
		//AgregarCalificacion
		//this.usuario.addCalificacion(calificacion1);
		//this.usuario.addCalificacion(calificacion2);
		//this.usuario.addCalificacion(calificacion3);
		//PromedioCalificacion
		Double promedioUsuario = this.usuario.getPromedioCalificacion();
		Double promedioCalificaciones = 3.0;
		//Comentarios
		ArrayList<String> comentarios = new ArrayList<String>();
		comentarios.add(comentarioCalificacionBaja);
		comentarios.add(comentarioCalificacionMedia);
		comentarios.add(comentarioCalificacionAlta);
		//BibliotecaDeCalificaciones - Comentarios
		when(this.bibliotecaDeCalificaciones.getComentarios()).thenReturn(comentarios);
		// Verify
		assertEquals(promedioCalificaciones, promedioUsuario);
		assertEquals(comentarios, usuario.getComentarios());
	}*/
	
	@Test
	void testUsuarioTieneCasillaDeMail(){
		assertNotNull(this.usuario.getCasillaEmail());
		assertEquals(this.usuario.getCasillaEmail(), this.casillaEmail);
	}
	
	
	// Testear usuario tiene biblioteca de calificaciones
}
