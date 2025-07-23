package br.com.ufersa.model.dao;

import br.com.ufersa.model.entities.Responsavel;

import java.util.List;

public interface ResponsavelDAO  extends crudDAO<Responsavel> {
    Responsavel findByLogin(Responsavel responsavel);
    Responsavel findById(Responsavel responsavel);
    List<Responsavel> getAll();
    Responsavel findBytelefone(Responsavel responsavel);
}
