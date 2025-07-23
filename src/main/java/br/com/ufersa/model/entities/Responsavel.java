package br.com.ufersa.model.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("Responsavel")
public class Responsavel extends Pessoa {
    private String telefone;
    @OneToMany( mappedBy = "responsavel",cascade = CascadeType.MERGE) // usa-se o lazy por padrao
    private List<Equipamentos> equipamentos = new ArrayList<>();
    @OneToMany(mappedBy = "responsavel", cascade = CascadeType.MERGE)
    private List<Vendas> vendas = new ArrayList<>();

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



    public Responsavel(String nome, String endereco, String telefone) {
        super(nome, endereco);
        setTelefone(telefone);
    }
    public Responsavel() {
    }





}
