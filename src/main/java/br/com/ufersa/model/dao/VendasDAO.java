package br.com.ufersa.model.dao;

import br.com.ufersa.model.entities.Vendas;
import java.sql.Timestamp;
import java.util.List;

public interface VendasDAO extends crudDAO<Vendas> {
    Vendas findById(Vendas vendas);
    List<Vendas> getAll();
    List<Vendas> relatorio(Vendas vendaInicio, Vendas vendaFim);
}
