package com.raul.demo.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.raul.demo.entities.User;

@Component		
//Interface para fazer requisição. Nome do microsserviço q irá se comunicar: hr-user
@FeignClient(name = "hr-user", path = "/users")
public interface UserFeignClient {

	//Mesma assinatura de método do resource da API externa
	@GetMapping(value = "/search")	//Parâmetro opcional
	ResponseEntity<User> findByEmail(@RequestParam String email);	
}