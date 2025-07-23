package br.com.ufersa.model.services;

import br.com.ufersa.model.dao.EquipamentosDAO;
import br.com.ufersa.model.dao.EquipamentosDAOImpl;
import br.com.ufersa.model.entities.Equipamentos;

import java.util.List;

public class EquipamentosServiceImpl implements EquipamentosService{
    private final  EquipamentosDAO equipamentosDAO ;

    public EquipamentosServiceImpl(EquipamentosDAO equipamentosDAO) {
        this.equipamentosDAO = equipamentosDAO;
    }

    @Override
    public void cadastraEquipamento(Equipamentos equip) {
        if (equipamentosDAO.findById(equip.getId()) != null) {
            throw new IllegalArgumentException("Equipameto já existente");
        }
        equipamentosDAO.save(equip);
    }
    // TODO corrigir esse esse metodo para nao passar o inteiro, apenas o objeto
    @Override
    public void comprarEquipamento(Equipamentos equip, int quantidade) {
        equip.setQuantidade(equip.getQuantidade() +  quantidade);
        equipamentosDAO.update(equip);
    }

    @Override
    public void venderEquipamento(Equipamentos equip, int quantidade) {
        equip.setQuantidade(equip.getQuantidade() -  quantidade);
        equipamentosDAO.update(equip);
    }

    // TODO - verificar se essa é a melhor forma de fazer isso
    @Override
    public Equipamentos getEquipamentoById(Long id) {

        return equipamentosDAO.findById(id);
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
