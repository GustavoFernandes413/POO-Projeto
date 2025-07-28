package br.com.ufersa.model.services;

import br.com.ufersa.model.dao.LocaisDAO;
import br.com.ufersa.model.dao.LocaisDAOImpl;
import br.com.ufersa.model.entities.Locais;

import java.util.List;

public class LocaisServiceImpl implements LocaisService {
    private final LocaisDAO locaisDAO;

    public LocaisServiceImpl(LocaisDAO locaisDAO) {
        this.locaisDAO = locaisDAO;
    }


    @Override
    public void cadastrarLocal(Locais local) throws RuntimeException {
        try {
            locaisDAO.update(local);

        } catch (Exception e) {
            throw new RuntimeException("Este Local já esta cadastrado!");
        }
    }

    @Override
    public void mudarLocal(Locais local) {
        locaisDAO.update(local);
    }

    @Override
    public Locais getLocalById(Long local) {
        return locaisDAO.findById(local);
    }

    @Override
    public List<Locais> getAllLocais() {
        return locaisDAO.getAll();
    }

    @Override
    public Locais findByNomeCasa(Locais local) {
        return locaisDAO.findByName(local);
    }
}
