package main.java.br.com.ufersa.model.dto;

public interface crudDTO<T> {
    T findById(int id);
    void save(T obj);
    void delete(T obj);
    void update(T obj);
}
