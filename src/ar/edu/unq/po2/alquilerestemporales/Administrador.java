package ar.edu.unq.po2.alquilerestemporales;

public class Administrador {
	
	private WebReservas webAministrada;

	public Administrador(WebReservas webAministrada) {
		this.webAministrada = webAministrada;
	}

	public void crearCategoria(String nombreCategoria) {
		if(!hayCategoriaCreada(nombreCategoria)) {
			this.webAministrada.getCategoriasCalificables().add(nombreCategoria);
		}
		else {
			System.out.println("No se puede agregar la categoria "+nombreCategoria+" porque ya existe");
		}
	}
	
	public void crearTipoDeInmueble(String tipoDeInmueble) {
		if(!hayTipoDeInmuebleCreado(tipoDeInmueble)) {
			this.webAministrada.getTiposDeInmueble().add(tipoDeInmueble);
		}
		else {
			System.out.println("No se puede agregar el tipo de inmueble "+tipoDeInmueble+" porque ya existe");
		}
	}
	
	public void crearServicio(String nombreServicio) {
		if(!hayServicioCreado(nombreServicio)) {
			this.webAministrada.getServicios().add(nombreServicio);
		}
		else {
			System.out.println("No se puede agregar el servicio "+nombreServicio+" porque ya existe");
		}
	}
	
	//metodos privados de encapsulamiento
	private boolean hayCategoriaCreada(String nombreCategoria) {
		return this.webAministrada.getCategoriasCalificables().stream().anyMatch(categoria-> categoria.equals(nombreCategoria));
	}
	
	private boolean hayTipoDeInmuebleCreado(String tipoDeInmueble) {
		return this.webAministrada.getTiposDeInmueble().stream().anyMatch(tipo-> tipo.equals(tipoDeInmueble));
	}
	
	private boolean hayServicioCreado(String nombreServicio) {
		return this.webAministrada.getServicios().stream().anyMatch(servicio-> servicio.equals(nombreServicio));
	}
	
	
	
}
