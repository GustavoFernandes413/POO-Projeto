package br.com.ufersa.model.services;

import br.com.ufersa.model.dao.LocaisDAO;
import br.com.ufersa.model.dao.LocaisDAOImpl;
import br.com.ufersa.model.entities.Locais;

import java.util.List;

public class LocaisServiceImpl implements LocaisService{
    private LocaisDAO locaisDAO = new LocaisDAOImpl();


    @Override
    public void cadastrarLocal(Locais local) {
        locaisDAO.update(local);
    }

    @Override
    public void mudarLocal(Locais local, Long id) {
        locaisDAO.update(local);
    }

    @Override
    public Locais getLocalById(Long id) {
        return locaisDAO.findById(id);
    }

    @Override
    public List<Locais> getAllLocais() {
        return locaisDAO.getAll();
    }

    @Override
    public Locais findByNomeCasa(String nome) {
        return locaisDAO.findByName(nome);
    }
}
