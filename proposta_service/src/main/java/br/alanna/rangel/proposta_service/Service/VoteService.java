package br.alanna.rangel.proposta_service.Service;

import br.alanna.rangel.proposta_service.Model.Vote;
import br.alanna.rangel.proposta_service.Model.VotoType;
import br.alanna.rangel.proposta_service.Repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class VoteService {
    @Autowired
    private VoteRepository voteRepository;

    public Vote castVote(String employeeId, Long proposalId, VotoType voteType) {
        if (voteRepository.findByEmployeeIdAndProposalId(employeeId, proposalId).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Employee has already voted for this proposal.");
        }


        Vote vote = new Vote(employeeId, proposalId, voteType);

        return voteRepository.save(vote);
    }

    public Vote castVote(Vote vote) {

        if (vote == null) {
            throw new IllegalArgumentException("Vote object cannot be null.");
        }


        return voteRepository.save(vote);
    }
    public long countApproveVotesForProposal(Long proposalId) {
        return voteRepository.countByProposalIdAndVotoType(proposalId, VotoType.APPROVE);
    }

    public long countRejectVotesForProposal(Long proposalId) {
        return voteRepository.countByProposalIdAndVotoType(proposalId, VotoType.REJECT);
    }
}

