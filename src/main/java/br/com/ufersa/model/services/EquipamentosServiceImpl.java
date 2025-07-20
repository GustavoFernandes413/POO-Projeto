package br.com.ufersa.model.services;

import br.com.ufersa.model.dao.EquipamentosDAOImpl;
import br.com.ufersa.model.entities.Equipamentos;

import java.util.List;

public class EquipamentosServiceImpl implements EquipamentosService{
    private EquipamentosDAOImpl equipamentosDTO = new EquipamentosDAOImpl();
    @Override
    public void cadastraEquipamento(Equipamentos equip) {
        equipamentosDTO.save(equip);
    }

    @Override
    public void comprarEquipamento(Equipamentos equip, int quantidade) {
        equip.setQuantidade(equip.getQuantidade() +  quantidade);
        equipamentosDTO.update(equip);
    }

    @Override
    public void venderEquipamento(Equipamentos equip, int quantidade) {
        equip.setQuantidade(equip.getQuantidade() -  quantidade);
        equipamentosDTO.update(equip);
    }

    // TODO - verificar se essa é a melhor forma de fazer isso
    @Override
    public Equipamentos getEquipamentoById(Long id) {
        return equipamentosDTO.findById(id);
    }

    @Override
    public List<Equipamentos> getAllEquipamentos() {
        return equipamentosDTO.getAll();
    }

    @Override
    public Equipamentos findByNomeEquipamento(Equipamentos equipamentos) {
        return equipamentosDTO.findByName(equipamentos);
    }

    @Override
    public void alterarPreco(Equipamentos id) {
        equipamentosDTO.update(id);
    }
}
