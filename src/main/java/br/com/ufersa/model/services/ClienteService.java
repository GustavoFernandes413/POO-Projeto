package br.com.ufersa.model.services;

import br.com.ufersa.model.entities.Cliente;

public interface ClienteService extends PessoaService<Cliente> {
    void cadastrarCliente(Cliente cliente);
}
