package ar.edu.unq.po2.alquilerestemporales;

import java.util.ArrayList;

public class BibliotecaDePublicaciones {

	private ArrayList<Publicacion> publicaciones;

	
	
	public BibliotecaDePublicaciones() {

		this.publicaciones = new ArrayList<Publicacion>();
	}


	//Modificar para no anidar tanta logica
	public void cargarPublicacion(Publicacion publi1) {
		if(!this.getPublicaciones().stream().anyMatch(publicacion-> (publicacion.getInmueble().equals(publi1.getInmueble())))){
			this.publicaciones.add(publi1);
		}
		else {
			System.out.println("Error en la publicacion");
		}
	}

	public ArrayList<Publicacion> getPublicaciones() {
		return this.publicaciones;
		
	}

}