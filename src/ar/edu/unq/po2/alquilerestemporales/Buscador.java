package ar.edu.unq.po2.alquilerestemporales;

import java.util.ArrayList;

public class Buscador {

	public Buscador() {
	}

	public ArrayList<Publicacion> buscar(ArrayList<Publicacion> publicaciones, FiltroBasico filtroBasico, ArrayList<Filtro> filtrosExtra){
		
		ArrayList<Publicacion> resultado = new ArrayList<Publicacion>();
		ArrayList<Publicacion> busquedasExtra = new ArrayList<Publicacion>();
		resultado = filtroBasico.filtrarPublicaciones(publicaciones);
		
		 for(Filtro filtro : filtrosExtra) {
			busquedasExtra = filtro.filtrarPublicaciones(publicaciones);
			
			for(Publicacion publicacion : busquedasExtra) {
				if(!resultado.contains(publicacion)) {
					resultado.add(publicacion);
				}
			}
		}
		return resultado;
	}
}
