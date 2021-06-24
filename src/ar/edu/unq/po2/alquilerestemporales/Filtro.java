package ar.edu.unq.po2.alquilerestemporales;

import java.util.ArrayList;

public abstract class Filtro {
	
	public ArrayList<Publicacion> filtrarPublicaciones(ArrayList<Publicacion> publicaciones) {
			
		ArrayList<Publicacion> filtradas = new ArrayList<Publicacion>();
		for(int i=0; i<publicaciones.size(); i++) {
			if(cumpleCriterios(publicaciones.get(i))) {
				filtradas.add(publicaciones.get(i));
			}else {
				System.out.println("No cumple");
			}
		}
		return filtradas;
	}

	public abstract boolean cumpleCriterios(Publicacion publicacion);
}
