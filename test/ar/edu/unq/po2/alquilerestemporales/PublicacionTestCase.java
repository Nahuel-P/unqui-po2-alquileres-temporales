package ar.edu.unq.po2.alquilerestemporales;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PublicacionTestCase {
	
	private Publicacion publicacion;
	private static LocalTime checkIn;
	private static LocalTime checkOut;
	private static LocalTime checkOut2;
	private double precioBase;
	private Inmueble inmueble;
	private ArrayList <Foto> fotos;
	private Usuario usuario;
	private ArrayList <FormaDePago> formasDePago;
	

	@BeforeEach
	void setUp() throws Exception {
		
		usuario = mock(Usuario.class);
		inmueble = mock(Inmueble.class);
		checkIn = LocalTime.of(13, 0);
		checkOut = LocalTime.of(10, 0);
		checkOut2 = LocalTime.of(16, 0);
		
		publicacion = new Publicacion(inmueble, usuario, precioBase, checkIn, checkOut, fotos, formasDePago);
		
	}
	
	@Test
	void testCreation() {
		assertNotNull(this.publicacion);
	}

	@Test
	void testAgregarInmueble() {
		this.publicacion.setInmueble(inmueble);
		assertEquals(this.inmueble, this.publicacion.getInmueble());
	}
	
	@Test
	void testSetCheckInYCheckOut() {
		this.publicacion.setCheckIn(checkIn);
		this.publicacion.setCheckOut(checkOut);
		
		assertEquals(checkIn , this.publicacion.getCheckIn());
		assertEquals(checkOut , this.publicacion.getCheckOut());
	}
	
	@Test
	
	void testNoAgregaUnCheckoutMayorAlCheckin() {
		this.publicacion.setCheckIn(checkIn);
		this.publicacion.setCheckOut(checkOut2);
		
		assertEquals(LocalTime.of(10, 0), this.publicacion.getCheckOut());
		
	}
	
	@Test
	
	void testSetPrecioBase() {
		this.publicacion.setPrecioBase(200);
		
		assertEquals(this.publicacion.getPrecioBase(), 200);
	}

}
