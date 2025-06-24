package br.com.ufersa.model.services;

import br.com.ufersa.model.entities.Vendas;
import java.sql.Timestamp;
import java.util.List;

public interface VendasService {
    Vendas getVendaById(Long id);
    Vendas gerarNotaVenda(Vendas venda);
    List<Vendas> relatorio(Timestamp dataInicio, Timestamp dataFim);
    Vendas cancelamento(Long id);
}
