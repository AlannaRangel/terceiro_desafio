package br.alanna.rangel.proposta_service.Repository;

import br.alanna.rangel.proposta_service.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    boolean existsByCpf(String cpf);
}
