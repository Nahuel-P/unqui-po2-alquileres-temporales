package ar.edu.unq.po2.alquilerestemporales;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
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
	
	
	@BeforeEach
	void setUp() throws Exception {
		this.nombreYApellidoDeUsuario = "Pepito Gómez";
		this.direccion = "Calle Falsa 123";
		this.telefono = "123654789";
		this.fechaDeAlta = LocalDate.now();
		this.nombreYApellidoDeUsuario2 = "Pepita Gómez";
		this.direccion2="Avenida Siempre Viva 742";
		this.telefono2= "987456321";
		calificacion1 = mock(Calificacion.class);
		calificacion2 = mock(Calificacion.class);
		calificacion3 = mock(Calificacion.class);
		comentarioCalificacionBaja = "Mal propietario, contestaba mal";
		comentarioCalificacionMedia = "Propietario normal, me dejó las llaves y se fue";
		comentarioCalificacionAlta = "Buen propietario, me hizo la cena y todo, re copado el tipo";
		casillaEmail = mock(CasillaEmail.class);
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
		this.usuario.addCalificacion(calificacion1);
		this.usuario.addCalificacion(calificacion2);
		this.usuario.addCalificacion(calificacion3);
		//PromedioCalificacion
		Double promedioUsuario = this.usuario.getPromedioCalificacion();
		Double promedioCalificaciones = 3.0;
		//Comentarios
		ArrayList<String> comentarios = new ArrayList<String>();
		comentarios.add(comentarioCalificacionBaja);
		comentarios.add(comentarioCalificacionMedia);
		comentarios.add(comentarioCalificacionAlta);
		// Verify
		assertEquals(promedioCalificaciones, promedioUsuario);
		assertEquals(comentarios, usuario.getComentarios());
	}
	
	@Test
	void testUsuarioTieneCasillaDeMail(){
		assertNotNull(this.usuario.getCasillaEmail());
	}
}

