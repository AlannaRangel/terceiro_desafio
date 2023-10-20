package br.alanna.rangel.votacao_service.Repository;

import br.alanna.rangel.votacao_service.Model.SessaoVotacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessaoVotacaoRepository extends JpaRepository<SessaoVotacao, Long> {

}
