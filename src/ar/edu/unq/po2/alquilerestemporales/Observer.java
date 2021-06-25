package ar.edu.unq.po2.alquilerestemporales;

import java.util.ArrayList;

public class Observer {
	
	private ArrayList <IPriceObserver> observadores;
	
	public Observer() {
		observadores = new ArrayList<IPriceObserver>();
	}

	public void notificar(Publicacion publicacion) {
		for(IPriceObserver observador : this.getObservadores()) {
			observador.update(publicacion);
		}
	}
	
	public void attach(IPriceObserver obs) {
		this.getObservadores().add(obs);
	}
	
	public void detach(IPriceObserver obs) {
		this.getObservadores().remove(obs);
	}

	public ArrayList <IPriceObserver> getObservadores() {
		return observadores;
	}
	
}
