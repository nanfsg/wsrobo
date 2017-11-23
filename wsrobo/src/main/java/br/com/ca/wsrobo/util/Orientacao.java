package br.com.ca.wsrobo.util;

public enum Orientacao {

	N(1),E(2),S(3),W(4);
	
	private final int direcao;
	
	Orientacao(int valor) {
		direcao = valor;
	}
	
	public int getDirecao() {
		return this.direcao;
	}
	
}
