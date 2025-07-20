package br.com.ufersa.model.services;

import br.com.ufersa.model.entities.Cliente;

public interface ClienteService extends PessoaService {
    void cadastrarCliente(Cliente cliente);
}
