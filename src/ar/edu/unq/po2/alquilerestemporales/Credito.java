package ar.edu.unq.po2.alquilerestemporales;

public class Credito implements FormaDePago {
	
	String tipo;
	public Credito() {
		this.tipo = "Credito";
	}

	@Override
	public String getTipo() {
		return this.tipo;
	}

}
