package br.com.ufersa.model.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("Responsavel")
public class Responsavel extends Pessoa {
    // adicao de sistema de Login
    @Column(length = 50, nullable = false, unique = true)
    private String login;
    @Column(length = 20, nullable = false)
    private String senha;

    private String telefone;
    @OneToMany( mappedBy = "responsavel",cascade = CascadeType.MERGE) // usa-se o lazy por padrao
    private List<Equipamentos> equipamentos = new ArrayList<>();
    @OneToMany(mappedBy = "responsavel", cascade = CascadeType.MERGE)
    private List<Vendas> vendas = new ArrayList<>();

    @Override
    public String toString() {
        return "Responsavel{" +
                "login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                ", telefone='" + telefone + '\'' +
                ", equipamentos=" + equipamentos +
                ", vendas=" + vendas +
                '}';
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Equipamentos> getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(List<Equipamentos> equipamentos) {
        this.equipamentos = equipamentos;
    }

    public List<Vendas> getVendas() {
        return vendas;
    }

    public void setVendas(List<Vendas> vendas) {
        this.vendas = vendas;
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
