package br.com.ufersa.model.services;

import br.com.ufersa.model.entities.Equipamentos;
import java.util.List;

public interface EquipamentosService {
    void cadastraEquipamento(Equipamentos equip);
    Equipamentos getEquipamentoById(Equipamentos equip);
    List<Equipamentos> getAllEquipamentos();
    Equipamentos findByNomeEquipamento(Equipamentos equipamentos);
    void alterarPreco(Equipamentos id);
}
