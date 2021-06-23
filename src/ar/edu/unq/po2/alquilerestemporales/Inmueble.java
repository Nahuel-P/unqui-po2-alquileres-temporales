package ar.edu.unq.po2.alquilerestemporales;

import java.util.ArrayList;

public class Inmueble {
	
	private double superficie;
	private String pais;
	private String ciudad;
	private String direccion;
	private int capacidad;
	private String tipoDeInmueble;
	private ArrayList <String>servicios;

	public Inmueble(double superficie, String pais, String ciudad, String direccion, int capacidad,
			String tipoDeInmueble, ArrayList<String> servicios) {
		this.superficie = superficie;
		this.pais = pais;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.capacidad = capacidad;
		this.tipoDeInmueble = tipoDeInmueble;
		this.servicios = servicios;
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
