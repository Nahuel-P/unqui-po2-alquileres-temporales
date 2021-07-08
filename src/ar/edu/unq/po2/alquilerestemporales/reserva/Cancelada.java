package ar.edu.unq.po2.alquilerestemporales.reserva;

public class Cancelada extends EstadoReserva{

	@Override
	public String mensaje(Reserva reserva) {
		return String.format("Su reserva ha sido cancelada. El monto total de %s será reintegrado en su cuenta en las proximas 24/48 horas habiles", reserva.costoTotal());
	}
}
