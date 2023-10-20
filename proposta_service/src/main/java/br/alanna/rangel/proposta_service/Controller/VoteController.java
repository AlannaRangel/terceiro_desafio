package br.alanna.rangel.proposta_service.Controller;

import br.alanna.rangel.proposta_service.Model.Vote;
import br.alanna.rangel.proposta_service.Model.VotoType;
import br.alanna.rangel.proposta_service.Service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/votes")
public class VoteController {
    @Autowired
    private VoteService voteService;

    @PostMapping
    public ResponseEntity<Vote> castVote(@RequestBody Vote vote) {
        if (vote.getVotoType() == null || (!vote.getVotoType().equals(VotoType.APPROVE) && !vote.getVotoType().equals(VotoType.REJECT))) {
            // Para lidar com um valor de voto desconhecido ou nulo, retorna um erro ou um valor padrão.
            return ResponseEntity.badRequest().body(null);
        }

        try {
            Vote createdVote = voteService.castVote(vote);
            return ResponseEntity.ok(createdVote);
        } catch (ResponseStatusException e) {
            // Para lidar com exceções lançadas pelo serviço.
            return ResponseEntity.status(e.getStatusCode()).body(null);
        }
    }

}