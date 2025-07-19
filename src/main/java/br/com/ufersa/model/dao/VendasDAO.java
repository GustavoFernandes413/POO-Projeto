package br.com.ufersa.model.dao;

import br.com.ufersa.model.entities.Vendas;
import java.sql.Timestamp;
import java.util.List;

public interface VendasDAO  {
    Vendas findById(Long id);
    List<Vendas> getAll();
    List<Vendas> relatorio(Timestamp inicio, Timestamp fim);
}
