package ar.edu.unq.po2.alquilerestemporales;

public class Pendiente extends EstadoReserva{
	
	@Override
	public String mensaje(Reserva reserva) {
		return "Su reserva se encuentra en revisi�n. En cuanto se evalue recibir� un email";
	}
}
