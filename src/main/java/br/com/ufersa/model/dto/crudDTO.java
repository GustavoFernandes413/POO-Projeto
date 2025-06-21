package br.com.ufersa.model.dto;

import br.com.ufersa.model.entities.Cliente;

import java.util.List;

public interface crudDTO<T> {
    T findById(Long id);
    List<T> getAll();
    void save(T obj);
    void delete(T obj);
    void update(T obj);
}
