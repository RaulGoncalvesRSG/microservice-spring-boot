package com.raul.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raul.demo.entities.Payment;
import com.raul.demo.entities.Worker;
import com.raul.demo.feignclients.WorkerFeignClient;

//Este projeto n tem repository, pois não tem BD, apenas regra de negócios
@Service
public class PaymentService {
	
	@Autowired
	private WorkerFeignClient workerFeignClient;

	public Payment getPayment(long workerId, int days) {
		Worker worker = workerFeignClient.findById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}