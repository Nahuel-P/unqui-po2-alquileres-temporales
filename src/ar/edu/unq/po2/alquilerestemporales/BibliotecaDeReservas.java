package ar.edu.unq.po2.alquilerestemporales;

import java.util.ArrayList;

public class BibliotecaDeReservas {

	private ArrayList<Reserva> reservas;

	public BibliotecaDeReservas() {
		this.reservas = new ArrayList<Reserva>();
	}

	public ArrayList<Reserva> getTodasReservas() {
		return this.reservas;
	}
	
	public void crearReserva(Usuario usu, Reserva reserva) {
		if(!this.getTodasReservas().contains(reserva)) {
			this.reservas.add(reserva);
		}else {
			System.out.print("La reserva ya existe");
		}
		
	}

	public void concretarReserva(Usuario usu, Reserva reserva) {
		if(reserva.getPropietario().equals(usu)) {
			reserva.setEstado(new Aceptada());
		}
	}

	public void cancelar(Usuario usu, Reserva reserva) {
		if(reserva.getInquilino().equals(usu)) {
			reserva.setEstado(new Cancelada());
		}
	}
	
	public void declinarReserva(Usuario usu, Reserva reserva) {
		if(reserva.getPropietario().equals(usu)) {
			reserva.setEstado(new Rechazada());
		}
	}
}
