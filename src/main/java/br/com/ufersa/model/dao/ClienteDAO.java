package br.com.ufersa.model.dao;

import br.com.ufersa.model.entities.Cliente;

import java.util.List;

public interface ClienteDAO extends crudDAO<Cliente> {
    Cliente findByCPF( Cliente cliente);
    Cliente findById(Long id);
    List<Cliente> getAll();
}
