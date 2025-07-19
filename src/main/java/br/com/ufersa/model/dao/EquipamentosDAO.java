package br.com.ufersa.model.dao;

import br.com.ufersa.model.entities.Equipamentos;

import java.util.List;

public interface EquipamentosDAO  {
    Equipamentos findById(Long id);
    List<Equipamentos> getAll();
    Equipamentos findByName(Equipamentos equipamentos);
}
