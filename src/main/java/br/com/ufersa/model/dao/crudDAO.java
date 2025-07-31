package br.com.ufersa.model.dao;

import java.util.List;

// TODO - mudar o findById de acordo com a resposta de Gadelha
public interface crudDAO<T> {
    void save(T obj) throws RuntimeException;
    void delete(T obj);
    void update(T obj);
}
