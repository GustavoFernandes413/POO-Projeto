package br.com.ufersa.model.dao;

import br.com.ufersa.model.entities.Equipamentos;
import br.com.ufersa.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EquipamentosDAOImpl extends crudDAOImpl<Equipamentos> implements EquipamentosDAO {
    private final EntityManager em = JPAUtil.getEntityManagerFactory();


    @Override
    public Equipamentos findByName(Equipamentos equipamentos) {
        String nome = equipamentos.getNome();
        TypedQuery<Equipamentos> query = em.createQuery("SELECT e FROM Equipamentos e WHERE e.nome = :nome", Equipamentos.class);
        query.setParameter("nome", nome);
        return query.getSingleResult();

    }

    @Override
    public List<Equipamentos> getEquipamentosDisponiveis() {
        TypedQuery<Equipamentos> query = em.createQuery("SELECT e FROM Equipamentos e WHERE e.quantidadeEstoque>0", Equipamentos.class);
        return query.getResultList();
    }

    @Override
    public Equipamentos findById(Equipamentos equip) {
        Long id = equip.getId();
        TypedQuery<Equipamentos> query = em.createQuery("SELECT e FROM Equipamentos e WHERE e.id = :id", Equipamentos.class);
        query.setParameter("id", id);
        return query.getResultStream().findFirst().orElse(null);
    }

    @Override
    public List<Equipamentos> getAll() {
        return em.createQuery("FROM Equipamentos", Equipamentos.class).getResultList();
    }
}
