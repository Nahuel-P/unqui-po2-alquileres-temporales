package ar.edu.unq.po2.alquilerestemporales;

public class CancelacionGratuita {

	public double aplicarCostosDeCancelacion(Reserva reserva) {
		
		if(reserva.enPlazoDeCancelacion()) {
			System.out.println("No hay penalidad");
			return 0;
		}
		else {
			System.out.println("Hay penalidad");
			return reserva.costoDeCancelacion();
		}
		
		
	}
	
}
