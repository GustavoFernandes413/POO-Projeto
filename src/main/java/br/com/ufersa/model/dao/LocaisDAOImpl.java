package br.com.ufersa.model.dao;

import br.com.ufersa.model.entities.Cliente;
import br.com.ufersa.model.entities.Locais;
import br.com.ufersa.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class LocaisDAOImpl extends crudDAOImpl<Locais> implements LocaisDAO {
    // Injeção de dependência
    private final EntityManager em = JPAUtil.getEntityManagerFactory();

    @Override
    public Locais findByName(Locais locais) {
        String nomeLocal = locais.getNomeCasa();
        try{
            TypedQuery<Locais> query =  em.createQuery("select l FROM Locais l WHERE l.nomeCasa =:nomeLocal",Locais.class);
            query.setParameter("nomeLocal", nomeLocal);
            return query.getSingleResult();
        }catch (NoResultException e){
            throw  new NoResultException("Nenhum Locais encontrado"+e);
        }
    }

    @Override
    public Locais findById(Long id) {
        return em.find(Locais.class, id);
    }

    @Override
    public List<Locais> getAll() {
        return em.createQuery("FROM Locais", Locais.class).getResultList();
    }
}
