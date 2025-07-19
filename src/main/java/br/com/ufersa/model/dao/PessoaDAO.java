package br.com.ufersa.model.dao;
import br.com.ufersa.model.entities.Pessoa;

import java.util.List;

public interface PessoaDAO extends crudDAO<Pessoa> {
    Pessoa findById(Long id);
    List<Pessoa> getAll();
}
