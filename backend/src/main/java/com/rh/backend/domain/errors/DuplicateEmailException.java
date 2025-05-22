package com.rh.backend.domain.errors;

public class DuplicateEmailException extends RuntimeException{

    public DuplicateEmailException(){super("Email já cadastrado");}

    public DuplicateEmailException(String message){super(message);}
}
