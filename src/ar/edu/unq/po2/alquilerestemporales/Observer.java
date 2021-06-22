package ar.edu.unq.po2.alquilerestemporales;

import java.util.ArrayList;

public class Observer {
	
	private ArrayList <IPriceObserver> observadores;
	
	public Observer() {
		observadores = new ArrayList<IPriceObserver>();
	}

	public void update(Publicacion publicacion) {
		for(IPriceObserver observador : this.getObservadores()) {
			this.update(publicacion);
		}
		
	}
	
	public void attach(IPriceObserver obs) {
		this.getObservadores().add(obs);
	}
	
	public void detach(IPriceObserver obs) {
		this.getObservadores().remove(obs);
	}

	public void notificar(IPriceObserver obs) {
	
	}
	
	public ArrayList <IPriceObserver> getObservadores() {
		return observadores;
	}
}
