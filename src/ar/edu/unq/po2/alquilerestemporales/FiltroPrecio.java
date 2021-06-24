package ar.edu.unq.po2.alquilerestemporales;

import java.util.ArrayList;

public class FiltroPrecio {
	
	float precioMax;
	float precioMin;
	
	public FiltroPrecio(float precioMax, float precioMin) {
		this.precioMax = precioMax;
		this.precioMin = precioMin;
	}
	
	public ArrayList<Publicacion> filtrarPublicaciones(ArrayList<Publicacion> publicaciones) {
		
		ArrayList<Publicacion> filtradas = new ArrayList<Publicacion>();
		for(int i=0; i<publicaciones.size(); i++) {
			if(cumpleCriterios(publicaciones.get(i))) {
				filtradas.add(publicaciones.get(i));
			}else {
				System.out.print("No cumple");
			}
		}
		return filtradas;
	}
	
	public boolean cumpleCriterios(Publicacion publicacion) {
		return (publicacion.getPrecioBase() >= precioMin) && (publicacion.getPrecioBase() <= precioMax);
	}
	
	
}
