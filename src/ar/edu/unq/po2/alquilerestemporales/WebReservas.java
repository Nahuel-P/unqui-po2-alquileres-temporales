package ar.edu.unq.po2.alquilerestemporales;

import java.time.LocalDate;
import java.util.ArrayList;

public class WebReservas {

	private ArrayList<Usuario> usuarios;
	private BibliotecaDePublicaciones bibliotecaDePublicaciones;
	private ArrayList<String> categoriasCalificables;
	private ArrayList<String> tiposDeInmueble;
	private ArrayList<String> servicios;
	private BibliotecaDeReservas bibliotecaDeReservas;
	private Buscador buscador;

	public WebReservas() {
		this.usuarios = new ArrayList<Usuario>();
		this.bibliotecaDePublicaciones = new BibliotecaDePublicaciones();
		this.bibliotecaDeReservas = new BibliotecaDeReservas();
		this.categoriasCalificables = new ArrayList<String>();
		this.tiposDeInmueble = new ArrayList<String>();
		this.servicios = new ArrayList<String>();
		this.buscador = new Buscador();
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
	
	//public BibliotecaDeReservas biblioteca() {
	//	return this.bibliotecaDeReservas;
	//}
	
	public void asignarNuevaBiblioteca(BibliotecaDeReservas repoReservas) {
		this.bibliotecaDeReservas = repoReservas;
	}
	
	public void asignarNuevaBibliotecaPublicaciones(BibliotecaDePublicaciones repoPulicaciones) {
		this.bibliotecaDePublicaciones = repoPulicaciones;
	}
	
	/*--------------------------------------------------------*/
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
	
	public void eliminarPublicacion(Usuario usu, Publicacion publicacion) {
		if(esPropietarioDePublicacion(usu,publicacion)) {
			this.bibliotecaDePublicaciones.borrar(publicacion);
		}else {
			System.out.println("Usuario invalido para dar de eliminar publicacion");
		}
	}
	
	public void addTipoDeInmueble(String nuevoTipo) {
		if(!hayTipoDeInmueble(nuevoTipo)) {
			this.darDeAltaTipoInmueble(nuevoTipo);
		}
		else {
			System.out.println("Ya existe el tipo de inmueble"+nuevoTipo);
		}
	}
	
	public void addCategoriaCalificable(String nombreCategoria) {
		if(!hayCategoria(nombreCategoria)) {
			this.categoriasCalificables.add(nombreCategoria);
		}
		else {
			System.out.println("Ya existe la categoria"+nombreCategoria);
		}
	}

	public void addServicio(String nombreServicio) {
		if(!hayServicio(nombreServicio)) {
			this.servicios.add(nombreServicio);
		}
		else {
			System.out.println("Ya existe el servicio"+nombreServicio);
		}
	}
	
	public void solicitarReserva(Usuario usu, Reserva reserva) {
		if(this.esUsuarioRegistado(usu)) {
			this.bibliotecaDeReservas.crearReserva(usu,reserva);
		}
		else {
			System.out.println("No existe el usuario en el sistema");
		}
	}
	
	public void aceptarReserva(Usuario usu, Reserva reserva) {
		if(esPropietario(usu,reserva)) {
			this.bibliotecaDeReservas.concretarReserva(usu,reserva);
		}
		else {
			System.out.println("No es el propietario");
		}
		
	}

	public void rechazarReserva(Usuario usu, Reserva reserva) {
		if(esPropietario(usu,reserva)) {
			this.bibliotecaDeReservas.rechazarReserva(usu,reserva);
		}
		else {
			System.out.println("No es el propietario");
		}
	}
	
	public void cancelarReserva(Usuario usu, Reserva reserva) {
		if(this.esUsuarioRegistado(usu) && esInquilino(usu,reserva)) {
			this.bibliotecaDeReservas.declinarReserva(usu,reserva);
		}
		else {
			System.out.println("No existe el usuario en el sistema");
		}
	}

	// metodos de encapsulamiento
	private boolean esUsuarioRegistado(Usuario usu) {
		return this.getUsuarios().contains(usu);
	}
	
	private boolean esPropietarioDePublicacion(Usuario usu, Publicacion publicacion) {
		return publicacion.getPropietario().equals(usu);
	}
	
	private boolean hayTipoDeInmueble(String tipoDeInmueble) {
		return this.getTiposDeInmueble().contains(tipoDeInmueble);
	}
	
	private boolean hayCategoria(String nombreCategoria) {
		return this.getCategoriasCalificables().contains(nombreCategoria);
	}
	
	private boolean hayServicio(String nombreServicio) {
		return this.getServicios().contains(nombreServicio);
	}
	
	public void darDeAltaTipoInmueble(String nombreServicio) {
		this.tiposDeInmueble.add(nombreServicio);
	}

	public ArrayList<Reserva> getTodasLasReservas() {
		return this.bibliotecaDeReservas.getTodasReservas();
	}
	
	public boolean esPropietario(Usuario usu, Reserva reserva) {
		return reserva.getPropietario().equals(usu);
	}
	
	public boolean esInquilino(Usuario usu, Reserva reserva) {
		return reserva.getInquilino().equals(usu);
	}
	
	public void hacerBusqueda(Usuario usu, FiltroBasico filtroBasico, ArrayList<Filtro> filtros) {
		if(this.esUsuarioRegistado(usu)) {
			ArrayList<Publicacion> busqueda = buscador.buscar(getPublicaciones(),filtroBasico, filtros);
			usu.ultimaBusqueda(busqueda);
		}
	}
	
	public void reservasFuturas(Usuario usu) {
		if(this.esUsuarioRegistado(usu)) {
			LocalDate hoy = LocalDate.now();
			this.bibliotecaDeReservas.reservasPosteriores(usu,hoy);
		}
	}
	
	public void reservasDeUsuario(Usuario usu) {
		if(this.esUsuarioRegistado(usu)) {
			this.bibliotecaDeReservas.reservasDelUsuario(usu);
		}
	}
	
	public void calificar(Usuario usu, Reserva reserva) {
		if(this.esUsuarioRegistado(usu)) {
			this.bibliotecaDeReservas.reservasDelUsuario(usu);
		}
	}



	
	
	

	






	
}
