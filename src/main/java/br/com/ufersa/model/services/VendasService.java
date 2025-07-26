package br.com.ufersa.model.services;

import br.com.ufersa.model.entities.Vendas;

import java.sql.Timestamp;
import java.util.List;

public interface VendasService {
    void criarVenda(Vendas vendas);

    Vendas getVendaById(Vendas vendas);

    Vendas gerarNotaVenda(Vendas venda);

    List<Vendas> relatorio(Timestamp dataInicio, Timestamp dataFim);

    void cancelamento(Vendas venda);

    void addObserver(ObserverVendas observer);

    void removeObserver(ObserverVendas observer);

}
