package br.com.ufersa.model.services;

import br.com.ufersa.model.dto.VendasDTOImpl;
import br.com.ufersa.model.entities.Vendas;

import java.sql.Timestamp;
import java.util.List;

public class VendasServiceImpl implements VendasService {
    private final VendasDTOImpl vendasDTO = new VendasDTOImpl();
    @Override
    public Vendas getVendaById(Long id){
        if(validarVendas(id)) return vendasDTO.findById(id);
        else throw  new IllegalArgumentException("Valor do Id é invalido.");

    }
    public  Vendas gerarNotaVenda(Vendas venda){
    // verifica melhor forma de implementar
    }
    @Override
    public List<Vendas> relatorio(Timestamp dataInicio, Timestamp dataFim){
        if(validarVendas(dataInicio) && validarVendas(dataFim)) return vendasDTO.relatorio(dataInicio, dataFim);
        else throw  new IllegalArgumentException("Valor do Data <UNK> invalido.");
    }
    @Override
    public Vendas cancelamento(Long id){
        if(validarVendas(id)) {
            Vendas venda = vendasDTO.findById(id);
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
