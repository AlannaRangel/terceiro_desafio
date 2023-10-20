package br.alanna.rangel.proposta_service.Repository;

import br.alanna.rangel.proposta_service.Model.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProposalRepository extends JpaRepository<Proposal, Long> {
}
