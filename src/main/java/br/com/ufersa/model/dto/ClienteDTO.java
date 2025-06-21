package br.com.ufersa.model.dto;

import br.com.ufersa.model.entities.Cliente;
import java.util.List;

public interface ClienteDTO extends crudDTO<Cliente>  {
    Cliente findByCPF(Long cpf);
}
