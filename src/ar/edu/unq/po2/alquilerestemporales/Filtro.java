package ar.edu.unq.po2.alquilerestemporales;

import java.util.ArrayList;

public abstract class Filtro {
	
	public ArrayList<Publicacion> filtrarPublicaciones(ArrayList<Publicacion> publicaciones) {
			
		ArrayList<Publicacion> filtradas = new ArrayList<Publicacion>();
		for(Publicacion publicacion : publicaciones) {
			if(this.cumpleCriterios(publicacion)) {
				filtradas.add(publicacion);
			}
		}
		return filtradas;
	}

	public abstract boolean cumpleCriterios(Publicacion publicacion);
}
