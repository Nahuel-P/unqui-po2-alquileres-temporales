package ar.edu.unq.po2.alquilerestemporales.politicasDeCancelacion;

import ar.edu.unq.po2.alquilerestemporales.reserva.Reserva;

public class EstadoIntermedia50p implements IEstadoCancelacionIntermedia {

	//float importeAPagar;
	
	@Override
	public void aplicarCosto(Reserva reserva, CancelacionIntermedia cancelacion) {
		
		if (estaEnPlazoDeCancelacionIntermedia(reserva)){
			cancelacion.setImporteAPagar(reserva.costoTotal()*(0.5f));
		} else {
			cancelacion.setEstado(new EstadoIntermedia100p());
			cancelacion.aplicarCostosDeCancelacion(reserva);
		}
		
	}
		
	private boolean estaEnPlazoDeCancelacionIntermedia(Reserva reserva) {
		
		return reserva.diasQueFaltan()<=19 && reserva.diasQueFaltan()>=10;
	}

}
