package br.alanna.rangel.funcionario_service.Controller;

import br.alanna.rangel.funcionario_service.Model.Funcionario;
import br.alanna.rangel.funcionario_service.Service.FuncionarioServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class FuncionarioControllerTest {

    @InjectMocks
    private FuncionarioController funcionarioController;

    @Mock
    private FuncionarioServiceImpl funcionarioService;

    public FuncionarioControllerTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateFuncionario() {
        Funcionario funcionario = new Funcionario();
        when(funcionarioService.create(funcionario)).thenReturn(funcionario);

        ResponseEntity<?> response = funcionarioController.createFuncionario(funcionario);

        assertEquals(HttpStatus.CREATED, ((ResponseEntity<?>) response).getStatusCode());
        assertEquals(funcionario, response.getBody());
    }

    @Test
    public void testGetFuncionario() {
        Long id = 1L;
        Funcionario funcionario = new Funcionario();
        when(funcionarioService.findById(id)).thenReturn(Optional.of(funcionario));

        ResponseEntity<Funcionario> response = funcionarioController.getFuncionario(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(funcionario, response.getBody());
    }

    @Test
    public void testGetFuncionarioNotFound() {
        Long id = 1L;
        when(funcionarioService.findById(id)).thenReturn(Optional.empty());

        ResponseEntity<Funcionario> response = funcionarioController.getFuncionario(id);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testListFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();
        when(funcionarioService.findAll()).thenReturn(funcionarios);

        List<Funcionario> response = funcionarioController.listFuncionarios();

        assertEquals(funcionarios, response);
    }

    @Test
    public void testDeleteFuncionario() {
        Long id = 1L;

        ResponseEntity<Void> response = funcionarioController.deleteFuncionario(id);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        Mockito.verify(funcionarioService, Mockito.times(1)).delete(id);
    }
}