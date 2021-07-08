package ar.edu.unq.po2.alquilerestemporales.politicasDeCancelacion;

import ar.edu.unq.po2.alquilerestemporales.reserva.Reserva;

public interface IEstadoCancelacionIntermedia {

	void aplicarCosto(Reserva reserva, CancelacionIntermedia cancelacionIntermedia);

}
