package br.alanna.rangel.votacao_service.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "proposta-service", url = "https://localhost:8082")
public interface FuncionarioFeignClient {

    @GetMapping("/funcionarios/verificar")
    boolean verificarFuncionarioCadastrado(@RequestParam("cpf") String cpf);
}
