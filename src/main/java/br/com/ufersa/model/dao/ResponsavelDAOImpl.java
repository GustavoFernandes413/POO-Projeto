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

    // TODO: retirar bussines exception para camada services
    // TODO: Refatorar codigo, pois há muita repeticao de tarefas entre as classes do DAO
    @Override
    public Responsavel findById(Responsavel responsavel) {
        Long id = responsavel.getId();
        TypedQuery<Responsavel> query = em.createQuery("select r from Responsavel r where r.id=:id", Responsavel.class);
        query.setParameter("id", id);
        return query.getResultStream().findFirst().orElse(null);
    }

    @Override
    public Responsavel findByLogin(Responsavel responsavel) {
        String login = responsavel.getLogin();
        TypedQuery<Responsavel> query = em.createQuery("select r from Responsavel r where r.login=:email", Responsavel.class);
        query.setParameter("email", login);
        return query.getResultStream().findFirst().orElse(null);
    }

    @Override
    public List<Responsavel> getAll() {
        return em
                .createQuery("FROM Responsavel", Responsavel.class)
                .getResultList();
    }

    @Override
    public Responsavel findBytelefone(Responsavel responsavel) {
        String telefone = responsavel.getTelefone();
        TypedQuery<Responsavel> query = em.createQuery("select r from Responsavel r WHERE r.telefone= :telefone", Responsavel.class)
                .setParameter("telefone", telefone);
        return query.getSingleResult();
    }
}
