package ar.edu.unq.po2.alquilerestemporales.reserva;

import java.time.LocalDate;

public class Aceptada implements EstadoReserva{

	@Override
	public void aceptar(Reserva reserva) {
		throw new RuntimeException("No se puede aceptar una reserva ya aceptada");		
	}

	@Override
	public void rechazar(Reserva reserva) {
		throw new RuntimeException("La reserva ya ha sido aceptada");	
	}

	@Override
	public void cancelar(Reserva reserva) {
		reserva.setEstado(new Cancelada());
		reserva.informarUsuario("Se ha cancelada una de sus reservas", reserva.getPropietario());
		reserva.notificarCancelada();
		reserva.aplicarPoliticaDeCancelacion();
	}

	@Override
	public void concluir(Reserva reserva) {
		reserva.setEstado(new Concluida());
	}

	@Override
	public boolean estaOcupadaCon(LocalDate fechaIngreso, LocalDate fechaSalida, Reserva reserva) {
		return (fechaIngreso.compareTo(reserva.getFechaDeIngreso())>=0) && (fechaSalida.compareTo(reserva.getFechaDeSalida())<=0);
	}


	
	
}
