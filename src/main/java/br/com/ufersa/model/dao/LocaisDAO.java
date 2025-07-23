package br.com.ufersa.model.dao;

import br.com.ufersa.model.entities.Locais;

import java.util.List;

public interface LocaisDAO extends crudDAO<Locais> {
    Locais findById(Long id);
    List<Locais> getAll();
    Locais findByName(Locais local);

}
