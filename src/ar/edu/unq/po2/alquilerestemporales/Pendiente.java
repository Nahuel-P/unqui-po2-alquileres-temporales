package ar.edu.unq.po2.alquilerestemporales;

public class Pendiente extends EstadoReserva{
	
	@Override
	public String mensaje(Reserva reserva) {
		return "Su reserva se encuentra en revisión. En cuanto se evalue recibirá un email";
	}
}
