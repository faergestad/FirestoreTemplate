package com.faergestad.FirestoreTemplate.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FirestoreRepository<T> {

    public List<T> findAll();

    public T findById(String id);

}
