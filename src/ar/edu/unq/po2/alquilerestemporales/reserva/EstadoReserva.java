package ar.edu.unq.po2.alquilerestemporales.reserva;

import java.time.LocalDate;

public interface EstadoReserva{
	
	public void aceptar(Reserva reserva);
	public void rechazar(Reserva reserva);
	public void cancelar(Reserva reserva);
	public void concluir(Reserva reserva);
	public boolean estaOcupadaCon(LocalDate fechaIngreso, LocalDate fechaSalida, Reserva reservaNueva);
}
