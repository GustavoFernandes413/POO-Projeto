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
    public void mudarLocal(Locais local) {
        locaisDAO.update(local);
    }

    @Override
    public Locais getLocalById(Long  local) {
        return locaisDAO.findById(local);
    }

    @Override
    public List<Locais> getAllLocais() {
        return locaisDAO.getAll();
    }

    @Override
    public Locais findByNomeCasa(Locais  local) {
        return locaisDAO.findByName(local);
    }
}
