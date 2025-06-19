package br.com.ufersa.model.dto;

import java.util.List;
import br.com.ufersa.model.dto.crudDTO;
import br.com.ufersa.model.entities.Cliente;

public interface ClienteDTO extends crudDTO {
    Cliente findByCPF(Cliente cliente);
    List<Cliente> getAll();
}
