package ar.edu.unq.po2.alquilerestemporales;

public class CancelacionGratuita implements PoliticaDeCancelacion {

	public float aplicarCostosDeCancelacion(Reserva reserva) {
		float importeAPagar = 0;
		if(!estaEnPlazoDeCancelacionGratuita(reserva)) {
			importeAPagar = reserva.costoPorDia() * 2;
			System.out.println("PENALIDAD DE : "+importeAPagar);
		}
		else {
			System.out.println("NO PENALIZABLE");
		}
		return importeAPagar;
		
	}
	
	private boolean estaEnPlazoDeCancelacionGratuita(Reserva reserva) {
		
		return reserva.diasQueFaltan() >= 10;
	}
}
