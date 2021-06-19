package ar.edu.unq.po2.alquilerestemporales;

import java.time.LocalDate;
import java.util.ArrayList;

public class Usuario implements ICalificable{
	
	
	private String nombreYApellido;
	private String direccion;
	private String telefono;
	private LocalDate fechaDeAlta;
	private ArrayList<Calificacion> calificaciones;

	public Usuario(String nombreYApellido, String direccion, String telefono, LocalDate fechaDeAlta) {
		this.setNombreYApellido(nombreYApellido);
		this.setDireccion(direccion);
		this.setTelefono(telefono);
		this.fechaDeAlta = fechaDeAlta;
		this.calificaciones = new ArrayList<Calificacion>();
	}

	public Usuario() {
		this("", "", "", LocalDate.now());
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
		Double sum = 0.0;
	    for (Calificacion calificacion: this.calificaciones) {
	        sum += calificacion.getCalificacion();
	    }

	    return (sum/calificaciones.size()); // Esto cambiarlo a stream
	}

	@Override
	public ArrayList<String> getComentarios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCalificacion(Calificacion calificacion) {
		this.calificaciones.add(calificacion);
	}
		
}
