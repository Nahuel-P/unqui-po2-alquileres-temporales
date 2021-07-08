package ar.edu.unq.po2.alquilerestemporales.webReservas;

import java.util.ArrayList;

import ar.edu.unq.po2.alquilerestemporales.filtro.Filtro;
import ar.edu.unq.po2.alquilerestemporales.filtro.FiltroBasico;
import ar.edu.unq.po2.alquilerestemporales.publicacion.Publicacion;

public class Buscador {

	public Buscador() {
	}

	public ArrayList<Publicacion> buscar(ArrayList<Publicacion> publicaciones, FiltroBasico filtroBasico, ArrayList<Filtro> filtrosExtra){
		
		ArrayList<Publicacion> resultado = new ArrayList<Publicacion>();
		ArrayList<Publicacion> filtradas = new ArrayList<Publicacion>();
		resultado = filtroBasico.filtrarPublicaciones(publicaciones);
		
		 if(!filtrosExtra.isEmpty()) {
			 for(Filtro filtro : filtrosExtra) {
				 filtradas = filtro.filtrarPublicaciones(publicaciones);
				 resultado.addAll(filtradas);
			}
			resultado = publicacionesComunes(resultado);
		 }
		 return resultado;
	}
	
	private ArrayList<Publicacion>publicacionesComunes (ArrayList<Publicacion> publicaciones){
		
		ArrayList<Publicacion> filtradas = new ArrayList<Publicacion>();
		
		for(Publicacion p : publicaciones) {
			if(publicaciones.indexOf(p) != publicaciones.lastIndexOf(p)){
				filtradas.add(p);
			}
		}
		return filtradas;
	}
}

	