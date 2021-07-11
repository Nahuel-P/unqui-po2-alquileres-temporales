package ar.edu.unq.po2.alquilerestemporales.webReservas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unq.po2.alquilerestemporales.publicacion.calificable.Usuario;
import ar.edu.unq.po2.alquilerestemporales.reserva.Reserva;

public class BibliotecaDeReservas {

	private List<Reserva> reservas;

	public BibliotecaDeReservas() {
		this.reservas = new ArrayList<Reserva>();
	}

	public List<Reserva> getTodasLasReservas() {
		return this.reservas;
	}
	
	public List<Reserva> getReservasDeUsuario(Usuario usuario){
        return this.getTodasLasReservas().stream()
        			.filter(reserva-> reserva.esReservaDeUsuario(usuario))
        			.collect(Collectors.toCollection(ArrayList::new));
    }

    public List<Reserva> getReservasFuturas(Usuario usuario){
        return this.getReservasDeUsuario(usuario).stream()
        			.filter(reserva-> reserva.esFutura())
        			.collect(Collectors.toCollection(ArrayList::new));
    }

    public List<String> getCiudadesReservadas(Usuario usuario){
        List<String> ciudades = new ArrayList<String>();
        for(Reserva reserva : this.getReservasDeUsuario(usuario)) {
        	ciudades.add(reserva.getCiudad());
        }
        return ciudades;
    }

    public List<Reserva> getReservasEnCiudadDelUsuario(Usuario usuario, String ciudad){
    	return this.getReservasDeUsuario(usuario).stream()
    			.filter(reserva-> reserva.esEnCiudad(ciudad))
    			.collect(Collectors.toCollection(ArrayList::new));
    }

    public void crearReserva(Reserva reserva){
        this.reservas.add(reserva);
    }
    
    public void concretarReserva(Reserva reserva){
        //Primero busco, encuentro, acepto
        reserva.aceptar();
    }

    public void rechazarReserva(Reserva reserva){
         //Primero busco, encuentro, rechazo
        reserva.rechazar();
    }

    public void declinarReserva(Reserva reserva){
         //Primero busco, encuentro, declino
        reserva.cancelar();
    }

    public void concluirReservas(){
		for(Reserva reserva : this.getTodasLasReservas()) {
			if(LocalDate.now().compareTo(reserva.getFechaDeSalida())>=0) {
				reserva.concluir();
			}
		}
    }

}
