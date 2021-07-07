package ar.edu.unq.po2.alquilerestemporales;

import java.util.ArrayList;
import java.util.stream.Collectors;

public abstract class Filtro {
	
	public ArrayList<Publicacion> filtrarPublicaciones(ArrayList<Publicacion> publicaciones) {
			
		return publicaciones.stream()
	     .filter(publicacion -> this.cumpleCriterios(publicacion))
	     .collect(Collectors.toCollection(ArrayList::new));
	}

	public abstract boolean cumpleCriterios(Publicacion publicacion);
}
