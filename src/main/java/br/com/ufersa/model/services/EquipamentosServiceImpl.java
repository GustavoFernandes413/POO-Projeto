package br.com.ufersa.model.services;

import br.com.ufersa.model.dao.EquipamentosDAO;
import br.com.ufersa.model.dao.EquipamentosDAOImpl;
import br.com.ufersa.model.entities.Equipamentos;
import br.com.ufersa.model.entities.ItemVenda;
import br.com.ufersa.model.entities.Vendas;

import java.util.List;

public class EquipamentosServiceImpl implements EquipamentosService,  ObserverVendas  {
    private final  EquipamentosDAO equipamentosDAO ;

    public EquipamentosServiceImpl(EquipamentosDAO equipamentosDAO) {
        this.equipamentosDAO = equipamentosDAO;
    }

    @Override
    public void onVendaProcessada(Vendas venda) {
        for (ItemVenda item : venda.getItens()){
            Equipamentos equipamentos = item.getEquipamento();
            int quantidade = item.getQuantidade();

            Equipamentos equipamento = equipamentosDAO.findById(equipamentos);

            equipamento.setQuantidadeEstoque(equipamento.getQuantidadeEstoque() - quantidade);
            equipamentosDAO.update(equipamento);
        }
    }

    @Override
    public void onVendaCancelada(Vendas venda) {
        for (ItemVenda item : venda.getItens()){
            Equipamentos equipamentos = item.getEquipamento();
            int quantidade = item.getQuantidade();

            Equipamentos equipamento = equipamentosDAO.findById(equipamentos);

            equipamento.setQuantidadeEstoque(equipamento.getQuantidadeEstoque() + quantidade);
            equipamentosDAO.update(equipamento);
        }
    }

    @Override
    public void cadastraEquipamento(Equipamentos equip) {
        if (equipamentosDAO.findById(equip) != null) {
            throw new IllegalArgumentException("Equipameto já existente");
        }
        equipamentosDAO.save(equip);
    }

    // TODO - mudar de Id para Equipamentos
    @Override
    public Equipamentos getEquipamentoById(Equipamentos equip) {
        return equipamentosDAO.findById(equip);
    }

    @Override
    public List<Equipamentos> getAllEquipamentos() {
        return equipamentosDAO.getAll();
    }

    @Override
    public Equipamentos findByNomeEquipamento(Equipamentos equipamentos) {
        return equipamentosDAO.findByName(equipamentos);
    }

    @Override
    public void alterarPreco(Equipamentos id) {
        equipamentosDAO.update(id);
    }
}
