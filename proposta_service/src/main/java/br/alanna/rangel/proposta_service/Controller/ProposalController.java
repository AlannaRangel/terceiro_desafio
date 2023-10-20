package br.alanna.rangel.proposta_service.Controller;

import br.alanna.rangel.proposta_service.Model.Proposal;
import br.alanna.rangel.proposta_service.Service.ProposalService;
import br.alanna.rangel.proposta_service.Service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/propostas")
public class ProposalController {
    @Autowired
    private ProposalService proposalService;
    @Autowired
    private VoteService voteService;

    @PostMapping
    public ResponseEntity<String> criarProposta(@RequestBody Proposal proposal) {
        try {
            Proposal novaProposal = proposalService.createProposal(proposal);
            return ResponseEntity.ok("Proposta criada com sucesso");
        } catch (ResponseStatusException e) {
            return ResponseEntity.badRequest().body("Erro ao criar a proposta: " + e.getReason());
        }
    }

    @GetMapping("/{proposalId}/resultado")
    public ResponseEntity<Map<String, Long>> obterResultadoDaVotacao(@PathVariable Long proposalId) {
        try {
            Proposal proposal = proposalService.getProposalById(proposalId);
            long votosAprovados = voteService.countApproveVotesForProposal(proposalId);
            long votosRejeitados = voteService.countRejectVotesForProposal(proposalId);

            Map<String, Long> resultado = new HashMap<>();
            resultado.put("Aprovados", votosAprovados);
            resultado.put("Rejeitados", votosRejeitados);

            return ResponseEntity.ok(resultado);
        } catch (ResponseStatusException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}