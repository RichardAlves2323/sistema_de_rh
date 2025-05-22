package com.rh.backend.domain.repositories.employee;

import com.rh.backend.domain.entities.employee.Employee;
import com.rh.backend.domain.errors.DuplicateEmailException;
import com.rh.backend.domain.errors.EmployeeNotFoundException;
import com.rh.backend.domain.interfaces.IRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Repository
public class EmployeeRepositoryByArray implements IRepository<Employee> {

    private List<Employee> employees = new ArrayList<Employee>();

    @Override
    public Employee create(Employee entity) {
        Employee existWithSameEmail = this.existEmployeesWithSameEmail(entity);

        if (existWithSameEmail != null) {
            throw new DuplicateEmailException("Ja existe um funcionario com esse email");
        }

        employees.add(entity);

        return entity;
    }

    @Override
    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public Employee findById(String id) {
        Employee employee = employees.stream().filter(
                emplo -> emplo.getIdentificationCode().equals(id))
                .findAny()
                .orElse(null);

        if (employee == null) throw new EmployeeNotFoundException("Nenhum funcionario encontrado com esse identificador " + id);

        return employee;
    }

    @Override
    public String lastIdentificationCode() {
        Employee employee = employees.stream().max(Comparator.comparing(Employee::getIdentificationCode)).orElse(null);

        if (employee == null) return "0";

        return employee.getIdentificationCode();
    }

    private Employee existEmployeesWithSameEmail(Employee entity) {

        return employees.stream().filter(
                employee -> employee.getEmail().equals(entity.getEmail()))
                .findAny().orElse(null);
    }

}
