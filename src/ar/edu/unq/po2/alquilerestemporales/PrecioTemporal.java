package ar.edu.unq.po2.alquilerestemporales;

import java.time.LocalDate;


public class PrecioTemporal {
	
	private double precioEspecial;
	private LocalDate desde;
	private LocalDate hasta;

	public PrecioTemporal(double precioEsp, LocalDate dsd, LocalDate hst) {
		
		this.precioEspecial = precioEsp;
		this.desde = dsd;
		this.hasta = hst;
		
	}

	public LocalDate getInicio() {
		
		return desde;
	}

	public LocalDate getFinal() {
		
		return hasta;
	}

	public double getPrecio() {
		
		return precioEspecial;
	}

}
