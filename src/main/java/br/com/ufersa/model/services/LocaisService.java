package br.com.ufersa.model.services;

import br.com.ufersa.model.entities.Locais;
import java.util.List;

public interface LocaisService {
    void cadastrarLocal(Locais local);
    void mudarLocal(Locais local);
    Locais getLocalById(Locais local);
    List<Locais> getAllLocais();
    Locais findByNomeCasa(Locais locais);
}
