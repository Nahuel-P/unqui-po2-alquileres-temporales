package ar.edu.unq.po2.alquilerestemporales;

public class Concluida extends EstadoReserva{
	
	@Override
	public String mensaje(Reserva reserva) {
		return "Su reserva ha finalizado. Gracias por utilizar webReservas :)";
	}
}
