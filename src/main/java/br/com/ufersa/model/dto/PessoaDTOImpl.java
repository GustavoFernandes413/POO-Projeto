package br.com.ufersa.model.dto;

import br.com.ufersa.model.entities.Pessoa;
import br.com.ufersa.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class PessoaDTOImpl implements PessoaDTO {

    private final EntityManager em = JPAUtil.getEntityManagerFactory();

    @Override
    public Pessoa findById(Long id) {
        return em.find(Pessoa.class, id);
    }

    @Override
    public List<Pessoa> getAll() {
        return em.createQuery("FROM Pessoa", Pessoa.class).getResultList();
    }

    @Override
    public void save(Pessoa cliente) {
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
    public void update(Pessoa cliente) {
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
    public void delete(Pessoa cliente) {
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
