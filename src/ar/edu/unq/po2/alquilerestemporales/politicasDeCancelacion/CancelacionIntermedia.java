package ar.edu.unq.po2.alquilerestemporales.politicasDeCancelacion;

import ar.edu.unq.po2.alquilerestemporales.reserva.Reserva;

public class CancelacionIntermedia implements PoliticaDeCancelacion{

	private IEstadoCancelacionIntermedia estado;
	float importeAPagar;
	
	public CancelacionIntermedia() {
		estado = new EstadoIntermediaInicial();
		this.setImporteAPagar(0);
	}
	
	public float aplicarCostosDeCancelacion(Reserva reserva) {
			
		this.estado.aplicarCosto(reserva, this);
		
		return this.getImporteAPagar(); 
	}

	public IEstadoCancelacionIntermedia getEstado() {
		return estado;
	}

	public void setEstado(IEstadoCancelacionIntermedia estado) {
		this.estado = estado;
	}

	public float getImporteAPagar() {
		return importeAPagar;
	}

	public void setImporteAPagar(float importeAPagar) {
		this.importeAPagar = importeAPagar;
	}
	
}
