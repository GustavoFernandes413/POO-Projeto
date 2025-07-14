package br.com.ufersa.model.dao;

import java.util.List;

public interface crudDAO<T> {
    T findById(T obj);
    List<T> getAll();
    void save(T obj);
    void delete(T obj);
    void update(T obj);
}
