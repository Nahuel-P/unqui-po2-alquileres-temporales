package ar.edu.unq.po2.alquilerestemporales;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class UsuarioTestCase {
	private String nombreYApellidoDeUsuario;
	private String nombreYApellidoDeUsuario2;
	private String direccion;
	private String telefono;
	private LocalDate fechaDeAlta;
	private Usuario usuarioSinDatos;
	private Usuario usuario;
	private String direccion2;
	private String telefono2;
	@Mock Calificacion calificacion1;
	@Mock Calificacion calificacion2;
	@Mock Calificacion calificacion3;
	
	@BeforeEach
	void setUp() throws Exception {
		this.usuarioSinDatos = new Usuario();
		this.nombreYApellidoDeUsuario = "Pepito Gómez";
		this.direccion = "Calle Falsa 123";
		this.telefono = "123654789";
		this.fechaDeAlta = LocalDate.now();
		this.usuario = new Usuario(nombreYApellidoDeUsuario, direccion, telefono, fechaDeAlta);
		this.nombreYApellidoDeUsuario2 = "Pepita Gómez";
		this.direccion2="Avenida Siempre Viva 742";
		this.telefono2= "987456321";
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void testCreation() {
		assertNotNull(this.usuarioSinDatos);
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
		when(this.calificacion1.getComentario()).thenReturn("Mal propietario, contestaba mal");
		//CalificacionMedia
		when(this.calificacion2.getCalificacion()).thenReturn(3);
		when(this.calificacion2.getComentario()).thenReturn("Normal, me dejó las llaves y se fue");
		//CalificacionAlta
		when(this.calificacion3.getCalificacion()).thenReturn(5);
		when(this.calificacion3.getComentario()).thenReturn("Buen propietario, ");
		//AgregarCalificacion
		this.usuario.addCalificacion(calificacion1);
		this.usuario.addCalificacion(calificacion2);
		this.usuario.addCalificacion(calificacion3);
		//PromedioCalificacion
		Double promedioUsuario = this.usuario.getPromedioCalificacion();
		Double promedioCalificaciones = 3.0;
		// Verify
		assertEquals(promedioCalificaciones, promedioUsuario);
	}
	
	@Test
	void testCasillaDeMail() {
		
	}
	

}
