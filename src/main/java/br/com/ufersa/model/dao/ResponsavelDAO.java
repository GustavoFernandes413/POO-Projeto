package br.com.ufersa.model.dao;

import br.com.ufersa.model.entities.Responsavel;

import java.util.List;

public interface ResponsavelDAO  {
    Responsavel findById(Long id);
    List<Responsavel> getAll();
    Responsavel findBytelefone(String nome);
}
