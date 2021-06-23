package ar.edu.unq.po2.alquilerestemporales;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InmuebleTestCase {
	
	private Inmueble inmueble;
	private double superficie;
	private String pais;
	private String ciudad;
	private String direccion;
	private int capacidad;
	private String tipoDeInmueble;
	private ArrayList <String>servicios;
	
	@BeforeEach
	void setUp() throws Exception {
		this.inmueble = new Inmueble(superficie, pais, ciudad, direccion, capacidad, tipoDeInmueble, servicios);
		superficie = 100;
		pais = "Argentina";
		ciudad = "Avellaneda";
		direccion = "Mitre 123";
		capacidad = 5;
		tipoDeInmueble = "Departamento";
		servicios = new ArrayList<String>();
	}

	@Test
	void testSettersYGetters() {
		this.inmueble.setSuperficie(superficie);
		this.inmueble.setPais(pais);
		this.inmueble.setCiudad(ciudad);
		this.inmueble.setDireccion(direccion);
		this.inmueble.setCapacidad(capacidad);
		this.inmueble.setTipoDeInmueble(tipoDeInmueble);
		this.inmueble.setServicios(servicios);
		this.inmueble.agregarServicio("Wifi");
		
		assertEquals(this.inmueble.getSuperficie(), 100);
		assertEquals(this.inmueble.getPais(), "Argentina");
		assertEquals(this.inmueble.getCiudad(), "Avellaneda");
		assertEquals(this.inmueble.getDireccion(), "Mitre 123");
		assertEquals(this.inmueble.getCapacidad(), 5);
		assertEquals(this.inmueble.getTipoDeInmueble(), "Departamento");
		assertEquals(this.inmueble.getServicios(), servicios);
	}

}
