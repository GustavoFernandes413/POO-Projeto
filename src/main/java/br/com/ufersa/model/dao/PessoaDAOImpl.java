package br.com.ufersa.model.dao;

import br.com.ufersa.model.entities.Pessoa;
import br.com.ufersa.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PessoaDAOImpl extends crudDAOImpl<Pessoa> implements PessoaDAO {

    private final EntityManager em = JPAUtil.getEntityManagerFactory();

    @Override
    public Pessoa findById(Pessoa pessoa) {
        try {
            Long id = pessoa.getId();
            TypedQuery<Pessoa> query = em.createQuery("select p from Pessoa p WHERE p.id=:id", Pessoa.class);
            query.setParameter("id", id);
            return query.getResultStream().findFirst().orElse(null);
        }finally {
            em.close();
        }

    }

    @Override
    public List<Pessoa> getAll() {
        return em.createQuery("FROM Pessoa", Pessoa.class).getResultList();
    }
}
