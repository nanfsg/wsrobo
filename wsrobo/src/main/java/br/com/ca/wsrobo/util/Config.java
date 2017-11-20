package br.com.ca.wsrobo.util;

import java.io.IOException;
import java.util.Properties;

public class Config {
	
	private int tamanhoMaximoX;
    private int tamanhoMaximoY;
    private int tamanhoMinimoX;
    private int tamanhoMinimoY;
    private int localizaInicialX;
    private int localizaInicialY;
    private Orientacao orientacaoInicial;

    public Config() {
    		Properties properties = new Properties();
        try {
            properties.load(Config.class.getResourceAsStream("/config.properties"));
            tamanhoMaximoX = Integer.valueOf(properties.getProperty("terreno.tamanhoMaximoX"));
            tamanhoMaximoY = Integer.valueOf(properties.getProperty("terreno.tamanhoMaximoY"));
            tamanhoMinimoX = Integer.valueOf(properties.getProperty("terreno.tamanhoMinimoX"));
            tamanhoMinimoY = Integer.valueOf(properties.getProperty("terreno.tamanhoMinimoX"));
            localizaInicialX = Integer.valueOf(properties.getProperty("terreno.localizaInicialX"));
            localizaInicialY = Integer.valueOf(properties.getProperty("terreno.localizaInicialY"));
            orientacaoInicial = Orientacao.valueOf(properties.getProperty("terreno.orientacaoInicial"));
        } catch (IOException e) {
	            e.printStackTrace();
    		}
        
    }

	public int getTamanhoMaximoX() {
		return tamanhoMaximoX;
	}

	public int getTamanhoMaximoY() {
		return tamanhoMaximoY;
	}

	public int getTamanhoMinimoX() {
		return tamanhoMinimoX;
	}

	public int getTamanhoMinimoY() {
		return tamanhoMinimoY;
	}

	public int getLocalizaInicialX() {
		return localizaInicialX;
	}

	public int getLocalizaInicialY() {
		return localizaInicialY;
	}

	public Orientacao getOrientacaoInicial() {
		return orientacaoInicial;
	}
}



