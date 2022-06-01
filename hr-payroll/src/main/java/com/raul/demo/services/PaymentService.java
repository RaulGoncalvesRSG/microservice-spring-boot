package com.raul.demo.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.raul.demo.entities.Payment;
import com.raul.demo.entities.Worker;

//Este projeto n tem repository, pois não tem BD, apenas regra de negócios
@Service
public class PaymentService {

	@Value("${hr-worker.host}")		//Pega a propriedade criada no application.properties
	private String workerHost;
	
	@Autowired
	private RestTemplate restTemplate;

	public Payment getPayment(long workerId, int days) {
		Map<String, String> uriVariables = new HashMap<>();		//Variáveis da URI
		uriVariables.put("id", ""+workerId);		//ID do trabalhador que passa na requisição
		
		//Faz uma requisião para uma API externa usando RestTemplate
		//O getForObject pega a URL da requisição, o tipo da classe de retorno e as variáveis da URI
		Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables); 
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}