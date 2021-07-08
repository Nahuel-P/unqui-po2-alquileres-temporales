package ar.edu.unq.po2.alquilerestemporales.webReservas;

import java.time.LocalDate;
import java.util.ArrayList;

import ar.edu.unq.po2.alquilerestemporales.filtro.Filtro;
import ar.edu.unq.po2.alquilerestemporales.filtro.FiltroBasico;
import ar.edu.unq.po2.alquilerestemporales.publicacion.Publicacion;
import ar.edu.unq.po2.alquilerestemporales.publicacion.calificable.Usuario;
import ar.edu.unq.po2.alquilerestemporales.reserva.Reserva;

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
		}
	}

	public void eliminarUsuario(Usuario usu) {
		this.usuarios.remove(usu);
	}

	public void publicar(Usuario usu, Publicacion publicacion) {
		if(esUsuarioRegistado(usu)) {
			this.bibliotecaDePublicaciones.cargarPublicacion(publicacion);
		}
	}
	
	public void eliminarPublicacion(Usuario usu, Publicacion publicacion) {
		this.bibliotecaDePublicaciones.borrar(publicacion);
	}
	
	public void addTipoDeInmueble(String nuevoTipo) {
		if(!hayTipoDeInmueble(nuevoTipo)) {
			this.darDeAltaTipoInmueble(nuevoTipo);
		}
	}
	
	public void addCategoriaCalificable(String nombreCategoria) {
		if(!hayCategoria(nombreCategoria)) {
			this.categoriasCalificables.add(nombreCategoria);
		}
	}

	public void addServicio(String nombreServicio) {
		if(!hayServicio(nombreServicio)) {
			this.servicios.add(nombreServicio);
		}
	}
	
	public void solicitarReserva(Usuario usu, Reserva reserva) {
		if(this.esUsuarioRegistado(usu)) {
			this.bibliotecaDeReservas.crearReserva(usu,reserva);
		}
	}
	
	public void aceptarReserva(Usuario usu, Reserva reserva) {
		this.bibliotecaDeReservas.concretarReserva(usu,reserva);
	}

	public void rechazarReserva(Usuario usu, Reserva reserva) {
		this.bibliotecaDeReservas.rechazarReserva(usu,reserva);
	}
	
	public void cancelarReserva(Usuario usu, Reserva reserva) {
		this.bibliotecaDeReservas.declinarReserva(usu,reserva);
	}

	private boolean esUsuarioRegistado(Usuario usu) {
		return this.getUsuarios().contains(usu);
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
		
	public void hacerBusqueda(Usuario usu, FiltroBasico filtroBasico, ArrayList<Filtro> filtros) {
		if(this.esUsuarioRegistado(usu)) {
			ArrayList<Publicacion> busqueda = buscador.buscar(getPublicaciones(),filtroBasico, filtros);
			usu.ultimaBusqueda(busqueda);
		}
	}
	
	public ArrayList<Reserva> reservasFuturas(Usuario usu) {
		ArrayList<Reserva> reservas = new ArrayList<Reserva>();
		if(this.esUsuarioRegistado(usu)) {
			LocalDate hoy = LocalDate.now();
			reservas= this.bibliotecaDeReservas.reservasPosteriores(usu,hoy);
		}
		return reservas;
	}
	
	public ArrayList<Reserva> reservasDeUsuario(Usuario usu) {
		ArrayList<Reserva> reservas = new ArrayList<Reserva>();
		if(this.esUsuarioRegistado(usu)) {
			reservas=this.bibliotecaDeReservas.reservasDelUsuario(usu);
		}
		return reservas;
	}
	




	
	
	

	






	
}
