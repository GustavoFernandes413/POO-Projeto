package br.com.ufersa.model.services;

import br.com.ufersa.model.dto.EquipamentosDTOImpl;
import br.com.ufersa.model.entities.Equipamentos;

import java.util.List;

public class EquipamentosServiceImpl implements EquipamentosService{
    private EquipamentosDTOImpl equipamentosDTO = new EquipamentosDTOImpl();
    @Override
    public void cadastraEquipamento(Equipamentos equip) {
        equipamentosDTO.save(equip);
    }

    @Override
    public void comprarEquipamento(Equipamentos equip, int quantidade) {

    }

    @Override
    public void venderEquipamento(Equipamentos equip, int quantidade) {

    }

    @Override
    public Equipamentos getEquipamentoById(Long id) {
        return equipamentosDTO.findById(id);
    }

    @Override
    public List<Equipamentos> getAllEquipamentos() {
        return equipamentosDTO.getAll();
    }

    @Override
    public Equipamentos findByNomeEquipamento(String nome) {
        return equipamentosDTO.findByName(nome);
    }

    @Override
    public void alterarPreco(Equipamentos id) {
        equipamentosDTO.update(id);
    }
}
