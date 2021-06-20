package ar.edu.unq.po2.alquilerestemporales;

import java.time.LocalTime;
import java.util.ArrayList;

public class Publicacion {
	
	private LocalTime checkIn;
	private LocalTime checkOut;
	private double precioBase;
	private Inmueble inmueble;
	private ArrayList <Foto> fotos;
	private Usuario usuario;
	private ArrayList <FormaDePago> formasDePago;
	
	
	public Publicacion(Inmueble inmueble, Usuario usuario, double precioBase, LocalTime checkIn, LocalTime checkOut, 
			ArrayList<Foto> fotos, ArrayList <FormaDePago> formasDePago) {
		
		this.setInmueble(inmueble);
		this.usuario = usuario;
		this.setCheckIn(checkIn);
		this.setCheckOut(checkOut);
		this.setPrecioBase(precioBase);
		this.setFormasDePago(formasDePago);
		this.setFotos(fotos);
	}
	
	

	public ArrayList<String> mostrarDatos() {
		return null;
		
	}
	
	public void bajarDePrecio() {
		
	}
	
	public void notificar() {
		
	}
	
	public void agregarUnaFoto(Foto foto) {
		this.getFotos().add(foto);
	}

	
	public void setFormasDePago(ArrayList<FormaDePago> formDePago) {
		// TODO Auto-generated method stub
		this.formasDePago = formDePago;
	}
	
	public void setFotos(ArrayList<Foto> fotos2) {
		// TODO Auto-generated method stub
		this.fotos = fotos2;
	}

	public void setInmueble(Inmueble inm) {
		// TODO Auto-generated method stub
		this.inmueble = inm;
	}

	public LocalTime getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(LocalTime checkIn) {
		this.checkIn = checkIn;
	}

	public LocalTime getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(LocalTime checkOut) {
		this.checkOut = checkOut;
	}

	public double getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}
	
	private ArrayList<Foto> getFotos() {
		// TODO Auto-generated method stub
		return fotos;
	}



	public Object getInmueble() {
		// TODO Auto-generated method stub
		return null;
	}



	public Object getPropietario() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
