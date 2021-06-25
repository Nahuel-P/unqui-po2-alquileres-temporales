package ar.edu.unq.po2.alquilerestemporales;

import java.time.LocalDate;
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
			System.out.println("La reserva ya existe");
		}
	}

	public void concretarReserva(Usuario usu, Reserva reserva) {
		if(reserva.getPropietario().equals(usu) && existeEnBiblioteca(reserva)) {
			reserva.aceptar();
		}
		else {
			System.out.println("La reserva no puede ser concretada");
		}
	}
	
	public boolean existeEnBiblioteca (Reserva reserva) {
		return this.getTodasReservas().contains(reserva);
	}
	
	public void declinarReserva(Usuario usu, Reserva reserva) {
		if(reserva.getInquilino().equals(usu) && existeEnBiblioteca(reserva)) {
			reserva.cancelar();
		}else {
			System.out.println("La reserva no puede ser cancelada");
		}
	}
	
	public void concluirReservas() {
		LocalDate fecHoy = LocalDate.now();
		for(Reserva reserva : this.getTodasReservas()) {
			if(fecHoy.compareTo(reserva.getFechaDeSalida())>=0) {
				reserva.concluir();
			}
		}
	}

	public void rechazarReserva(Usuario usu, Reserva reserva) {
		if(reserva.getPropietario().equals(usu) && existeEnBiblioteca(reserva)) {
			reserva.rechazar();
		}
		else {
			System.out.println("La reserva no puede ser concretada");
		}
		
	}

	public ArrayList<Reserva> reservasPosteriores(Usuario usu, LocalDate hoy) {
		ArrayList<Reserva> reservas = new ArrayList<Reserva>();
		for(Reserva reserva : this.getTodasReservas()) {
			if(reserva.getInquilino().equals(usu) && hoy.compareTo(reserva.getFechaDeIngreso())<0) {
				reservas.add(reserva);
			}
		}
		return reservas;
	}

	public ArrayList<Reserva> reservasDelUsuario(Usuario usu) {
		ArrayList<Reserva> reservas = new ArrayList<Reserva>();
		for(Reserva reserva : this.getTodasReservas()) {
			if(reserva.getInquilino().equals(usu)){
				reservas.add(reserva);
			}
		}
		return reservas;
	}
}
