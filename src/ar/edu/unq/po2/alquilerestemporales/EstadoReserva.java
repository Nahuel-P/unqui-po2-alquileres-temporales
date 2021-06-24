package ar.edu.unq.po2.alquilerestemporales;

public abstract class EstadoReserva{
	
	public void informarEstadoDeReservaAInquilino(Reserva reserva){
		reserva.getPropietario()
		   .getCasillaEmail()
		   .enviarMail(reserva.getInquilino().getCasillaEmail(), mensaje(reserva));
	}	
	public abstract String mensaje(Reserva reserva);
}
