package br.com.ufersa.model.dto;

import br.com.ufersa.model.dto.crudDTO;
import br.com.ufersa.model.entities.Locais;
import java.util.List;

public interface LocaisDTO extends crudDTO {
    List<Locais> getAll();
    Locais findByName(Locais local);
}
