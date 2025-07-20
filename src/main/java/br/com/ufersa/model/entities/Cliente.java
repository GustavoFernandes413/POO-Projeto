package br.com.ufersa.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Clientes")
@DiscriminatorValue("Cliente") // será o valor posto na tabela Pessoa coluna tipo_pessoa
public class Cliente extends Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(nullable = false)
    private String cpf;

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

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

 }
