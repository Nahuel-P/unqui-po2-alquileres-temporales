package ar.edu.unq.po2.alquilerestemporales;

import java.time.LocalDate;
import java.util.ArrayList;

public class Usuario implements ICalificable{
	
	
	private String nombreYApellido;
	private String direccion;
	private String telefono;
	private LocalDate fechaDeAlta;
	private ArrayList<Calificacion> calificaciones;
	private CasillaEmail casillaEmail;
	
	public Usuario(String nombreYApellido, String direccion, String telefono, LocalDate fechaDeAlta, CasillaEmail casillaEmail) {
		this.setNombreYApellido(nombreYApellido);
		this.setDireccion(direccion);
		this.setTelefono(telefono);
		this.fechaDeAlta = fechaDeAlta;
		this.calificaciones = new ArrayList<Calificacion>();
		this.casillaEmail = casillaEmail;
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
		return calificaciones.stream().mapToDouble(calificacion-> calificacion.getCalificacion()).average().orElse(0.0);
	}

	@Override
	public ArrayList<String> getComentarios() {
		ArrayList<String> comentarios = new ArrayList<String>();
		calificaciones.stream().forEach(calificacion -> comentarios.add(calificacion.getComentario()));
		return comentarios;
	}

	@Override
	public void addCalificacion(Calificacion calificacion) {
		this.calificaciones.add(calificacion);
	}//esto esta mal

	public Object getCasillaEmail() {
		return this.casillaEmail;
	}
			
}
