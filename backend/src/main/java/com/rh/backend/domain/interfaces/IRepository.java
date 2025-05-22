package com.rh.backend.domain.interfaces;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRepository<T> {

    T create(T entity);
    List<T> findAll();
    T findById(String id);
    String lastIdentificationCode();
}
