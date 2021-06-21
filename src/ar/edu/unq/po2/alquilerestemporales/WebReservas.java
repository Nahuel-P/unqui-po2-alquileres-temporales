package ar.edu.unq.po2.alquilerestemporales;

import java.util.ArrayList;

public class WebReservas {

	private ArrayList<Usuario> usuarios;
	private BibliotecaDePublicaciones bibliotecaDePublicaciones;
	private ArrayList<String> categoriasCalificables;
	private ArrayList<String> tiposDeInmueble;
	private ArrayList<String> servicios;

	public WebReservas() {
		this.usuarios = new ArrayList<Usuario>();
		this.bibliotecaDePublicaciones = new BibliotecaDePublicaciones();
		this.categoriasCalificables = new ArrayList<String>();
		this.tiposDeInmueble = new ArrayList<String>();
		this.servicios = new ArrayList<String>();
	}
	
	public ArrayList<Usuario> getUsuarios() {
		return this.usuarios;
	}
	
	public ArrayList<Publicacion> getPublicaciones() {
		return this.bibliotecaDePublicaciones.getPublicaciones();
	}
	
	public ArrayList<String> getCategoriasCalificables() {
		return this.categoriasCalificables;
	}
	
	public ArrayList<String> getTiposDeInmueble() {
		return this.tiposDeInmueble;
	}
	
	public ArrayList<String> getServicios() {
		return this.servicios;
	}
	
	public void registrarUsuario(Usuario nuevoUsuario) {
		if(!esUsuarioRegistado(nuevoUsuario)) {
			this.usuarios.add(nuevoUsuario);
			System.out.println("Se dio de alta un usuario en el sistema");
		}
		else {
			System.out.println("El usuario que se quiere dar de alta ya existe");
		}
	}

	public void eliminarUsuario(Usuario usu) {
		if(!esUsuarioRegistado(usu)) {
			System.out.println("No existe el usuario en el sistema");
		}
		else {
			this.usuarios.remove(usu);
			System.out.println("El usuario fue eliminado");
		}
	}

	public void publicar(Usuario usu, Publicacion publicacion) {
		if(esUsuarioRegistado(usu) && esPropietarioDePublicacion(usu,publicacion)) {
			this.bibliotecaDePublicaciones.cargarPublicacion(publicacion);
		}
		else {
			System.out.println("Usuario invalido para dar de alta publicacion");
		}
	}
	
	public void addTipoDeInmueble(String nuevoTipo) {
		this.tiposDeInmueble.add(nuevoTipo);
		
	}

	// metodos privados de encapsulamiento
	private boolean esUsuarioRegistado(Usuario usu) {
		return this.getUsuarios().contains(usu);
	}
	
	private boolean esPropietarioDePublicacion(Usuario usu, Publicacion publicacion) {
		return publicacion.getPropietario().equals(usu);
	}




	
	
	
	
	
}
