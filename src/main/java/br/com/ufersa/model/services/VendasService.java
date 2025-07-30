package br.com.ufersa.model.services;

import br.com.ufersa.model.entities.ItemVenda;
import br.com.ufersa.model.entities.Vendas;

import java.sql.Timestamp;
import java.util.List;

public interface VendasService {
    void criarVenda(Vendas vendas);

    Vendas getVendaById(Vendas vendas);

    Vendas gerarNotaVenda(Vendas venda);

    List<Vendas> relatorio(Vendas vendaInicio, Vendas vendaFim);
    List<Vendas> getAllVendas();
    void cancelamento(Vendas venda);
    Vendas calcularPrecoVenda(List<ItemVenda> itensDaVenda);
    void addObserver(ObserverVendas observer);

    void removeObserver(ObserverVendas observer);

}
