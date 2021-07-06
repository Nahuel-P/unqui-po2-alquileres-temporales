package ar.edu.unq.po2.alquilerestemporales;

import java.time.LocalDate;
import java.util.ArrayList;

public class FiltroBasico extends Filtro {
	
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private String ciudad;
	
	public FiltroBasico(LocalDate fecIni, LocalDate fecFin, String ciudad){
		this.fechaInicio = fecIni;
		this.fechaFin = fecFin;
		this.ciudad = ciudad;
	}
	
	public boolean cumpleCriterios(Publicacion publicacion) {
		return (publicacion.getCiudad() == this.ciudad) && estaEnFecha(publicacion);
	}
	
	private boolean estaEnFecha(Publicacion publicacion) {
		LocalDate fecIniPubli = publicacion.getFechaInicio();
		LocalDate fecFinPubli = publicacion.getFechaFin();
		return (fecIniPubli.compareTo(fechaInicio)>=0) && (fecFinPubli.compareTo(fechaFin)<=0);
	}	
}
