package ar.edu.unq.po2.alquilerestemporales;

import java.util.ArrayList;

public class FiltroCantidadDeHabitantes extends Filtro {

	private int cantidadDeHuespedes;
	
	public FiltroCantidadDeHabitantes(int cantidadDeHuespedes) {
		this.cantidadDeHuespedes = cantidadDeHuespedes;
	}
	
	public boolean cumpleCriterios(Publicacion publicacion) {
		return publicacion.getCantHabitantes() == cantidadDeHuespedes;
	}

	
}
