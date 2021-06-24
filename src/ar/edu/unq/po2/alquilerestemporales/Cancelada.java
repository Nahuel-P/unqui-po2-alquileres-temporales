package ar.edu.unq.po2.alquilerestemporales;

public class Cancelada {
	public void informarEstadoDeReservaAInquilino(Reserva reserva) {
		reserva.getPropietario().getCasillaEmail().enviarMail(reserva.getInquilino().getCasillaEmail(), "Su reserva ha sido cancelada");
	}
}
