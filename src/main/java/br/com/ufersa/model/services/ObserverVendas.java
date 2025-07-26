package br.com.ufersa.model.services;

import br.com.ufersa.model.entities.Vendas;

public interface ObserverVendas {
    void onVendaProcessada(Vendas venda);

    void onVendaCancelada(Vendas venda); // Evento para notificar sobre uma venda processada


}
