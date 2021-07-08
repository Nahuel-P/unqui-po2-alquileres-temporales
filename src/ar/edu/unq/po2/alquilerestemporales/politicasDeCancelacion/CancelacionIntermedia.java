package ar.edu.unq.po2.alquilerestemporales.politicasDeCancelacion;

import ar.edu.unq.po2.alquilerestemporales.reserva.Reserva;

public class CancelacionIntermedia implements PoliticaDeCancelacion{

	public float aplicarCostosDeCancelacion(Reserva reserva) {
		float importeAPagar;
		if(estaEnPlazoDeCancelacionGratuita(reserva)) {
			importeAPagar= 0;
		}
		else if (estaEnPlazoDeCancelacionIntermedia(reserva)){
			importeAPagar= reserva.costoTotal()*(0.5f);
		}
		else {
			importeAPagar= reserva.costoTotal();
		}
		return importeAPagar;
		
	}
	
	private boolean estaEnPlazoDeCancelacionGratuita(Reserva reserva) {
		
		return reserva.diasQueFaltan() >= 20;
	}
	
	private boolean estaEnPlazoDeCancelacionIntermedia(Reserva reserva) {
		
		return reserva.diasQueFaltan()<=19 && reserva.diasQueFaltan()>=10;
	}

}
