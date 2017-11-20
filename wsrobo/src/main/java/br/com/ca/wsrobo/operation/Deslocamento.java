package br.com.ca.wsrobo.operation;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import br.com.ca.wsrobo.domain.Localizacao;
import br.com.ca.wsrobo.util.Interpretador;
import br.com.ca.wsrobo.validation.Validador;

public class Deslocamento {
	
	public String executaDeslocamento(String comando) {
		//Comandos que executam o deslocamento do robo ...
		Localizacao coordenadasDoDeslocamento = new Interpretador().transformaComandosEmCoordenadas(comando);
		try {
			if(!new Validador().validaPosicao(coordenadasDoDeslocamento)) {
				throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
			}
		} catch (HttpClientErrorException e) {
			return "400 Bad Request";
			//return e.getMessage(); O retorno da mensagem de erro foi tratado para atender aos requisitos elicitados no documento.
		}
		return  coordenadasDoDeslocamento.retornaLocalizacao();
	}
}
