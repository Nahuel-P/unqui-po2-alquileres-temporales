package ar.edu.unq.po2.alquilerestemporales.publicacion.calificable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.alquilerestemporales.publicacion.Publicacion;

public class Usuario implements ICalificable{
	
	
	private String nombreYApellido;
	private String direccion;
	private String telefono;
	private LocalDate fechaDeAlta;
	private BibliotecaDeCalificaciones bibliotecaDeCalificaciones;
	private CasillaEmail casillaEmail;
	private List<Publicacion> busquedaReciente;
	
	public Usuario(String nombreYApellido, String direccion, String telefono, LocalDate fechaDeAlta, CasillaEmail casillaEmail) {
		this.setNombreYApellido(nombreYApellido);
		this.setDireccion(direccion);
		this.setTelefono(telefono);
		this.fechaDeAlta = fechaDeAlta;
		this.casillaEmail = casillaEmail;
		this.bibliotecaDeCalificaciones = new BibliotecaDeCalificaciones();
		this.busquedaReciente= new ArrayList<Publicacion>();
	}

	public String getNombreYApellido() {
		return this.nombreYApellido;
	}
	
	public String getDireccion() {
		return this.direccion;
	}
	
	public String getTelefono() {
		return this.telefono;
	}

	public Object getFechaDeAlta() {
		return fechaDeAlta;
	}

	public void setNombreYApellido(String nombreYApellidoDeUsuario) {
		this.nombreYApellido = nombreYApellidoDeUsuario;		
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public float getPromedioCalificacion() {
		return this.bibliotecaDeCalificaciones.getPromedioCalificacion();
	}

	@Override
	public List<String> getComentarios() {
		return this.bibliotecaDeCalificaciones.getComentarios();
	}

	@Override
	public void addCalificacion(Calificacion calificacion) {
		this.bibliotecaDeCalificaciones.addCalificacion(calificacion);
	}

	public CasillaEmail getCasillaEmail() {
		return this.casillaEmail;
	}
	
	public List<Calificacion> getCalificaciones(){
		return this.bibliotecaDeCalificaciones.getCalificaciones();
	}

	public void recibirMail(String mensaje) {
		this.casillaEmail.recibirMail(mensaje);
	}
	
}
