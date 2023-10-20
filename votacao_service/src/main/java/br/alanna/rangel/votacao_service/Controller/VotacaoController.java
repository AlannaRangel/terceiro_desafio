package br.alanna.rangel.votacao_service.Controller;

import br.alanna.rangel.votacao_service.Model.SessaoVotacao;
import br.alanna.rangel.votacao_service.Model.SessaoVotacaoRequest;
import br.alanna.rangel.votacao_service.Model.Voto;
import br.alanna.rangel.votacao_service.Repository.SessaoVotacaoRepository;
import br.alanna.rangel.votacao_service.Service.VotacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Map;
@RestController
@RequestMapping("/votacao")
@RequiredArgsConstructor
public class VotacaoController {


    @Autowired
    private VotacaoService votacaoService;
    private final SessaoVotacaoRepository sessaoVotacaoRepository;

    @PostMapping("/iniciar")
    public ResponseEntity<SessaoVotacao> iniciar(@RequestBody SessaoVotacaoRequest request) {
        SessaoVotacao novaSessao = new SessaoVotacao();
        novaSessao.setDataInicio(request.getDataInicio());
        novaSessao.setDataFim(request.getDataFim());
        novaSessao.setAtiva(request.getAtiva());

        SessaoVotacao sessaoSalva = sessaoVotacaoRepository.save(novaSessao);

        return ResponseEntity.ok(sessaoSalva);
    }

    @PostMapping("/votar")
    public ResponseEntity<String> votar(@RequestBody Voto voto) {
        votacaoService.votar(voto.getFuncionarioId(), voto.getAprovado());
        return ResponseEntity.ok("Votou com sucesso");
    }

    @GetMapping("/resultado/{sessaoId}")
    public ResponseEntity<Map<String, Long>> obterResultado(@PathVariable Long sessaoId) {
        return ResponseEntity.ok(votacaoService.obterResultado(sessaoId));
    }
}
