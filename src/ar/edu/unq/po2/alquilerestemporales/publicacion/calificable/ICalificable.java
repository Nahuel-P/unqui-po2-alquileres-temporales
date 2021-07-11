package ar.edu.unq.po2.alquilerestemporales.publicacion.calificable;

import java.util.List;

public interface ICalificable {
	public float getPromedioCalificacion();
	public List<String> getComentarios();
	public void addCalificacion(Calificacion calificacion);
}
