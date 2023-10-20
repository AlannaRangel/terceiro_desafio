package br.alanna.rangel.votacao_service.Repository;

import br.alanna.rangel.votacao_service.Model.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Long> {
    List<Voto> findBySessaoId(Long sessaoId);
}
