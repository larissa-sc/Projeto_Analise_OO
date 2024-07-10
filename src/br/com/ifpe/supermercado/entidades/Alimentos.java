package br.com.ifpe.supermercado.entidades;

public class Alimentos extends Produto{

// booleano para ser usado a identificação de alimento perecível ou não
	private boolean perecivel;
	
	public Alimentos() {
		// TODO Auto-generated constructor stub
	}

	public boolean isPerecivel() {
		return perecivel;
	}

	public void setPerecivel(boolean perecivel) {
		this.perecivel = perecivel;
	}
	
}
