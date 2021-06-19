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
		return calificaciones.stream().mapToDouble(calificacion-> calificacion.getCalificacion()).average().orElse(0.0);
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
