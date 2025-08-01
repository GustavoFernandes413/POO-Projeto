package br.com.ufersa.model.dao;

import br.com.ufersa.model.entities.Equipamentos;

import java.util.List;

public interface EquipamentosDAO extends crudDAO<Equipamentos> {
    Equipamentos findById(Equipamentos equip);
    List<Equipamentos> getAll();
    List<Equipamentos> findByName(Equipamentos equipamentos);
    List<Equipamentos> findByResponsavel(Equipamentos equipamentos);
    List<Equipamentos> findByLocal(Equipamentos equipamentos);
    List<Equipamentos> findByNSerie(Equipamentos equipamentos);
    List<Equipamentos> getEquipamentosDisponiveis();
}
