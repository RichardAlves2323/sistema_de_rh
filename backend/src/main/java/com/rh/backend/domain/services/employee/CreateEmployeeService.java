package com.rh.backend.domain.services.employee;

import com.rh.backend.domain.entities.employee.Employee;
import com.rh.backend.domain.interfaces.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CreateEmployeeService {

    @Autowired
    private IRepository<Employee> employeeRepository;

    public Employee execute(Employee employee) {

        String identificationCode = this.createIdentificationCode();
        employee.setIdentificationCode(identificationCode);
        this.employeeRepository.create(employee);

        return employee;
    }


    private String createIdentificationCode() {
        int lastCode = Integer.parseInt(this.employeeRepository.lastIdentificationCode());
        return Integer.toString(++lastCode);
    }
}
