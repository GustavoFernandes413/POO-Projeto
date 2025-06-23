package br.com.ufersa.model.services;

import br.com.ufersa.model.entities.Equipamentos;
import java.util.List;

public interface EquipamentosService {
    void cadastraEquipamento(Equipamentos equip);
    void comprarEquipamento(Equipamentos equip, int quantidade);
    void venderEquipamento(Equipamentos equip, int quantidade);
    Equipamentos getEquipamentoById(Long id);
    List<Equipamentos> getAllEquipamentos();
    Equipamentos findByNomeEquipamento(String nome);
    void alterarPreco(Equipamentos id);
}
