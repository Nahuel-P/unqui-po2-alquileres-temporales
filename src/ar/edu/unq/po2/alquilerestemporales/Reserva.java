package ar.edu.unq.po2.alquilerestemporales;

import java.time.Duration;
import java.time.LocalDate;

public class Reserva {
	private LocalDate fechaIngreso;
	private LocalDate fechaSalida;
	private Aceptada estadoDeReserva;
	private Usuario inquilino;
	private Publicacion publicacion;
	private FormaDePago formaDePago;
	private LocalDate fechaRealizacionDeReserva ;
	
	public Reserva(LocalDate fechaRealizacionDeReserva, Usuario inquilino, LocalDate fechaIngreso, LocalDate fechaSalida, Aceptada estadoDeReserva, Publicacion publicacion,FormaDePago formaDePago ) {
		this.fechaRealizacionDeReserva = fechaRealizacionDeReserva;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.estadoDeReserva = estadoDeReserva;
		this.inquilino = inquilino;
		this.publicacion = publicacion;
		this.formaDePago = formaDePago;
	}

	public float costoPorDia() {
		return this.costoTotal()/this.getDiferenciaDeDias();
	}

	public int diasQueFaltan() {
		Long periodo = Duration.between(this.getFechaRealizacionDeReserva().atStartOfDay(), this.getFechaDeIngreso().atStartOfDay()).toDays();
		return periodo.intValue();
	}

	private LocalDate getFechaRealizacionDeReserva() {
		return this.fechaRealizacionDeReserva;
	}

	public float costoTotal() {
		float costoTotal = 0.00f;
		LocalDate dateInicio = this.fechaIngreso;
		LocalDate dateSalida= this.fechaSalida;
		for(LocalDate date = dateInicio; date.isBefore(dateSalida); date = date.plusDays(1)) {
			costoTotal += precioEnElDia(date);
		}		
		return costoTotal;
	}

	public float precioEnElDia(LocalDate dia) {
		float costo = publicacion.getPrecioBase();
		for (PrecioTemporal temporada : this.publicacion.getTemporadasEspeciales()) {
			if(dia.isAfter(temporada.getInicio())
					&& dia.isBefore(temporada.getFinal())) {
				costo = (float) temporada.getPrecio();
			break;
			}
		}
		return costo;
	}


	public Usuario getPropietario() {
		return this.publicacion.getPropietario();
	}

	public void setEstado(Aceptada aceptada) {
		this.estadoDeReserva = aceptada;		
	}

	public Usuario getInquilino() {
		return inquilino;
	}

	public LocalDate getFechaDeIngreso() {
		return this.fechaIngreso;
	}


	public LocalDate getFechaDeSalida() {
		return this.fechaSalida;
	}


	public int getDiferenciaDeDias() {	
		Long periodo = Duration.between(this.getFechaDeIngreso().atStartOfDay(), this.getFechaDeSalida().atStartOfDay()).toDays();
		return Math.abs(periodo.intValue());
	}


	public Aceptada getEstadoDeReserva() {
		return this.estadoDeReserva;
	}
	
	public FormaDePago getFormaDePago(){
		return this.formaDePago;
	}
}
