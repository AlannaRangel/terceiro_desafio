package br.alanna.rangel.proposta_service.Service;

import br.alanna.rangel.proposta_service.Model.Proposal;
import br.alanna.rangel.proposta_service.Repository.ProposalRepository;
import br.alanna.rangel.proposta_service.Repository.VoteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class ProposalService {
    @Autowired
    private ProposalRepository proposalRepository;

    public Proposal createProposal(Proposal proposal) {
        // Lógica para criar a proposta
        Proposal newProposal = proposalRepository.save(proposal);
        return newProposal;
    }

    public void startVoting(Long id, Long duration) {
        Proposal proposal = proposalRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        proposal.setVotingEndTime(LocalDateTime.now().plusMinutes(duration != null ? duration : 1));
        proposalRepository.save(proposal);
    }

    @Autowired
    private VoteRepository voteRepository;

    public long countVotesForProposal(Long proposalId) {
        return voteRepository.countByProposalId(proposalId);
    }

    public Proposal getProposalById(Long proposalId) {
        return proposalRepository.findById(proposalId)
                .orElseThrow(() -> new EntityNotFoundException("Proposta não encontrada com o ID: " + proposalId));
    }
}