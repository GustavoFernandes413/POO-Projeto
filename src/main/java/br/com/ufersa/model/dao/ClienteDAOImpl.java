package br.com.ufersa.model.dao;

import br.com.ufersa.model.entities.Cliente;
import br.com.ufersa.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;

import java.util.List;

public class ClienteDAOImpl implements ClienteDAO {
    // TODO: passar objetos pelas camadas

    private final EntityManager em = JPAUtil.getEntityManagerFactory();

    @Override

    public Cliente findByCPF(Cliente cliente) {
        String cpf =  cliente.getCpf();
        try {
            return em.createQuery("SELECT * FROM Cliente WHERE cpf="+cpf,Cliente.class).getSingleResult();
        } catch (NoResultException e) {
            throw new NoResultException("Nenhum Locais encontrado" + e);
        }
    }
    @Override
    public Cliente findById(Cliente cliente) {
        Long id =  cliente.getId();
        return em.find(Cliente.class, id);}

    @Override
    public List<Cliente> getAll() {
        try{
            return em.createQuery("FROM Cliente", Cliente.class).getResultList();
        }
        catch (NoResultException e) {
            throw new NoResultException("Nenhum Locais encontrado" + e);
        }
    }

    @Override
    public void save(Cliente cliente) {
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
    public void update(Cliente cliente) {
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
    public void delete(Cliente cliente) {
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
