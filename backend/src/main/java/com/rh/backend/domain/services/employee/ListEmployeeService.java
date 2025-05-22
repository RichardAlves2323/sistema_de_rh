package com.rh.backend.domain.services.employee;

import com.rh.backend.domain.entities.employee.Employee;
import com.rh.backend.domain.interfaces.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListEmployeeService {

    @Autowired
    private IRepository<Employee> employeeRepository;

    public List<Employee> execute() {
        return this.employeeRepository.findAll();
    }
}
