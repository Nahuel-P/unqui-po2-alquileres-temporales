package ar.edu.unq.po2.alquilerestemporales;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

public class Reserva {
	private LocalDate fechaIngreso;
	private LocalDate fechaSalida;
	
	public Reserva(LocalDate fechaIngreso, LocalDate fechaSalida ) {
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
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

	//esto retorna el dueño de la publicacion
	public Usuario getPropietario() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setEstado(Aceptada aceptada) {
		// TODO Auto-generated method stub
		
	}

	public Object getInquilino() {
		// TODO Auto-generated method stub
		return null;
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


}
