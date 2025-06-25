package br.com.ufersa.model.dao;

import br.com.ufersa.model.entities.Cliente;
import br.com.ufersa.model.entities.Locais;
import br.com.ufersa.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class LocaisDAOImpl implements LocaisDAO {
    private final EntityManager em = JPAUtil.getEntityManagerFactory();

    @Override
    public Locais findByName(Locais locais) {
        String nomeLocal = locais.getNomeCasa();
        try{
            return em.createQuery(" FROM Locais WHERE nomeCasa=" + nomeLocal,Locais.class).getSingleResult();

        }catch (NoResultException e){
            throw  new NoResultException("Nenhum Locais encontrado"+e);
        }
    }

    @Override
    public Locais findById(Locais locais) {
        Long id = locais.getId();
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
