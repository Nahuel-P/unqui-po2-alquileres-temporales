package ar.edu.unq.po2.alquilerestemporales.filtro;

import ar.edu.unq.po2.alquilerestemporales.publicacion.Publicacion;

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
