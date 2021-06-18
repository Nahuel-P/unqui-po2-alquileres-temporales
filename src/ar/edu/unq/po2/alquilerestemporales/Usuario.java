package ar.edu.unq.po2.alquilerestemporales;

import java.time.LocalDate;

public class Usuario {
	
	
	private String nombreYApellido;
	private String direccion;
	private String telefono;
	private LocalDate fechaDeAlta;

	public Usuario(String nombreYApellido, String direccion, String telefono, LocalDate fechaDeAlta) {
		this.setNombreYApellido(nombreYApellido);
		this.setDireccion(direccion);
		this.setTelefono(telefono);
		this.fechaDeAlta = fechaDeAlta;
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
		
}
