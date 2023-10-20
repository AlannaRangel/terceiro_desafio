package br.alanna.rangel.funcionario_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FuncionarioServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FuncionarioServiceApplication.class, args);
	}

}
