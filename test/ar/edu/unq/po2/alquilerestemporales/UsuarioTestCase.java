package ar.edu.unq.po2.alquilerestemporales;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

}
