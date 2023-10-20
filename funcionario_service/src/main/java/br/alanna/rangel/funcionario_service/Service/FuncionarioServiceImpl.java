package br.alanna.rangel.funcionario_service.Service;

import br.alanna.rangel.funcionario_service.Model.Funcionario;
import br.alanna.rangel.funcionario_service.Repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioServiceImpl {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario create(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public Optional<Funcionario> findById(Long id) {
        return funcionarioRepository.findById(id);
    }

    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }

    public void delete(Long id) {
        funcionarioRepository.deleteById(id);
    }
}
