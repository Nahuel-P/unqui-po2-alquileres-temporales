package ar.edu.unq.po2.alquilerestemporales.politicasDeCancelacion;

import ar.edu.unq.po2.alquilerestemporales.reserva.Reserva;

public class EstadoIntermediaInicial implements IEstadoCancelacionIntermedia {

	//float importeAPagar;
	
	@Override
	public void aplicarCosto(Reserva reserva, CancelacionIntermedia cancelacion) {
		
		if(estaEnPlazoDeCancelacionGratuita(reserva)) {
			cancelacion.setImporteAPagar(0);
			
		} else {
			cancelacion.setEstado(new EstadoIntermedia50p());
			cancelacion.aplicarCostosDeCancelacion(reserva);
		}
					
	}
	
	private boolean estaEnPlazoDeCancelacionGratuita(Reserva reserva) {
		
		return reserva.diasQueFaltan() >= 20;
	}
	
}
