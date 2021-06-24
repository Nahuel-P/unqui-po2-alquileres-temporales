package ar.edu.unq.po2.alquilerestemporales;

public class Efectivo implements FormaDePago{
		
	String tipo;
	public Efectivo() {
		this.tipo = "Efectivo";
	}

	@Override
	public String getTipo() {
		return this.tipo;
	}

}
