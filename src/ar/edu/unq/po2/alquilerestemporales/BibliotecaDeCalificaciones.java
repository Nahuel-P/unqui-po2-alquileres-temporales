package ar.edu.unq.po2.alquilerestemporales;

import java.util.ArrayList;

public class BibliotecaDeCalificaciones {
	
	private ArrayList<Calificacion> calificaciones;
	
	public BibliotecaDeCalificaciones() {
		this.calificaciones = new ArrayList<Calificacion>();
	}
	
	public void addCalificacion(Calificacion calificacion) {
		this.calificaciones.add(calificacion);
		
	}

	public ArrayList<String> getComentarios() {
		ArrayList<String> comentarios = new ArrayList<String>();
		calificaciones.stream().forEach(calificacion -> comentarios.add(calificacion.getComentario()));
		return comentarios;
	}

	public Double getPromedioCalificacion() {
		return calificaciones.stream().mapToDouble(calificacion-> calificacion.getCalificacion()).average().orElse(0.0);
	}

}