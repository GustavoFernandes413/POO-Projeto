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
    public List<Equipamentos> findByName(Equipamentos equipamentos) {
        String nome = equipamentos.getNome();
        TypedQuery<Equipamentos> query = em.createQuery("SELECT e FROM Equipamentos e WHERE e.nome like :nome", Equipamentos.class);
        query.setParameter("nome", nome + "%");
        return query.getResultList();

    }

    @Override
    public List<Equipamentos> findByResponsavel(Equipamentos equipamentos) {
        String nomeResponavel = equipamentos.getResponsavel().getNome();
        TypedQuery<Equipamentos> query = em.createQuery("SELECT E  from Equipamentos  E Join E.responsavel R WHERE R.nome like :nomeResponsavel ", Equipamentos.class);
        query.setParameter("nomeResponsavel", nomeResponavel + "%");
        return query.getResultList();
    }

    @Override
    public List<Equipamentos> findByLocal(Equipamentos equipamentos) {
        String nomeLocal = equipamentos.getLocal().getNomeCasa();
        TypedQuery<Equipamentos> query = em.createQuery("SELECT E  from Equipamentos  E Join E.local L WHERE L.nomeCasa like :nomeCasa ", Equipamentos.class);
        query.setParameter("nomeCasa", nomeLocal + "%");
        return query.getResultList();
    }

    @Override
    public List<Equipamentos> findByNSerie(Equipamentos equipamentos) {
        String NSerie = equipamentos.getNumeroSerie();
        TypedQuery<Equipamentos> query = em.createQuery("SELECT E  from Equipamentos  E  WHERE E.numeroSerie like :NSerie ", Equipamentos.class);
        query.setParameter("NSerie", NSerie + "%");
        return query.getResultList();
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
