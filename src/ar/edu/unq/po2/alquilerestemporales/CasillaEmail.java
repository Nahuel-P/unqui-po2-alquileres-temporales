package ar.edu.unq.po2.alquilerestemporales;

import java.util.ArrayList;

public class CasillaEmail {

	String direccion;
	ArrayList<String> inbox;
	
	public CasillaEmail(String direccion) {
		this.direccion = direccion;
		inbox = new ArrayList<String>();
	}
	
}