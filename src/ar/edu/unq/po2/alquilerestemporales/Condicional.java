package ar.edu.unq.po2.alquilerestemporales;

public class Condicional {

	public void informarEstadoDeReservaAInquilino(Reserva reserva) {
		reserva.getPropietario().getCasillaEmail().enviarMail(reserva.getInquilino().getCasillaEmail(), "Su reserva ha sido rechazada");
	}
}
