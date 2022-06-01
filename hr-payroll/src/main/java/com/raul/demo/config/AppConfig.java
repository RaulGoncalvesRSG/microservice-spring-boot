package com.raul.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

	/*Padrão de projeto singleton. Método para registrar uma instância única do RestTemplate. 
	 * Essa instância única fica disponível para injetar em outros componentes*/
	@Bean		
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}