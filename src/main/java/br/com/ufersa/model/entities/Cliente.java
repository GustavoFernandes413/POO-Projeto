package br.com.ufersa.model.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@DiscriminatorValue("Cliente") // será o valor posto na tabela Pessoa coluna tipo_pessoa
public class Cliente extends Pessoa {
    @Column(length = 50, unique = true, updatable = false)
    private String cpf;
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.MERGE)
    private List<Vendas> vendas = new ArrayList<>();

    @Override
    public String toString() {
        return super.toString() + "/nCPF: " + getCpf();
    }

    public Cliente(String nome, String endereco, String cpf) {
        super(nome, endereco);
        setCpf(cpf);
    }

    public Cliente() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (validarAttrString(cpf)) {
            this.cpf = cpf;
        } else {
            System.out.println("Erro! Não pode estar em branco.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(cpf, cliente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cpf);
    }
}
