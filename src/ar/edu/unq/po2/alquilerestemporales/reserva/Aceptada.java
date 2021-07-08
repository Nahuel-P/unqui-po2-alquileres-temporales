package ar.edu.unq.po2.alquilerestemporales.reserva;

public class Aceptada extends EstadoReserva{
	
	@Override
	public String mensaje(Reserva reserva) {
		return String.format("Su reserva ha sido aceptada. Lo esperamos el día %s",reserva.getFechaDeIngreso());
	}
}
