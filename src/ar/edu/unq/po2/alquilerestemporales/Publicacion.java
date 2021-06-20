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

		//no se verifica si ya hay un inmueble elegido, porque se asume que el usuario puede
		//cambiar y pisar el inmueble elegido anteriormente
		
		this.inmueble = inm;
	}

	public LocalTime getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(LocalTime chIn) {
		
			this.checkIn = chIn;
	}

	public LocalTime getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(LocalTime chOut) {
		
		if(chOut.isBefore(checkIn)) {
			this.checkOut = chOut;
		} else {
			System.out.println("El horario de check-out, debe ser menor al horario de check-in");
		}
		
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



	public Inmueble getInmueble() {
		// TODO Auto-generated method stub
		return inmueble;
	}



	public Object getPropietario() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
