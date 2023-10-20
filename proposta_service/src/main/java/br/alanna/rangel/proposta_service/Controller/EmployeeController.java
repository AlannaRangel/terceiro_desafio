package br.alanna.rangel.proposta_service.Controller;

import br.alanna.rangel.proposta_service.Model.Employee;
import br.alanna.rangel.proposta_service.Model.EmployeeRequest;
import br.alanna.rangel.proposta_service.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{cpf}/can-vote")
    public ResponseEntity<String> canVote(@PathVariable String cpf) {
        return ResponseEntity.ok(employeeService.isValidCPF(cpf) ? "can vote" : "cannot vote");
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeRequest employeeRequest) {

        if (!employeeService.isValidCPF(employeeRequest.getCpf())) {
            return ResponseEntity.badRequest().body(null);
        }


        Employee newEmployee = employeeService.createEmployee(employeeRequest.getCpf(), employeeRequest.getNome());

        return ResponseEntity.ok(newEmployee);
    }
}
