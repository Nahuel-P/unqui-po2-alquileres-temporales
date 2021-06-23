package ar.edu.unq.po2.alquilerestemporales;

import java.util.ArrayList;

public class Inmueble implements ICalificable{
	
	private double superficie;
	private String pais;
	private String ciudad;
	private String direccion;
	private int capacidad;
	private String tipoDeInmueble;
	private ArrayList <String>servicios;
	private BibliotecaDeCalificaciones bibliotecaDeCalificaciones;

	public Inmueble(double superficie, String pais, String ciudad, String direccion, int capacidad,
			String tipoDeInmueble, ArrayList<String> servicios) {
		this.setSuperficie(superficie);
		this.setPais(pais);
		this.setCiudad(ciudad);
		this.setDireccion(direccion);
		this.setCapacidad(capacidad);
		this.setTipoDeInmueble(tipoDeInmueble);
		this.setServicios(servicios);
		this.bibliotecaDeCalificaciones = new BibliotecaDeCalificaciones();
	}
		
	@Override
	public float getPromedioCalificacion() {
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
	
	public ArrayList<Calificacion> getCalificaciones(){
		return this.bibliotecaDeCalificaciones.getCalificaciones();
	}

	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public String getTipoDeInmueble() {
		return tipoDeInmueble;
	}

	public void setTipoDeInmueble(String tipoDeInmueble) {
		this.tipoDeInmueble = tipoDeInmueble;
	}

	public void setServicios(ArrayList<String> servicios) {
		this.servicios = servicios;
	}
	
	public ArrayList<String> getServicios() {
		return servicios;
	}
	
	public void agregarServicio(String servicio) {
		this.getServicios().add(servicio);
	}
	
}
