package br.alanna.rangel.proposta_service.Service;

import br.alanna.rangel.proposta_service.Model.Employee;

import br.alanna.rangel.proposta_service.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(String cpf, String nome) {
        if (isValidCPF(cpf)) {
            // Verifica se o CPF já está cadastrado no banco de dados
            if (employeeRepository.existsByCpf(cpf)) {
                throw new RuntimeException("Employee with this CPF already exists.");
            }

            Employee employee = new Employee();
            employee.setCpf(cpf);
            employee.setNome(nome);

            // Salva o novo funcionário no banco de dados
            return employeeRepository.save(employee);
        } else {
            throw new RuntimeException("Invalid CPF.");
        }
    }

    public boolean isValidCPF(String cpf) {
        // Remove qualquer caracteres não numéricos do CPF
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verifica se o CPF tem 11 dígitos
        if (cpf.length() != 11) {
            System.out.println("CPF não tem 11 dígitos.");
            return false;
        }


        System.out.println("CPF válido.");
        return true;
    }
}