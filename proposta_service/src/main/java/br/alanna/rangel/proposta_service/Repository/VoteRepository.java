package br.alanna.rangel.proposta_service.Repository;

import br.alanna.rangel.proposta_service.Model.Vote;
import br.alanna.rangel.proposta_service.Model.VotoType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoteRepository extends JpaRepository<Vote, Long> {
    Optional<Vote> findByEmployeeIdAndProposalId(String employeeId, Long proposalId);

    long countByProposalId(Long proposalId);

    long countByProposalIdAndVotoType(Long proposalId, VotoType votoType);
}
