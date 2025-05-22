package com.rh.backend.domain.errors;

public class EmployeeNotFoundException extends RuntimeException{

    public EmployeeNotFoundException(){super("Nenhum funcionario encontrado");}

    public EmployeeNotFoundException(String message){super(message);}
}
