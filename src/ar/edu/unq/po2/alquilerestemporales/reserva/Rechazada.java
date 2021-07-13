package ar.edu.unq.po2.alquilerestemporales.reserva;

import java.time.LocalDate;

public class Rechazada implements EstadoReserva {

	@Override
	public void aceptar(Reserva reserva) {
		throw new RuntimeException("No se puede aceptar una reserva que ya fue rechazada");		
	}

	@Override
	public void rechazar(Reserva reserva) {
		throw new RuntimeException("La reserva ya fue rechazada");
	}

	@Override
	public void cancelar(Reserva reserva) {
		throw new RuntimeException("No se puede cancelar una reserva que fue rechazada");	
	}

	@Override
	public void concluir(Reserva reserva) {
		throw new RuntimeException("No se puede concluir una reserva que fue rechazada");	
	}

	@Override
	public boolean estaOcupadaCon(LocalDate fechaIngreso, LocalDate fechaSalida, Reserva reserva) {
		return false;
	}
	

}
