package ar.edu.unq.po2.alquilerestemporales;

public class Condicional extends EstadoReserva{

	@Override
	public String mensaje(Reserva reserva) {
		return String.format("Su reserva ya se encuentra ocupada por otro usuario en las fechas %s y %s . En caso que el usuario la cancele, usted podrá disfrutar de la propiedad. En este caso, se lo informaremos por mail.", reserva.getFechaDeIngreso(), reserva.getFechaDeSalida());
	}
}
