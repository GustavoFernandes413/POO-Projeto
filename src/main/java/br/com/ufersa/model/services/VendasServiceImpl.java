package br.com.ufersa.model.services;

import br.com.ufersa.model.dao.VendasDAOImpl;
import br.com.ufersa.model.entities.Vendas;

import java.sql.Timestamp;
import java.util.List;

public class VendasServiceImpl implements VendasService {
    private final VendasDAOImpl vendasDTO = new VendasDAOImpl();
    @Override
    public Vendas getVendaById(Long vendas){
        if(validarVendas(vendas)) return vendasDTO.findById(vendas);
        else throw  new IllegalArgumentException("Valor do Id é invalido.");

    }
    public  Vendas gerarNotaVenda(Vendas venda){
    // TODO verifica melhor forma de implementar
        return venda;
    }
    @Override
    public List<Vendas> relatorio(Timestamp dataInicio, Timestamp dataFim){
        if(validarVendas(dataInicio) && validarVendas(dataFim)) return vendasDTO.relatorio(dataInicio, dataFim);
        else throw  new IllegalArgumentException("Valor do Data <UNK> invalido.");
    }
    // TODO - PASSAR o objeto em lugar do id
    @Override
    public Vendas cancelamento(Vendas venda){
        if(validarVendas(venda)) {
            venda.setStatus("CANCELADO"); // TODO no futuro, adicionar uma enumeracao
            vendasDTO.update(venda);
            return venda;
        }
        else throw  new IllegalArgumentException("Valor do Id é invalido.");
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
