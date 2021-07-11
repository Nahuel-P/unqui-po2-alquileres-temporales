package ar.edu.unq.po2.alquilerestemporales.webReservas;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.alquilerestemporales.publicacion.Publicacion;

public class BibliotecaDePublicaciones {

	private List<Publicacion> publicaciones;

	
	
	public BibliotecaDePublicaciones() {

		this.publicaciones = new ArrayList<Publicacion>();
	}


	//Modificar para no anidar tanta logica
	public void cargarPublicacion(Publicacion publi1) {
		if(!this.getPublicaciones().stream().anyMatch(publicacion-> (publicacion.getInmueble().equals(publi1.getInmueble())))){
			this.publicaciones.add(publi1);
		}
	}

	public List<Publicacion> getPublicaciones() {
		return this.publicaciones;
		
	}

	public void borrar(Publicacion publi1) {
		this.publicaciones.remove(publi1);	
	}

}
