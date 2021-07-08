package ar.edu.unq.po2.alquilerestemporales.publicacion.calificable;

import java.util.ArrayList;

public interface ICalificable {
	public float getPromedioCalificacion();
	public ArrayList<String> getComentarios();
	public void addCalificacion(Calificacion calificacion);
}
