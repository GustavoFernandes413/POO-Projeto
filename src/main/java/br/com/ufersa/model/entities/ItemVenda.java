package br.com.ufersa.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "ItemVenda")
public class ItemVenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // regra: cada item está associado a uma única venda
    @ManyToOne
    @JoinColumn(name = "fk_venda")
    private Vendas venda;
    // regra: cada ItemVenda possui apena um equipamento associado
    @ManyToOne
    @JoinColumn(name = "fk_equipamento")
    private Equipamentos equipamento;

    @Column(name = "quantidade", nullable = false)
    private int quantidade;

    public ItemVenda(Equipamentos equipamento, int quantidade) {
        this.equipamento = equipamento;
        this.quantidade = quantidade;
    }

    public ItemVenda() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vendas getVenda() {
        return venda;
    }

    public void setVenda(Vendas venda) {
        this.venda = venda;
    }

    public Equipamentos getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamentos equipamento) {
        this.equipamento = equipamento;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
