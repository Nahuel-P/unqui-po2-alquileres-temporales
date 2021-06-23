package ar.edu.unq.po2.alquilerestemporales;

import java.util.ArrayList;

public class BibliotecaDeReservas {

	private ArrayList<Reserva> reservas;

	
	
	public BibliotecaDeReservas() {
		this.reservas = new ArrayList<Reserva>();
	}

	public void crearReserva(Usuario usu, Reserva reserva) {
		this.reservas.add(reserva);
		
	}

	public ArrayList<Reserva> getTodasReservas() {
		return this.reservas;
	}

	public void concretarReserva(Usuario usu, Reserva reserva) {
		if(reserva.getPropietario().equals(usu)) {
			reserva.setEstado(new Aceptada());
		}
		
	}

	public void declinarReserva(Usuario usu, Reserva reserva) {
		if(reserva.getPropietario().equals(usu)) {
			reserva.setEstado(new Rechazada());
		}
		
	}

	public void cancelar(Usuario usu, Reserva reserva) {
		if(reserva.getInquilino().equals(usu)) {
			reserva.setEstado(new Cancelada());
		}
		
	}


}
