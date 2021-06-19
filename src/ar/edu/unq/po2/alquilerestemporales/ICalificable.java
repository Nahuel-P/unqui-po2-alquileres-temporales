package ar.edu.unq.po2.alquilerestemporales;

import java.util.ArrayList;

public interface ICalificable {
	public Double getPromedioCalificacion();
	public ArrayList<String> getComentarios();
	public void addCalificacion(Calificacion calificacion);
}
