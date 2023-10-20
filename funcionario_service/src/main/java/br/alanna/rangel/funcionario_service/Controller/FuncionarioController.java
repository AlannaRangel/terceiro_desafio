package br.alanna.rangel.funcionario_service.Controller;

import br.alanna.rangel.funcionario_service.Model.Funcionario;
import br.alanna.rangel.funcionario_service.Service.FuncionarioServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioServiceImpl funcionarioService;

    @PostMapping

        public ResponseEntity<?> createFuncionario(@Valid @RequestBody Funcionario funcionario) {
            Funcionario createdFuncionario = funcionarioService.create(funcionario);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdFuncionario);
        }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> getFuncionario(@PathVariable Long id) {
        Optional<Funcionario> funcionario = funcionarioService.findById(id);
        return funcionario.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Funcionario> listFuncionarios() {
        return funcionarioService.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFuncionario(@PathVariable Long id) {
        funcionarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
