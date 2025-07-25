package br.com.ufersa.model.dao;

import br.com.ufersa.model.entities.Cliente;
import br.com.ufersa.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ClienteDAOImpl extends crudDAOImpl<Cliente> implements ClienteDAO {
    // TODO Businnes Exceptions devem ser tratadas na camada de serviços, preciso movê-las daqui

    private final EntityManager em = JPAUtil.getEntityManagerFactory();

    @Override
    public Cliente findByCPF(Cliente cliente) {
        String cpf = cliente.getCpf();
        TypedQuery<Cliente> query = em.createQuery("select c FROM Cliente c WHERE c.cpf=:cpf", Cliente.class);
        query.setParameter("cpf", cpf);
        return query.getResultStream().findFirst().orElse(null);
    }

    @Override
    public Cliente findById(Cliente cliente) {
        Long id = cliente.getId();
        return em.find(Cliente.class, id);
    }


    @Override
    public List<Cliente> getAll() {
        try {
            return em.createQuery("FROM Cliente", Cliente.class).getResultList();
        } catch (NoResultException e) {
            throw new NoResultException("Nenhum Locais encontrado" + e);
        }
    }


}
