package br.alanna.rangel.votacao_service.Model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SessaoVotacaoRequest {
    private Long id;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private Boolean ativa;



}
