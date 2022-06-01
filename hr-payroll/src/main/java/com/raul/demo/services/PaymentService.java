package com.raul.demo.services;

import org.springframework.stereotype.Service;

import com.raul.demo.entities.Payment;

//Este projeto n tem repository, pois não tem BD, apenas regra de negócios
@Service
public class PaymentService {

	public Payment getPayment(long workerId, int days) {
		return new Payment("Bob", 200.0, days);
	}
}