package ar.edu.unq.po2.alquilerestemporales.reserva;

import java.time.LocalDate;

public class Cancelada implements EstadoReserva{

	@Override
	public void aceptar(Reserva reserva) {
		throw new RuntimeException("No se puede aceptar una reserva cancelada");		
	}

	@Override
	public void rechazar(Reserva reserva) {
		throw new RuntimeException("No se puede rechazar una reserva que fue cancelada");		
	}

	@Override
	public void cancelar(Reserva reserva) {
		throw new RuntimeException("La reserva ya ha sido cancelada");	
	}

	@Override
	public void concluir(Reserva reserva) {
		throw new RuntimeException("No se puede concluir una reserva que fue cancelada");	
	}

	@Override
	public boolean estaOcupadaCon(LocalDate fechaIngreso, LocalDate fechaSalida, Reserva reserva) {
		return false;
	}
}