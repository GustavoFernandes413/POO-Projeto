package br.com.ufersa.model.dao;

import br.com.ufersa.util.JPAUtil;
import br.com.ufersa.model.entities.ItemVenda;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class ItemVendaDAOImpl extends crudDAOImpl<ItemVenda> implements ItemVendaDAO {
    private final EntityManager em = JPAUtil.getEntityManagerFactory();

    @Override
    public ItemVenda buscarPorId(ItemVenda item) {
        Long id = item.getId();
        TypedQuery <ItemVenda> query = em.createQuery("select it from ItemVenda it where it.id = :id", ItemVenda.class);
        query.setParameter("id", id);
        return query.getResultStream().findFirst().orElse(null);
    }
}
