package br.com.ufersa.model.dao;

import br.com.ufersa.model.entities.Pessoa;
import br.com.ufersa.model.entities.Responsavel;
import br.com.ufersa.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ResponsavelDAOImpl extends crudDAOImpl<Responsavel> implements ResponsavelDAO {

    private final EntityManager em = JPAUtil.getEntityManagerFactory();

    // TODO: passar objetos pelas camadas
    // TODO: Refatorar codigo, pois há muita repeticao de tarefas entre as classes do DAO
    @Override
    public Responsavel findById(Long id) {
        try {
            return em.find(Responsavel.class, id);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Valor passado é incorreto" + e);
        }    }

    @Override
    public List<Responsavel> getAll() {
        return em
            .createQuery("FROM Responsavel", Responsavel.class)
            .getResultList();
    }
    @Override
    public Responsavel findBytelefone(String telefone){
        TypedQuery<Responsavel> query = em.createQuery("select r from Responsavel r WHERE r.telefone= :telefone", Responsavel.class)
                .setParameter("telefone", telefone);
        return query.getSingleResult();
    }
}
