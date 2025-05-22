package com.rh.backend.domain.services.employee;

import com.rh.backend.domain.entities.employee.Employee;
import com.rh.backend.domain.interfaces.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindEmployeeByIdService {

    @Autowired
    private IRepository<Employee> employeeRepository;

    public Employee execute(String id) {
        Employee employee = this.employeeRepository.findById(id);

        return employee;
    }
}
