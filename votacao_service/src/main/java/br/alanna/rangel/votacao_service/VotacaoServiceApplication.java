package br.alanna.rangel.votacao_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "br.alanna.rangel")
public class VotacaoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VotacaoServiceApplication.class, args);
	}

}
