package br.com.ca.wsrobo.util;

import br.com.ca.wsrobo.domain.Localizacao;

public class Interpretador {
	
	public Localizacao transformaComandosEmCoordenadas(String comandos) {
		Localizacao localizacao = new Localizacao();
		try {
			if(!comandos.equals(null) && !comandos.trim().isEmpty()) {
				for (char comando : comandos.toUpperCase().trim().toCharArray()) {
					if(comando=='M'){
						if(localizacao.getNameOrientacao().equals("N")) {
							localizacao.setEixoY(localizacao.getEixoY() + 1);
						} 
						if(localizacao.getNameOrientacao().equals("S")) {
							localizacao.setEixoY(localizacao.getEixoY() - 1);
						}
						if(localizacao.getNameOrientacao().equals("E")) {
							localizacao.setEixoX(localizacao.getEixoX() + 1);
						}
						if(localizacao.getNameOrientacao().equals("W")) {
							localizacao.setEixoX(localizacao.getEixoX() - 1);
						}
					}else if(comando=='L') {
						if(localizacao.getOrientacao() - 1 > 0) {
							localizacao.setOrientacao(localizacao.getOrientacao() - 1);
						}else {
							localizacao.setOrientacao(4);
						}
							
					}else if(comando=='R') {
						
						if(localizacao.getOrientacao() + 1 < 5) {
							localizacao.setOrientacao(localizacao.getOrientacao() + 1);
						}else {
							localizacao.setOrientacao(1);
						}
					}
				}
			}
			
		} catch (Exception e) {
			
		}
		
		
		return localizacao;
	}

}
