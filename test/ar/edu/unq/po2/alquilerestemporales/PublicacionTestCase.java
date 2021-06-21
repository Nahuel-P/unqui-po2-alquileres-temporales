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
	private Foto foto1;
	private Foto foto2;
	private Foto foto3;
	private Foto foto4;
	private Foto foto5;
	private Foto foto6;
	private Usuario usuario;
	private ArrayList <FormaDePago> formasDePago;
	private Debito debito;
	private Credito credito;
	private Efectivo efectivo;
	

	@BeforeEach
	void setUp() throws Exception {
		
		usuario = mock(Usuario.class);
		inmueble = mock(Inmueble.class);
		checkIn = LocalTime.of(13, 0);
		checkOut = LocalTime.of(10, 0);
		checkOut2 = LocalTime.of(16, 0);
		foto1 = new Foto (12,6);
		foto2 = new Foto (12,6);
		foto3 = new Foto (12,6);
		foto4 = new Foto (12,6);
		foto5 = new Foto (12,6);
		foto6 = new Foto (12,6);
		debito = mock(Debito.class);
		credito = mock(Credito.class);
		efectivo = mock(Efectivo.class);
		formasDePago = new ArrayList <FormaDePago>(); 
		fotos = new ArrayList <Foto>() ;
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
	
	@Test
	
	void testSeAgreganDosFotos() {
		this.fotos.add(foto1);
		this.fotos.add(foto2);
		this.publicacion.setFotos(fotos);
		
		int resultado = this.publicacion.getFotos().size();
		assertEquals(resultado, 2);
	}
	
	@Test
	
	void testNoAgregaUnaFotoExistente() {
		this.fotos.add(foto1);
		this.fotos.add(foto2);
		this.publicacion.setFotos(fotos);
		this.publicacion.agregarUnaFoto(foto1);
		
		int resultado2 = this.publicacion.getFotos().size();
		assertEquals(resultado2, 2);
	}
	
	@Test
	
	void testNoAgregaMasDe5Fotos(){
		this.publicacion.agregarUnaFoto(foto1);
		this.publicacion.agregarUnaFoto(foto2);
		this.publicacion.agregarUnaFoto(foto3);
		this.publicacion.agregarUnaFoto(foto4);
		this.publicacion.agregarUnaFoto(foto5);
		this.publicacion.agregarUnaFoto(foto6);
		
		int resultado3 = this.publicacion.getFotos().size();
		assertEquals(resultado3, 5);
	}
	
	@Test
	
	void testPublicacionTieneTresFormasDePago() {
		this.formasDePago.add(credito);
		this.formasDePago.add(debito);
		this.formasDePago.add(efectivo);
		this.publicacion.setFormasDePago(formasDePago);
		
		ArrayList<FormaDePago> resultado4 = this.publicacion.getFormasDePago();
		assertTrue(resultado4.containsAll(formasDePago));
	}
	
	

}
