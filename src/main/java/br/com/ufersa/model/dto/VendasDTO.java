package br.com.ufersa.model.dto;

import br.com.ufersa.model.dto.crudDTO;
import br.com.ufersa.model.entities.Vendas;
import java.sql.Timestamp;
import java.util.List;

public interface VendasDTO extends crudDTO<Vendas> {
    List<Vendas> relatorio(Timestamp inicio, Timestamp fim);
}
