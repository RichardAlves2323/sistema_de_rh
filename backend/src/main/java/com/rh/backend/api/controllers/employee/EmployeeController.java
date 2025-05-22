package com.rh.backend.api.controllers.employee;

import com.rh.backend.api.dtos.EmployeeDTO;
import com.rh.backend.domain.entities.employee.Employee;
import com.rh.backend.domain.services.employee.CreateEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private CreateEmployeeService createEmployeeService;

    @PostMapping("/create")
    public ResponseEntity<Employee>  execute(@RequestBody EmployeeDTO employeeDTO) {

        Employee newEmployee = new Employee(employeeDTO.fistName(), employeeDTO.lastName(), employeeDTO.email());

        Employee createdEmployee = this.createEmployeeService.execute(newEmployee);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
    }
}
