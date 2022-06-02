package com.raul.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
//Aplicação para fazer o roteamento de microsserviços
public class HrApiGatewayZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrApiGatewayZuulApplication.class, args);
	}
}
