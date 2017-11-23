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
	public void TesteLimiteDeslocamentoMaximoParaN() throws IOException {
		assertThat("(0, 5, N)").isEqualTo(new RoboController().executaDeslocamento("MMMMM"));
	}
	
	
	@Test
	public void TesteEstouroLimiteDeslocamentoMaximoParaN() throws IOException {
		assertThat("400 Bad Request").isEqualTo(new RoboController().executaDeslocamento("MMMMMM"));
	}
	
	//==========================================================
	
	@Test
	public void TesteLimiteDeslocamentoMaximoParaS() throws IOException {
		assertThat("(0, 0, S)").isEqualTo(new RoboController().executaDeslocamento("RR"));
		assertThat("(0, 0, S)").isEqualTo(new RoboController().executaDeslocamento("LL"));
	}
	
	
	@Test
	public void TesteEstouroLimiteDeslocamentoMaximoParaS() throws IOException {
		assertThat("400 Bad Request").isEqualTo(new RoboController().executaDeslocamento("RRM"));
		assertThat("400 Bad Request").isEqualTo(new RoboController().executaDeslocamento("LLM"));
	}
	
	//==========================================================
	
	@Test
	public void TesteLimiteDeslocamentoMaximoParaW() throws IOException {
		assertThat("(5, 0, E)").isEqualTo(new RoboController().executaDeslocamento("RMMMMM"));
		assertThat("(5, 0, E)").isEqualTo(new RoboController().executaDeslocamento("LLLMMMMM"));
	}
	
	
	@Test
	public void TesteEstouroLimiteDeslocamentoMaximoParaW() throws IOException {
		assertThat("400 Bad Request").isEqualTo(new RoboController().executaDeslocamento("RMMMMMM"));
		assertThat("400 Bad Request").isEqualTo(new RoboController().executaDeslocamento("LLLMMMMMM"));
	}
	
	//==========================================================
	
	@Test
	public void TesteLimiteDeslocamentoMaximoParaO() throws IOException {
		assertThat("(0, 0, W)").isEqualTo(new RoboController().executaDeslocamento("L"));
		assertThat("(0, 0, W)").isEqualTo(new RoboController().executaDeslocamento("RRR"));
	}
	
	
	@Test
	public void TesteEstouroLimiteDeslocamentoMaximoParaO() throws IOException {
		assertThat("400 Bad Request").isEqualTo(new RoboController().executaDeslocamento("LM"));
		assertThat("400 Bad Request").isEqualTo(new RoboController().executaDeslocamento("RRRM"));
	}
}
