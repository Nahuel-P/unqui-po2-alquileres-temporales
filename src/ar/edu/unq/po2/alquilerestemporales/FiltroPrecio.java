package ar.edu.unq.po2.alquilerestemporales;

import java.util.ArrayList;

public class FiltroPrecio extends Filtro {
	
	float precioMax;
	float precioMin;
	
	public FiltroPrecio(float precioMax, float precioMin) {
		this.precioMax = precioMax;
		this.precioMin = precioMin;
	}
		
	public boolean cumpleCriterios(Publicacion publicacion) {
		return (publicacion.getPrecioBase() >= precioMin) && (publicacion.getPrecioBase() <= precioMax);
	}
}
