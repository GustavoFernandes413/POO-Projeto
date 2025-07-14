package br.com.ufersa.model.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "Vendas")
public class Vendas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cod_venda")
    private Long codigoVenda;
    @Column(name = "status", nullable = false)
    private String status;
    @Column(name = "data")
    private Timestamp data;
    @OneToOne(cascade =  CascadeType.ALL)
    @JoinColumn(name= "fk_cliente")
    private Cliente cliente;
    @OneToOne(cascade =  CascadeType.ALL)
    @JoinColumn(name = "fk_equipamentos")
    private Equipamentos equipamento;
    @OneToOne(cascade =  CascadeType.ALL)
    @JoinColumn(name = "fk_locais")
    private Locais local;
    @OneToOne(cascade =  CascadeType.ALL)
    @JoinColumn(name="fk_responsavel")
    private Responsavel responsavel;

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
        if (validarVendas(cliente)) this.cliente = cliente;
        else System.out.println("Erro! Objeto não pode estar indefinido");
    }

    public Equipamentos getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamentos equipamento) {
        if (validarVendas(equipamento)) this.equipamento = equipamento;
        else System.out.println("Erro! Objeto não pode estar indefinido");
    }

    public Locais getLocal() {
        return local;
    }

    public void setLocal(Locais local) {
        if (validarVendas(local)) this.local = local;
        else System.out.println("Erro! Objeto não pode estar indefinido");
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        if (validarVendas(responsavel)) this.responsavel = responsavel;
        else System.out.println("Erro! Objeto não pode estar indefinido");
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (validarVendas(status)) {
            this.status = status;
        } else {
            System.out.println("Erro! Não pode estar em branco.");
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

    public Vendas(
        Long codigoVenda,
        Cliente cliente,
        Equipamentos equipamento,
        Locais local,
        Responsavel responsavel,
        String status,
        Timestamp data
    ) {
        setCodigoVenda(codigoVenda);
        setCliente(cliente);
        setEquipamento(equipamento);
        setLocal(local);
        setResponsavel(responsavel);
        setStatus(status);
        setData(data);
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
                        ", equipamento: " +
                        getEquipamento().toString() +
                        ", local: " +
                        getLocal().toString() +
                        ", responsavel: " +
                        getResponsavel().toString() +
                        '}'
        );
    }
}
