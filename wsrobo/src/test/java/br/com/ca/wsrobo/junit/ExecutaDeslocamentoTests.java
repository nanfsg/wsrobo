package br.com.ca.wsrobo.junit;

import br.com.ca.wsrobo.controller.RoboController;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import static org.assertj.core.api.Assertions.assertThat;


import java.io.IOException;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ExecutaDeslocamentoTests {
	
	@Test
	public void TesteMovRotacaoDireita() throws IOException {
		assertThat("(2, 0, S)").isEqualTo(new RoboController().executaDeslocamento("MMRMMRMM"));
	}
	
	@Test
	public void TesteMovEsquerda() throws IOException {
		assertThat("(0, 2, W)").isEqualTo(new RoboController().executaDeslocamento("MML"));
	}
	
	@Test
	public void TesteComandoInvalido() throws IOException {
		assertThat("400 Bad Request").isEqualTo(new RoboController().executaDeslocamento("AAA"));
	}
	
	@Test
	public void TestePosicaoInvalida() throws IOException {
		assertThat("400 Bad Request").isEqualTo(new RoboController().executaDeslocamento("MMMMMMMMMMMMMMMMMMMMMMMM"));
	}
	
	
}
