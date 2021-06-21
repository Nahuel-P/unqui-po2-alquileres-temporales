package ar.edu.unq.po2.alquilerestemporales;

public class CancelacionGratuita {

	public float aplicarCostosDeCancelacion(Reserva reserva) {
		float importeAPagar = 0;
		if(!reserva.enPlazoDeCancelacion()) {
			System.out.println("En PLAZO : "+reserva.enPlazoDeCancelacion());
			importeAPagar = reserva.costoPorDia() * 2;
			System.out.println("PENALIDAD DE : "+importeAPagar);
		}
		else {
			System.out.println("En PLAZO : "+reserva.enPlazoDeCancelacion());
			System.out.println("NO PENALIZABLE");
		}
		return importeAPagar;
		
	}
	
}
