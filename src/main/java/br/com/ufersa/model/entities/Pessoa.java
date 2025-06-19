package br.com.ufersa.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Pessoas")
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPessoa")
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

    public void editarEnd(String endereco) {
        if (validarAttrString(endereco)) {
            System.out.println("Edição feita com sucesso");
        } else {
            System.out.println(
                "O atributo a ser editado não pode ser deixado em branco"
            );
        }
    }

    public void editarNome(String nome) {
        if (validarAttrString(nome)) {
            System.out.println("Edição feita com sucesso");
        } else {
            System.out.println(
                "O atributo a ser editado não pode ser deixado em branco"
            );
        }
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

    public static boolean validarAttrString(String str) {
        return (!str.isBlank());
    }
}
