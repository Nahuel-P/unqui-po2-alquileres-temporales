package ar.edu.unq.po2.alquilerestemporales.politicasDeCancelacion;

import ar.edu.unq.po2.alquilerestemporales.reserva.Reserva;

public class EstadoIntermedia100p implements IEstadoCancelacionIntermedia {

	float importeAPagar;
	
	@Override
	public void aplicarCosto(Reserva reserva, CancelacionIntermedia cancelacion) {
		
		cancelacion.setImporteAPagar(reserva.costoTotal()); 
		
	}

}
