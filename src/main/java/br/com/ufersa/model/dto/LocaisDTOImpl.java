package br.com.ufersa.model.dto;

import br.com.ufersa.model.entities.Equipamentos;
import br.com.ufersa.model.entities.Locais;
import br.com.ufersa.model.entities.Pessoa;
import br.com.ufersa.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class LocaisDTOImpl implements LocaisDTO{
    private final EntityManager em = JPAUtil.getEntityManagerFactory();

    @Override
    public Locais findByName(String nomeLocal) {
        TypedQuery<Locais> query = em.createQuery("SELECT l FROM Locais l WHERE l.nome = :nome", Locais.class);
        query.setParameter("nome", nomeLocal);
        return query.getSingleResult();
    }

    @Override
    public Locais findById(Long id) {
        return em.find(Locais.class, id);
    }

    @Override
    public List<Locais> getAll() {
        return em.createQuery("FROM Locais", Locais.class).getResultList();
    }

    @Override
    public void save(Locais obj) {
        EntityTransaction ts = em.getTransaction();
        try {
            ts.begin();
            em.persist(obj);
            ts.commit();
        } catch (RuntimeException e) {
            if (ts.isActive()) {
                ts.rollback();
            }
            throw new RuntimeException("Erro ao salvar local", e);
        } finally {
            JPAUtil.shutdown();
        }
    }

    @Override
    public void delete(Locais obj) {
        EntityTransaction ts = em.getTransaction();
        try {
            ts.begin();
            em.remove(obj);
            ts.commit();
        } catch (RuntimeException e) {
            if (ts.isActive()) {
                ts.rollback();
            }
            throw new RuntimeException("Erro ao deletar local", e);
        } finally {
            JPAUtil.shutdown(); // encerrando conexao com o BD
        }
    }

    @Override
    public void update(Locais obj) {
        EntityTransaction ts = em.getTransaction();
        try   {
            ts.begin();
            em.merge(obj);
            ts.commit();
        } catch (RuntimeException e) {
            if (ts.isActive()) {
                ts.rollback();
            }
            throw new RuntimeException("Erro ao salvar local", e);
        } finally {
            JPAUtil.shutdown(); // encerrando conexao com o BD
        }
    }
}
