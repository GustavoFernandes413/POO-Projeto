package br.com.ufersa.model.dto;

import br.com.ufersa.model.entities.Responsavel;
import br.com.ufersa.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class ResponsavelImpl implements ResponsavelDTO {

    private final EntityManager em = JPAUtil.getEntityManagerFactory();

    @Override
    public Responsavel findById(Long id) {
        return em.find(Responsavel.class, id);
    }

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
