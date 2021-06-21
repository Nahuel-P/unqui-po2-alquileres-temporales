package ar.edu.unq.po2.alquilerestemporales;

import java.util.ArrayList;

public class CasillaEmail {

	String direccion;
	ArrayList<String> inbox;
	
	public CasillaEmail(String direccion) {
		this.direccion = direccion;
		inbox = new ArrayList<String>();
	}

	public String getDireccion() {
		return this.direccion;
	}

	public ArrayList<String> getInbox() {
		return this.inbox;
	}

	public void recibirMail(String nuevoMail) {
		this.inbox.add(nuevoMail);		
	}

	public void enviarMail(CasillaEmail casillaDeMail, String nuevoMail) {
		casillaDeMail.recibirMail(nuevoMail);
	}
	
}