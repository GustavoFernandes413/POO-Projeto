package br.com.ufersa.model.services;

import br.com.ufersa.model.dao.ItemVendaDAO;
import br.com.ufersa.model.entities.ItemVenda;

public class ItemVendaServiceImpl implements ItemVendaService {
    private final ItemVendaDAO itemVendaDAO;

    public ItemVendaServiceImpl(ItemVendaDAO itemVendaDAO) {
        this.itemVendaDAO = itemVendaDAO;
    }

    @Override
    public ItemVenda buscarPorId(ItemVenda item){
        return itemVendaDAO.buscarPorId(item);
    }
}
