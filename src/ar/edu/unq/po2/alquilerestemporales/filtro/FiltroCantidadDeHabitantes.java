package ar.edu.unq.po2.alquilerestemporales.filtro;

import ar.edu.unq.po2.alquilerestemporales.publicacion.Publicacion;

public class FiltroCantidadDeHabitantes extends Filtro {

	private int cantidadDeHuespedes;
	
	public FiltroCantidadDeHabitantes(int cantidadDeHuespedes) {
		this.cantidadDeHuespedes = cantidadDeHuespedes;
	}
	
	public boolean cumpleCriterios(Publicacion publicacion) {
		return publicacion.getCantHabitantes() == cantidadDeHuespedes;
	}

	
}
