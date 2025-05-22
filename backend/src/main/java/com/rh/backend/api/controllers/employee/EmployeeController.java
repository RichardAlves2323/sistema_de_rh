package com.rh.backend.api.controllers.employee;

import com.rh.backend.api.dtos.EmployeeDTO;
import com.rh.backend.domain.entities.employee.Employee;
import com.rh.backend.domain.services.employee.CreateEmployeeService;
import com.rh.backend.domain.services.employee.FindEmployeeByIdService;
import com.rh.backend.domain.services.employee.ListEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private CreateEmployeeService createEmployeeService;

    @Autowired
    private ListEmployeeService listEmployeeService;

    @Autowired
    private FindEmployeeByIdService findEmployeeByIdService;

    @PostMapping("/create")
    public ResponseEntity<Employee>  create(@RequestBody EmployeeDTO employeeDTO) {
        Employee newEmployee = new Employee(employeeDTO.fistName(), employeeDTO.lastName(), employeeDTO.email());

        Employee createdEmployee = this.createEmployeeService.execute(newEmployee);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
    }

    @GetMapping("/")
    public ResponseEntity<List<Employee>> findAll() {
        List<Employee> employees = this.listEmployeeService.execute();

        return ResponseEntity.status(HttpStatus.OK).body(employees);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> findById(@PathVariable String id) {
        Employee employee = this.findEmployeeByIdService.execute(id);

        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }

}
