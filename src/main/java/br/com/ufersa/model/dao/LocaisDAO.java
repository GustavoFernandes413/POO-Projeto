package br.com.ufersa.model.dao;

import br.com.ufersa.model.entities.Locais;

public interface LocaisDAO extends crudDAO<Locais> {
    Locais findByName(Locais local);
}
