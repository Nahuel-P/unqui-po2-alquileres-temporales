package ar.edu.unq.po2.alquilerestemporales;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalificacionTestCase {
	private Calificacion calificacion;
	private Calificacion calificacion2;
	private int puntuacionDeCalificacion1;
	private int puntuacionDeCalificacion2;
	private String comentarioCalificacion1;
	private String comentarioCalificacion2;

	@BeforeEach
	void setUp() throws Exception {
		puntuacionDeCalificacion1 = -2;
		puntuacionDeCalificacion2 = 3;
		comentarioCalificacion1 = "Mal propietario, contestaba mal.";
		comentarioCalificacion2 = "Propietario normal, me dejo las llaves y se fue.";		
	}
	
	@Test
	void testConstructor() {
		calificacion = new Calificacion(puntuacionDeCalificacion2, comentarioCalificacion2);
		assertNotNull(this.calificacion);
	}
	
	@Test
	void testPuntuacionCorrecta() {
		calificacion = new Calificacion(puntuacionDeCalificacion2, comentarioCalificacion2);
		assertEquals(puntuacionDeCalificacion2, calificacion.getCalificacion());
	}
	@Test
	void testPuntuacionIncorrecta() {
		calificacion2 = new Calificacion(puntuacionDeCalificacion1, comentarioCalificacion1);
		assertEquals(0, this.calificacion2.getCalificacion());
	}
	
	@Test
	void testComentarioDeCalificacion() {
		calificacion = new Calificacion(puntuacionDeCalificacion2, comentarioCalificacion2);
		assertEquals(comentarioCalificacion2, calificacion.getComentario());
	}
	

}
