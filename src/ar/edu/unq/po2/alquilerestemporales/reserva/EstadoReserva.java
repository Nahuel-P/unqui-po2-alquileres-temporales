package ar.edu.unq.po2.alquilerestemporales.reserva;

public interface EstadoReserva{
	
	public void aceptar(Reserva reserva);
	public void rechazar(Reserva reserva);
	public void cancelar(Reserva reserva);
	public void concluir(Reserva reserva);
}
