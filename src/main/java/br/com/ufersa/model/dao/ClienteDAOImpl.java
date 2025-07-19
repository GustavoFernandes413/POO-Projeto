package br.com.ufersa.model.dao;

import br.com.ufersa.model.entities.Cliente;
import br.com.ufersa.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;

import java.util.List;

public class ClienteDAOImpl extends crudDAOImpl<Cliente> implements ClienteDAO {
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
    public Cliente findById(Long id) {
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





}
