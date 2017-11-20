package br.com.ca.wsrobo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import br.com.ca.wsrobo.operation.Deslocamento;
import br.com.ca.wsrobo.validation.Validador;

@RestController
public class RoboController {

	@RequestMapping(
		value="/rest/mars/{comando}", 
		method=RequestMethod.POST
	)
	public String executaDeslocamento(@PathVariable("comando") String comandoDeslocamento) {
		try {
			if(!new Validador().validaComando(comandoDeslocamento)) {
				throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
			}
		} catch (HttpClientErrorException e) {
			return "400 Bad Request";
			//return e.getMessage(); O retorno da mensagem de erro foi tratado para atender aos requisitos elicitados no documento.
		}
		return new Deslocamento().executaDeslocamento(comandoDeslocamento.toUpperCase());
	}
	
}
