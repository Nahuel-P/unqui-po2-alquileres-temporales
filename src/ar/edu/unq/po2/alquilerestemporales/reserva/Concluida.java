package ar.edu.unq.po2.alquilerestemporales.reserva;

public class Concluida implements EstadoReserva{

	@Override
	public void aceptar(Reserva reserva) {
		throw new RuntimeException("No se puede aceptar una reserva concluida");		
	}

	@Override
	public void rechazar(Reserva reserva) {
		throw new RuntimeException("No se puede rechazar una reserva concluida");	
	}

	@Override
	public void cancelar(Reserva reserva) {
		throw new RuntimeException("No se puede cancelar una reserva concluida");	
	}
	
	@Override
	public void concluir(Reserva reserva) {
		throw new RuntimeException("No se puede concluir una reserva que fue rechazada");	
	}
}
