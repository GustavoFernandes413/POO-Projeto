package br.com.ufersa.model.dao;
import br.com.ufersa.model.entities.ItemVenda;
public interface ItemVendaDAO extends crudDAO<ItemVenda> {
    ItemVenda buscarPorId(ItemVenda item);
}
