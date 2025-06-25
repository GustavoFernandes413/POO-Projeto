package br.com.ufersa.model.services;

import br.com.ufersa.model.entities.Pessoa;

import java.util.List;

public interface PessoaService  {
    void mudarNome(Pessoa pessoa);
    void mudarEndereco(Pessoa pessoa);
    Pessoa getPessoaById(Pessoa pessoa);
    List<Pessoa> getAllPessoas();
}
