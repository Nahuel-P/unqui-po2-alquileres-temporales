package ar.edu.unq.po2.alquilerestemporales;

import java.time.LocalDate;
import java.util.ArrayList;

public class Usuario implements ICalificable{
	
	
	private String nombreYApellido;
	private String direccion;
	private String telefono;
	private LocalDate fechaDeAlta;
	private BibliotecaDeCalificaciones bibliotecaDeCalificaciones;
	private CasillaEmail casillaEmail;
	
	public Usuario(String nombreYApellido, String direccion, String telefono, LocalDate fechaDeAlta, CasillaEmail casillaEmail) {
		this.setNombreYApellido(nombreYApellido);
		this.setDireccion(direccion);
		this.setTelefono(telefono);
		this.fechaDeAlta = fechaDeAlta;
		this.casillaEmail = casillaEmail;
		this.bibliotecaDeCalificaciones = new BibliotecaDeCalificaciones();
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
	public Double getPromedioCalificacion() {
		return this.bibliotecaDeCalificaciones.getPromedioCalificacion();
	}

	@Override
	public ArrayList<String> getComentarios() {
		return this.bibliotecaDeCalificaciones.getComentarios();
	}

	@Override
	public void addCalificacion(Calificacion calificacion) {
		this.bibliotecaDeCalificaciones.addCalificacion(calificacion);
	}

	public CasillaEmail getCasillaEmail() {
		return this.casillaEmail;
	}
	
	public ArrayList<Calificacion> getCalificaciones(){
		return this.bibliotecaDeCalificaciones.getCalificaciones();
	}
			
}
