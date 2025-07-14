package br.com.ufersa.model.dao;

import br.com.ufersa.model.entities.Pessoa;
import br.com.ufersa.model.entities.Responsavel;
import br.com.ufersa.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class ResponsavelDAOImpl implements ResponsavelDAO {

    private final EntityManager em = JPAUtil.getEntityManagerFactory();

    // TODO: passar objetos pelas camadas
    // TODO: Refatorar codigo, pois há muita repeticao de tarefas entre as classes do DAO
    @Override
    public Responsavel findById(Responsavel responsavel) {
        Long id = responsavel.getId();
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
    public void save(Responsavel cliente) {
        EntityTransaction ts = em.getTransaction();
        try {
            ts.begin();
            em.persist(cliente);
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
    public void update(Responsavel cliente) {
        EntityTransaction ts = em.getTransaction();
        try {
            ts.begin();
            em.merge(cliente);
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
    public void delete(Responsavel cliente) {
        EntityTransaction ts = em.getTransaction();
        try {
            ts.begin();
            em.remove(cliente);
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
