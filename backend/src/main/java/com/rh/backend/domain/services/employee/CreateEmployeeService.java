package com.rh.backend.domain.services.employee;

import com.rh.backend.domain.entities.employee.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreateEmployeeService {

    private List<Employee> employees = new ArrayList<Employee>();

    public Employee execute(Employee employee) {

        String identificationCode = this.createIdentificationCode();
        employee.setIdentificationCode(identificationCode);
        this.employees.add(employee);

        return employee;
    }


    private String createIdentificationCode() {
        return Integer.toString(this.employees.size());
    }
}
