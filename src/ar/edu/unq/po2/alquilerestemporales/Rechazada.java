package ar.edu.unq.po2.alquilerestemporales;

public class Rechazada extends EstadoReserva {
	
	@Override
	public String mensaje(Reserva reserva) {
		return "Su reserva ha sido rechazada ya que no cumple con los requisitos requeridos.";
	}
}
