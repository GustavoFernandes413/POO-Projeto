package br.com.ufersa.model.dao;

import br.com.ufersa.model.entities.Vendas;
import java.sql.Timestamp;
import java.util.List;

public interface VendasDAO extends crudDAO<Vendas> {
    List<Vendas> relatorio(Timestamp inicio, Timestamp fim);
}
