package br.com.ufersa.model.dao;

import br.com.ufersa.model.entities.Equipamentos;
import br.com.ufersa.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EquipamentosDAOImpl implements EquipamentosDAO {
    private final EntityManager em = JPAUtil.getEntityManagerFactory();


    @Override
    public Equipamentos findByName(Equipamentos equipamentos) {
        String nome = equipamentos.getNome();
        TypedQuery<Equipamentos> query = em.createQuery("SELECT e FROM Equipamento e WHERE e.nome = :nome", Equipamentos.class);
        query.setParameter("nome", nomeEquipamentos);
        return query.getSingleResult();

    }

    @Override
    public Equipamentos findById(Long id) {
        return em.find(Equipamentos.class, id);
    }

    @Override
    public List<Equipamentos> getAll() {
        return em.createQuery("FROM Equipamentos", Equipamentos.class).getResultList();
    }

    @Override
    public void save(Equipamentos obj) {
        EntityTransaction ts = em.getTransaction();
        try {
            ts.begin();
            em.persist(obj);
            ts.commit();
        } catch (RuntimeException e) {
            if (ts.isActive()) {
                ts.rollback();
            }
            throw new RuntimeException("Erro ao salvar equipamento", e);
        } finally {
            JPAUtil.shutdown();
        }
    }

    @Override
    public void delete(Equipamentos obj) {
        EntityTransaction ts = em.getTransaction();
        try {
            ts.begin();
            em.remove(obj);
            ts.commit();
        } catch (RuntimeException e) {
            if (ts.isActive()) {
                ts.rollback();
            }
            throw new RuntimeException("Erro ao deletar equipamento", e);
        } finally {
            JPAUtil.shutdown(); // encerrando conexao com o BD
        }
    }

    @Override
    public void update(Equipamentos obj) {
        EntityTransaction ts = em.getTransaction();
        try {
            ts.begin();
            em.merge(obj);
            ts.commit();
        } catch (RuntimeException e) {
            if (ts.isActive()) {
                ts.rollback();
            }
            throw new RuntimeException("Erro ao salvar equipamento", e);
        } finally {
            JPAUtil.shutdown(); // encerrando conexao com o BD
        }
    }
}
