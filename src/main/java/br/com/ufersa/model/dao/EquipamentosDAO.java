package br.com.ufersa.model.dao;

import br.com.ufersa.model.entities.Equipamentos;

public interface EquipamentosDAO extends crudDAO<Equipamentos> {
    Equipamentos findByName(String nomeEquipamentos);
}
