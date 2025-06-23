package br.com.ufersa.model.services;

import br.com.ufersa.model.dto.LocaisDTO;
import br.com.ufersa.model.dto.LocaisDTOImpl;
import br.com.ufersa.model.entities.Locais;

import java.util.List;

public class LocaisServiceImpl implements LocaisService{
    private LocaisDTO locaisDTO = new LocaisDTOImpl();


    @Override
    public void cadastrarLocal(Locais local) {
        locaisDTO.update(local);
    }

    @Override
    public void mudarLocal(Locais local, Long id) {
        locaisDTO.update(local);
    }

    @Override
    public Locais getLocalById(Long id) {
        return locaisDTO.findById(id);
    }

    @Override
    public List<Locais> getAllLocais() {
        return locaisDTO.getAll();
    }

    @Override
    public Locais findByNomeCasa(String nome) {
        return locaisDTO.findByName(nome);
    }
}
