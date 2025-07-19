package br.com.ufersa.model.dao;

import br.com.ufersa.model.entities.Pessoa;
import br.com.ufersa.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class PessoaDAOImpl extends crudDAOImpl<Pessoa> implements PessoaDAO {

    private final EntityManager em = JPAUtil.getEntityManagerFactory();

    @Override
    public Pessoa findById(Long id) {
        try {
            return em.find(Pessoa.class, id);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Valor passado é incorreto" + e);
        }
    }

    @Override
    public List<Pessoa> getAll() {
        return em.createQuery("FROM Pessoa", Pessoa.class).getResultList();
    }
}
