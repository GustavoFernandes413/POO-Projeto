package br.com.ufersa.model.dao;

import br.com.ufersa.util.JPAUtil;
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
            em.merge(object); // TODO verificar uso do merge. Aqui foi colocado porque é preciso criar
            ts.commit();
        } catch (RuntimeException e) {
            if (ts.isActive()) {
                ts.rollback();
            }
            throw new RuntimeException("Erro ao salvar " + object.toString(), e);
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
            throw new RuntimeException("Erro ao atualizar " + object.toString(), e);
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
            throw new RuntimeException("Erro ao deletar " + object.toString(), e);
        } finally {
            JPAUtil.shutdown(); // encerrando conexao com o BD
        }
    }
}
