package ar.edu.unq.po2.alquilerestemporales;

public class CancelacionRestringida implements PoliticaDeCancelacion{

	public float aplicarCostosDeCancelacion(Reserva reserva) {

		float costo = reserva.costoTotal();
		return costo;
		
	}
}
