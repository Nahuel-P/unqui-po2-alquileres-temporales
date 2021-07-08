package ar.edu.unq.po2.alquilerestemporales.filtro;

import java.util.ArrayList;
import java.util.stream.Collectors;

import ar.edu.unq.po2.alquilerestemporales.publicacion.Publicacion;

public abstract class Filtro {
	
	public ArrayList<Publicacion> filtrarPublicaciones(ArrayList<Publicacion> publicaciones) {
			
		return publicaciones.stream()
	     .filter(publicacion -> this.cumpleCriterios(publicacion))
	     .collect(Collectors.toCollection(ArrayList::new));
	}

	public abstract boolean cumpleCriterios(Publicacion publicacion);
}
