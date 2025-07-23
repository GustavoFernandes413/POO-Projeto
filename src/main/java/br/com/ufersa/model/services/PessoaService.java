package br.com.ufersa.model.services;

import br.com.ufersa.model.entities.Pessoa;

import java.util.List;
// permite que a interface PessoaService seja usado pela classe Pessoa e por qualquer subclasse dela.
public interface PessoaService <T extends Pessoa>  {
    void mudarNome(Pessoa pessoa);
    void mudarEndereco(Pessoa pessoa);
    T getPessoaById(T objeto);
    List<Pessoa> getAllPessoas();
}
