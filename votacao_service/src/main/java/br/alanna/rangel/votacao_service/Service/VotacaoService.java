package br.alanna.rangel.votacao_service.Service;

import br.alanna.rangel.votacao_service.Model.SessaoVotacao;
import br.alanna.rangel.votacao_service.Model.Voto;
import br.alanna.rangel.votacao_service.Repository.SessaoVotacaoRepository;
import br.alanna.rangel.votacao_service.Repository.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VotacaoService {

    @Autowired
    private VotoRepository votoRepository;

    @Autowired
    private SessaoVotacaoRepository sessaoVotacaoRepository;


    public SessaoVotacao iniciarVotacao(SessaoVotacao sessao) {
        // Criando uma nova sessão de votação
        SessaoVotacao novaSessao = new SessaoVotacao();
        return sessaoVotacaoRepository.save(novaSessao);
    }

    public Map<String, Long> obterResultado(Long sessaoId) {
        List<Voto> votos = votoRepository.findBySessaoId(sessaoId);

        // Contando votos
        long votosAprovados = votos.stream().filter(Voto::getAprovado).count();
        long votosRejeitados = votos.size() - votosAprovados;

        // Construindo o mapa de resultados
        Map<String, Long> resultado = new HashMap<>();
        resultado.put("Aprovado", votosAprovados);
        resultado.put("Rejeitado", votosRejeitados);

        return resultado;
    }

    @Scheduled(fixedDelay = 60000) // é executado a cada 1 minuto
    public void fecharSessoes() {
        LocalDateTime now = LocalDateTime.now(); // Obtém a data e hora atuais

        SessaoVotacao[] sessoesAtivas = new SessaoVotacao[0];
        for (SessaoVotacao sessao : sessoesAtivas) {
            if (sessao.getAtiva()) {
                LocalDateTime dataFim = sessao.getDataFim(); // Obtém a data de fim da sessão

                // Verifica se a sessão de votação está vencida
                if (now.isAfter(dataFim)) {
                    // Fecha a sessão de votação
                    sessao.setAtiva(false);
                    // Salva a sessão de votação de volta no banco de dados
                    sessaoVotacaoRepository.save(sessao);
                }
            }
        }
    }
    public Voto votar(Long funcionarioId, Boolean aprovado) {
    return null;
    }
}
