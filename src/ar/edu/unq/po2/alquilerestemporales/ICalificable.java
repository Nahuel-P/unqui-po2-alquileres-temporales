package ar.edu.unq.po2.alquilerestemporales;

import java.util.ArrayList;
import java.util.OptionalDouble;

public interface ICalificable {
	public Double getPromedioCalificacion();
	public ArrayList<String> getComentarios();
	public void addCalificacion(Calificacion calificacion);
}
