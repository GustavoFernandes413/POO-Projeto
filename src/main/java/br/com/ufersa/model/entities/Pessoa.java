package br.com.ufersa.model.entities;

import jakarta.persistence.*;

// Essa entidade sera super classe das classes Cliente e Responsavel e vou
// criar uma unica tabela, Pessoas, que armazenará esses dados de pessoa e terá
// um fator discriminante para descidir se é um Responsavel ou Cliente
@Entity
@Table(name = "Pessoas")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE )
@DiscriminatorColumn(name = "tipo_pessoa", discriminatorType = DiscriminatorType.STRING)

public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String endereco;

    public Pessoa(String nome, String endereco) {
        setNome(nome);
        setEndereco(endereco);
    }
    public Pessoa() {

    }
    @Override
    public String toString() {
        return "Nome: " + getNome() + "/nEndereco: " + getEndereco();
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        if (validarAttrString(endereco)) {
            this.endereco = endereco;
        } else {
            System.out.println("Erro! Não pode estar em branco.");
        }
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        if (validarAttrString(nome)) {
            this.nome = nome;
        } else {
            System.out.println("Erro! Não pode estar em branco.");
        }
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public static boolean validarAttrString(String str) {
        return (!str.isBlank());
    }
}
