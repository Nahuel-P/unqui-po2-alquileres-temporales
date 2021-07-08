package ar.edu.unq.po2.alquilerestemporales.webReservas;

public class Administrador {
	
	private WebReservas webAministrada;

	public Administrador(WebReservas webAministrada) {
		this.webAministrada = webAministrada;
	}

	public void crearCategoria(String nombreCategoria) {
		this.webAministrada.addCategoriaCalificable(nombreCategoria);
	}
	
	public void crearTipoDeInmueble(String tipoDeInmueble) {
		this.webAministrada.addTipoDeInmueble(tipoDeInmueble);
	}
	
	public void crearServicio(String nombreServicio) {
		this.webAministrada.addServicio(nombreServicio);
		
	}
	
	
	
}
