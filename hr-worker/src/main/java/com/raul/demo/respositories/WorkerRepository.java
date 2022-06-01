package com.raul.demo.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raul.demo.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}