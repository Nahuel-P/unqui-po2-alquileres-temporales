package ar.edu.unq.po2.alquilerestemporales;

import java.util.ArrayList;

public class FiltroCantidadDeHabitantes extends Filtro {

	private int cantidadDeHuespedes;
	
	public FiltroCantidadDeHabitantes(int cantidadDeHuespedes) {
		this.cantidadDeHuespedes = cantidadDeHuespedes;
	}
	
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
	
	public boolean cumpleCriterios(Publicacion publicacion) {
		return publicacion.getCantHabitantes() == cantidadDeHuespedes;
	}

	
}
