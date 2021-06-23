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
		this.inmueble = new Inmueble();
		
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
