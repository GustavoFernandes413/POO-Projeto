package br.com.ufersa.model.dto;

import br.com.ufersa.model.entities.Cliente;
import br.com.ufersa.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class ClienteImpl implements ClienteDTO {

    private final EntityManager em = JPAUtil.getEntityManagerFactory();

    @Override
    public Cliente findByCPF(Long cpf) {
        return em.find(Cliente.class, cpf);
    }

    @Override
    public Cliente findById(Long id) {
        return em.find(Cliente.class, id);
    }

    @Override
    public List<Cliente> getAll() {
        return em.createQuery("FROM Cliente", Cliente.class).getResultList();
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
