package br.com.ufersa.model.dao;

import br.com.ufersa.model.entities.Pessoa;
import br.com.ufersa.model.entities.Vendas;
import br.com.ufersa.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.sql.Timestamp;
import java.util.List;

public class VendasDAOImpl extends crudDAOImpl<Vendas> implements VendasDAO {

    private final EntityManager em = JPAUtil.getEntityManagerFactory();

    @Override
    public List<Vendas> relatorio(Vendas vendaInicio, Vendas vendaFim) {
        Timestamp dataInicio = vendaInicio.getData();
        Timestamp dataFim = vendaFim.getData();
        try {

            TypedQuery<Vendas> query =  em.createQuery(
                    " FROM Vendas WHERE data BETWEEN :dataInicio AND  :dataFim",
                    Vendas.class
            ).setParameter("dataInicio", dataInicio).setParameter("dataFim", dataFim);
             return  query.getResultList();

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(
                    "Argumento passado é invalido ",
                    e
            );
        }
    }

    @Override
    public Vendas findById(Vendas vendas) {
        Long id = vendas.getId();
        try {
            return em.find(Vendas.class, id);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Valor passado é incorreto" + e);
        }
    }

    @Override
    public List<Vendas> getAll() {
        return em.createQuery("FROM Vendas", Vendas.class).getResultList();
    }
}
