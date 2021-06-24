package ar.edu.unq.po2.alquilerestemporales;

public class Debito implements FormaDePago{

	String tipo;
	public Debito() {
		this.tipo = "Debito";
	}

	@Override
	public String getTipo() {
		return this.tipo;
	}

}
