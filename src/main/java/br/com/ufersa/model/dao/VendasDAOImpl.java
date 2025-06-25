package br.com.ufersa.model.dao;

import br.com.ufersa.model.entities.Vendas;
import br.com.ufersa.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.sql.Timestamp;
import java.util.List;

public class VendasDAOImpl implements VendasDAO {

    private final EntityManager em = JPAUtil.getEntityManagerFactory();

    @Override
    public List<Vendas> relatorio(Timestamp inicio, Timestamp fim) {
        try {
            return em
                .createQuery(
                    "SELECT * FROM Vendas WHERE data BETWEEN " +
                    inicio +
                    " AND " +
                    fim,
                    Vendas.class
                )
                .getResultList();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(
                "Argumento passado é invalido ",
                e
            );
        }
    }

    @Override
    public Vendas findById(Long id) {
        return em.find(Vendas.class, id);
    }

    @Override
    public List<Vendas> getAll() {
        return em.createQuery("FROM Vendas", Vendas.class).getResultList();
    }

    @Override
    public void save(Vendas vendas) {
        EntityTransaction ts = em.getTransaction();
        try {
            ts.begin();
            em.persist(vendas);
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
    public void update(Vendas vendas) {
        EntityTransaction ts = em.getTransaction();
        try   {
            ts.begin();
            em.merge(vendas);
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

    @Override
    public void delete(Vendas vendas) {
        EntityTransaction ts = em.getTransaction();
        try {
            ts.begin();
            em.remove(vendas);
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
