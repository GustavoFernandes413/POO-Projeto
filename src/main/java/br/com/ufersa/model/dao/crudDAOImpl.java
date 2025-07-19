package br.com.ufersa.model.dao;

import br.com.ufersa.model.entities.Cliente;
import br.com.ufersa.util.JPAUtil;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

// Quero usar essa classe para diminuir a repetição de código
// TODO - verificar soluções para implementar o R: Read das operacoes
public abstract class crudDAOImpl <T> implements crudDAO <T>{
    private final EntityManager em = JPAUtil.getEntityManagerFactory();

    public void save(T object) {
        EntityTransaction ts = em.getTransaction();
        try {
            ts.begin();
            em.persist(object);
            ts.commit();
        } catch (RuntimeException e) {
            if (ts.isActive()) {
                ts.rollback();
            }
            throw new RuntimeException("Erro ao salvar usuário", e);
        } finally {
            JPAUtil.shutdown();
        }
    }
    @Override
    public void update(T object) {
        EntityTransaction ts = em.getTransaction();
        try {
            ts.begin();
            em.merge(object);
            ts.commit();
        } catch (RuntimeException e) {
            if (ts.isActive()) {
                ts.rollback();
            }
            throw new RuntimeException("Erro ao salvar usuário", e);
        } finally {
            JPAUtil.shutdown(); // encerrando conexao com o BD
        }
    }

    public void delete(T object) {
        EntityTransaction ts = em.getTransaction();
        try {
            ts.begin();
            em.remove(object);
            ts.commit();
        } catch (RuntimeException e) {
            if (ts.isActive()) {
                ts.rollback();
            }
            throw new RuntimeException("Erro ao deletar usuário", e);
        } finally {
            JPAUtil.shutdown(); // encerrando conexao com o BD
        }
    }
}
