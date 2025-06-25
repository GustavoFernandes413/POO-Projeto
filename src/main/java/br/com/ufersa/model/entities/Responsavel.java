package br.com.ufersa.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Responsaveis")
@PrimaryKeyJoinColumn(name = "idPessoa")

public class Responsavel extends Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(nullable = false)
    private String telefone;

    @Override
    public String toString() {
        return super.toString() + "/nTelefone: " + getTelefone();
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if (validarAttrString(telefone)) {
            this.telefone = telefone;
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

    public Responsavel(String nome, String endereco, String telefone) {
        super(nome, endereco);
        setTelefone(telefone);
    }
    public Responsavel() {
    }





}
