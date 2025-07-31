package br.com.ufersa.model.services;

import br.com.ufersa.exceptions.PessoaExisteException;
import br.com.ufersa.model.entities.Locais;
import java.util.List;

public interface LocaisService {
    void cadastrarLocal(Locais local) throws  Exception;
    void mudarLocal(Locais local);
    Locais getLocalById(Long id);
    List<Locais> getAllLocais();
    Locais findByNomeCasa(Locais locais);
    void deletarLocais(Locais locais) throws Exception;
    void editarLocais(Locais locais) throws Exception;
}
