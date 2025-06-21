package br.com.ufersa.model.services;

import br.com.ufersa.model.entities.Pessoa;
import java.util.List;

public interface PessoaService {
    void mudarNome(Long id, String nomeP);
    void mudarEndereco(Long id, String enderecoP);
    Pessoa getPessoaById(Long id);
    List<Pessoa> getAllPessoas();
}
