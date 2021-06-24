package ar.edu.unq.po2.alquilerestemporales;

import java.time.Duration;
import java.time.LocalDate;

public class Reserva {
	private LocalDate fechaIngreso;
	private LocalDate fechaSalida;
	private Aceptada estadoDeReserva;
	private Usuario inquilino;
	private Publicacion publicacion;
	
	public Reserva(Usuario inquilino, LocalDate fechaIngreso, LocalDate fechaSalida, Aceptada estadoDeReserva, Publicacion publicacion ) {
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.estadoDeReserva = estadoDeReserva;
		this.inquilino = inquilino;
		this.publicacion = publicacion;
	}


	public float costoPorDia() {
		return 0f;
	}

	public int diasQueFaltan() {
		return 0;
	}

	public float costoTotal() {
		return 0f;
	}

	public Usuario getPropietario() {
		return this.publicacion.getPropietario();
	}

	public void setEstado(Aceptada aceptada) {
		this.estadoDeReserva = aceptada;		
	}

	public Object getInquilino() {
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
		return periodo.intValue();
	}


	public Aceptada getEstadoDeReserva() {
		return this.estadoDeReserva;
	}
}
