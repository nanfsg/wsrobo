package br.com.ca.wsrobo.validation;

import br.com.ca.wsrobo.domain.Localizacao;
import br.com.ca.wsrobo.util.Config;

public class Validador {
	
	private Config config = new Config();
	
	public boolean validaComando(String comando) {
		
		for (char valorComando : comando.toCharArray()) {
			if(valorComando != 'L' && valorComando != 'R' && valorComando != 'M') {
				return false;
			}
		}
		return true;
	}

	public boolean validaPosicao(Localizacao posicao) {
		
		if(posicao.getEixoX()>config.getTamanhoMaximoX() || posicao.getEixoX()<config.getTamanhoMinimoX() || 
				posicao.getEixoY()>config.getTamanhoMaximoY() || posicao.getEixoY()<config.getTamanhoMinimoY()) {
			return false;
		}
		return true;
	}
	
}
