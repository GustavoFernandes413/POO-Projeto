package br.com.ufersa.model.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Vendas")
public class Vendas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cod_venda")
    private Long codigoVenda;
    @Enumerated(EnumType.STRING)
    private StatusCompra status;
    @Column(name = "data")
    private Timestamp data;

    // regra: uma venda pertence a um único cliente
    @ManyToOne
    @JoinColumn(name = "fk_cliente")
    private Cliente cliente;

    // regra: uma venda possui múltiplos itens
    @OneToMany(mappedBy = "venda", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<ItemVenda> itens = new ArrayList<>();

    // regra: uma venda pertence a um único responsável
    @ManyToOne
    @JoinColumn(name = "fk_responsavel")
    private Responsavel responsavel;

    // metodos para garantir integridade bidirecional
    public void addItem(ItemVenda item) {
        if (item != null) {
            this.itens.add(item);
            item.setVenda(this); // Garante a ligação bidirecional
        }
    }

    public void removeItem(ItemVenda item) {
        if (item != null) {
            this.itens.remove(item);
            item.setVenda(null); // Remove a ligação bidirecional
        }
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCodigoVenda() {
        return codigoVenda;
    }

    public void setCodigoVenda(Long codigoVenda) {
        if (validarVendas(codigoVenda)) {
            this.codigoVenda = codigoVenda;
        } else {
            System.out.println("Erro! Não pode ser menor que zero.");
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        if (validarVendas(responsavel)) this.responsavel = responsavel;
        else System.out.println("Erro! Objeto não pode estar indefinido");
    }

    public StatusCompra getStatus() {
        return status;
    }

    public void setStatus(StatusCompra status) {
        if (validarVendas(status)) {
            this.status = status;
        } else {
            System.out.println("Erro! Não Status pode estar em branco.");
        }
    }


    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        if (validarVendas(data)) {
            this.data = data;
        } else {
            System.out.println("Erro! Não pode estar em branco.");
        }
    }

    public Vendas() {
        //construtor vazio
    }


    // mesmo método é usado para os tipos Responsavel, Local e Equipamentos, por isso o uso de generics.
    public static <T> boolean validarVendas(T objeto) {
        return (objeto != null);
    }

    public static boolean validarVendas(String str) {
        return (!str.isBlank());
    }

    public static boolean validarVendas(Long codigoVenda) {
        return (codigoVenda > 0);
    }

    public String toString() {
        return (
                "Venda: " +
                        "codigoVenda: " +
                        getCodigoVenda() +
                        ", status:" +
                        getStatus() +
                        '\'' +
                        ", data: " +
                        getData() +
                        '\'' +
                        ", cliente: " +
                        getCliente() +
                        ", responsavel: " +
                        getResponsavel().toString() +
                        '}'
        );


    }
    // Aplicacao do patter builder: motivação objeto Vendas é bastante complexo e exige vários argumentos no construtor

    Vendas(Builder builder) {
        this.codigoVenda = builder.codigoVenda;
        this.cliente = builder.cliente;
        this.responsavel = builder.responsavel;
        this.status = builder.status;
        this.data = builder.data;
        this.itens = builder.itens;
    }

    public static class Builder {
        private Long codigoVenda;
        private StatusCompra status;
        private Timestamp data;

        private Cliente cliente;

        private List<ItemVenda> itens = new ArrayList<>();

        private Responsavel responsavel;

        public Builder codigoVenda(Long codigoVenda) {
            this.codigoVenda = codigoVenda;
            return this;
        }

        public Builder status(StatusCompra status) {
            this.status = status;
            return this;
        }

        public Builder data(Timestamp data) {
            this.data = data;
            return this;
        }

        public Builder cliente(Cliente cliente) {
            this.cliente = cliente;
            return this;
        }

        public Builder responsavel(Responsavel responsavel) {
            this.responsavel = responsavel;
            return this;
        }

        public Builder addItem(ItemVenda item) {
            this.itens.add(item);
            return this;
        }

        public Vendas build() {
            return new Vendas(this);
        }
    }
}
