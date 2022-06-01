package com.raul.demo.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.raul.demo.entities.Worker;

@Component	
/*@FeignClient recebe o nome do projeto (spring.application.name). A interface do FeignClient é para
fazer requisições de APIs externas*/
@FeignClient(name = "hr-worker", url = "localhost:8001", path = "/workers")
public interface WorkerFeignClient {

	//Tipo de chamada WebService é da mesma forma que foi criada no outro projeto
	@GetMapping(value = "/{id}")
	ResponseEntity<Worker> findById(@PathVariable Long id);
}