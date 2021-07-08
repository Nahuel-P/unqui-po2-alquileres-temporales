package ar.edu.unq.po2.alquilerestemporales.publicacion;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import ar.edu.unq.po2.alquilerestemporales.politicasDeCancelacion.PoliticaDeCancelacion;
import ar.edu.unq.po2.alquilerestemporales.publicacion.calificable.Inmueble;
import ar.edu.unq.po2.alquilerestemporales.publicacion.calificable.Usuario;
import ar.edu.unq.po2.alquilerestemporales.publicacion.formasDePago.FormaDePago;

public class Publicacion {
	
	private LocalTime checkIn;
	private LocalTime checkOut;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private double precioBase;
	private Inmueble inmueble;
	private ArrayList <Foto> fotos;
	private Usuario usuario;
	private ArrayList <FormaDePago> formasDePago;
	private ArrayList <PrecioTemporal> temporadasEspeciales;
	private Observer observador;
	private PoliticaDeCancelacion politicaCancelacion;
	
	public Publicacion(Inmueble inmueble, Usuario usuario, double precioBase, LocalTime checkIn, 
			LocalTime checkOut, ArrayList<Foto> fotos, ArrayList <FormaDePago> formasDePago,
			LocalDate fecIni, LocalDate fecFin, PoliticaDeCancelacion politCancelacion) {
		
		this.setInmueble(inmueble);
		this.usuario = usuario;
		this.setCheckIn(checkIn);
		this.setCheckOut(checkOut);
		this.fechaInicio=fecIni;
		this.fechaFin=fecFin;
		this.setPrecioBase(precioBase);
		this.setFormasDePago(formasDePago);
		this.setFotos(fotos);
		this.temporadasEspeciales = new ArrayList<PrecioTemporal>();
		this.observador = new Observer();
		this.politicaCancelacion = politCancelacion;
	}
		
	public void establecerPrecioTemporal(PrecioTemporal precioTemporal) {
		this.getTemporadasEspeciales().add(precioTemporal);
	}
	
	public void verificadorDePrecio() {
		
		for (PrecioTemporal temporada : this.getTemporadasEspeciales()) {
			if(LocalDate.now().isAfter(temporada.getInicio())
					&& LocalDate.now().isBefore(temporada.getFinal())) {
				this.setPrecioBase(temporada.getPrecio());
			}
		}
	}
		
	public void agregarUnaFoto(Foto foto) {
		
		if((!this.getFotos().contains(foto)) &&
				(!espacioParaFotosLleno())) {
			this.getFotos().add(foto);
		} else {
			System.out.println("No es posible subir esta foto");
		}
	}

	private boolean espacioParaFotosLleno() {
		return this.getFotos().size() >= 5;
	}
	
	public void mostrarDatos() {
		System.out.println("La publicacion seleccionada tiene un precio de: $"+ this.getPrecioBase() + 
				". El inmueble cuenta con "+ this.getInmueble().getServicios() + ". Tiene como horario de"
						+ "checkIn las "+ this.getCheckIn()+ " hs, y como checkOut las "+this.getCheckOut());
		if (!this.getTemporadasEspeciales().isEmpty()) {
			System.out.println("Actualmente cuenta con "+ this.getTemporadasEspeciales().size()+ " temporadas"
					+ " con precio especial.");			
		}
	}
	
	public void bajarDePrecio(double nuevoPrecio) {
		if (nuevoPrecio < this.getPrecioBase()) { //Cumple extrictamente la funcion de bajar, caso contrario 
			this.setPrecioBase(nuevoPrecio);      //se deberia utilizar otro metodo.
			this.notificar();	
		} else {
			System.out.println("El precio colocado es mayor al existente");
		}
	}
	
	public void notificar() {
		this.observador.notificar(this);		
	}

	public void setFormasDePago(ArrayList<FormaDePago> formDePago) {
		this.formasDePago = formDePago;
	}
	
	public void setFotos(ArrayList<Foto> fotos2) {
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
	
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	
	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setCheckOut(LocalTime chOut) {
		
		if(chOut.isBefore(checkIn)) {
			this.checkOut = chOut;
		} else {
			System.out.println("El horario de check-out, debe ser menor al horario de check-in");
		}
	}

	public float getPrecioBase() {
		return (float) precioBase;
	}

	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}
	
	public ArrayList<Foto> getFotos() {
		return fotos;
	}

	public Inmueble getInmueble() {
		return inmueble;
	}

	public Usuario getPropietario() {
		return usuario;
	}

	public ArrayList<FormaDePago> getFormasDePago() {
		
		return formasDePago;
	}
	
	public ArrayList<PrecioTemporal> getTemporadasEspeciales() {
		return temporadasEspeciales;
	}

	public void setObervador(Observer observador){
		this.observador = observador;
	}

	public Observer getObservador() {
		return observador;
	}

	public String getCiudad() {
		
		return this.inmueble.getCiudad();
	}

	public int getCantHabitantes() {
		
		return this.inmueble.getCapacidad();
	}
	
	public PoliticaDeCancelacion getPoliticaDeCancelacion() {
		return politicaCancelacion;
	}

}
