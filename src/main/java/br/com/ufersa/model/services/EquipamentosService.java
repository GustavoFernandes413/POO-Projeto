package br.com.ufersa.model.services;

import br.com.ufersa.model.entities.Equipamentos;
import java.util.List;

public interface EquipamentosService {
    void cadastraEquipamento(Equipamentos equip);
    void editarEquipamento(Equipamentos equip);
    Equipamentos getEquipamentoById(Equipamentos equip);
    List<Equipamentos> getAllEquipamentos();
    void alterarPreco(Equipamentos id);
    List<Equipamentos> getAllEquipamentosDisponiveis();
    List<Equipamentos> findByResponsavel(Equipamentos equipamentos);
    List<Equipamentos> findByLocal(Equipamentos equipamentos);
    List<Equipamentos> findByNSerie(Equipamentos equipamentos);
    List<Equipamentos> findByNome(Equipamentos equipamentos);

}
