package br.com.ufersa.model.dto;

import br.com.ufersa.model.dto.crudDTO;
import br.com.ufersa.model.entities.Equipamentos;
import java.util.List;

public interface EquipamentosDTO extends crudDTO {
    List<Equipamentos> getall();
    Equipamentos findByName(Equipamentos equipamentos);
}
