package br.com.ufersa.model.dao;

import br.com.ufersa.model.entities.Cliente;

public interface ClienteDAO extends crudDAO<Cliente> {
    Cliente findByCPF( Cliente cliente);
}
