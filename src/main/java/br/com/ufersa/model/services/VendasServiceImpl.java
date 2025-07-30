package br.com.ufersa.model.services;

import br.com.ufersa.model.dao.VendasDAO;
import br.com.ufersa.model.entities.ItemVenda;
import br.com.ufersa.model.entities.StatusCompra;
import br.com.ufersa.model.entities.Vendas;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class VendasServiceImpl implements VendasService {
    private List<ObserverVendas> observers = new ArrayList<>();
    private final VendasDAO vendasDTO;

    public VendasServiceImpl(VendasDAO vendasDTO) {
        this.vendasDTO = vendasDTO;
    }

    public void addObserver(ObserverVendas observer) {
        observers.add(observer);
    }

    public void removeObserver(ObserverVendas observer) {
        observers.remove(observer);
    }

    private void notifyVendaProcessada(Vendas venda) {
        for (ObserverVendas observer : observers) {
            observer.onVendaProcessada(venda);
        }
    }

    private void notifyVendaCancelada(Vendas venda) {
        for (ObserverVendas observer : observers) {
            observer.onVendaCancelada(venda);
        }
    }

    @Override
    public void criarVenda(Vendas vendas) {
        if (validarVendas(vendas)  && validarVendas(vendas.getCliente() )
                && validarVendas(vendas.getItens())) {
            vendasDTO.save(vendas);
            notifyVendaProcessada(vendas); // envia notificacao para Equipamentos para o estoque ser atualizado
        } else {
            throw new RuntimeException("Venda com dados indefinidos");
        }
    }

    @Override
    public void cancelamento(Vendas venda) {
        if (validarVendas(venda) && venda.getStatus() == StatusCompra.CONCLUIDA) {
            venda.setStatus(StatusCompra.CANCELADA);
            vendasDTO.update(venda);
            notifyVendaCancelada(venda);
        } else throw new IllegalArgumentException("Valor do Id é invalido.");
    }

    @Override
    public Vendas calcularPrecoVenda(List<ItemVenda> itensDaVenda) {
        double precoTotal = 0;
        for (ItemVenda itemVenda : itensDaVenda) {
            precoTotal =+ itemVenda.getQuantidade()*itemVenda.getEquipamento().getPreco();
        }
        Vendas venda = new Vendas();
        venda.setPreco(precoTotal);
        return venda;
    }

    @Override
    public Vendas getVendaById(Vendas vendas) {
        if (validarVendas(vendas)) return vendasDTO.findById(vendas);
        else throw new IllegalArgumentException("Valor do Id é invalido.");

    }

    public Vendas gerarNotaVenda(Vendas venda) {
        // TODO verifica melhor forma de implementar
        return venda;
    }

    @Override
    public List<Vendas> relatorio( Vendas vendaInicio, Vendas vendaFim) {
        if (validarVendas(vendaInicio) && validarVendas(vendaFim)) return vendasDTO.relatorio(vendaInicio, vendaFim);
        else throw new IllegalArgumentException("Valor do Data <UNK> invalido.");
    }

    @Override
    public List<Vendas> getAllVendas() {
        return vendasDTO.getAll();
    }

    public static <T> boolean validarVendas(T objeto) {
        return (objeto != null);
    }

    public static boolean validarVendas(String str) {
        return (!str.isBlank());
    }

    public static boolean validarVendas(Long codigoVenda) {
        return (codigoVenda > 0);
    }

}
