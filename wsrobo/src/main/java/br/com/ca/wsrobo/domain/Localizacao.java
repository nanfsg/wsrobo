package br.com.ca.wsrobo.domain;

import br.com.ca.wsrobo.util.Config;
import br.com.ca.wsrobo.util.Orientacao;

public class Localizacao {
	
	private int eixoX;
	private int eixoY;
	private Orientacao orientacao;
	
	private Config config = new Config();
	
	public Localizacao() {
		this.eixoX = config.getLocalizaInicialX();
		this.eixoY = config.getLocalizaInicialY();
		this.orientacao = config.getOrientacaoInicial();
	}
	
	public int getEixoX() {
		return eixoX;
	}

	public void setEixoX(int eixoX) {
		this.eixoX = eixoX;
	}

	public int getEixoY() {
		return eixoY;
	}

	public void setEixoY(int eixoY) {
		this.eixoY = eixoY;
	}

	public int getOrientacao() {
		return orientacao.getDirecao();
	}

	public void setOrientacao(int orientacao) {
		if(orientacao == 1){
			this.orientacao = Orientacao.N;
		}else if(orientacao == 2){
			this.orientacao = Orientacao.O;
		}else if(orientacao == 3){
			this.orientacao = Orientacao.S;
		}else if(orientacao == 4){
			this.orientacao = Orientacao.W;
		}
		
		
	}
	
	public String getNameOrientacao() {
		return orientacao.name();
	}


	public String retornaLocalizacao() {
		return new String("("+ getEixoX() + ", " + getEixoY() + ", " + getNameOrientacao() + ")");
	}

}
