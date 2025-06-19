package br.com.ufersa.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Responsaveis")
@PrimaryKeyJoinColumn(name = "idPessoa")

public class Responsavel extends Pessoa {
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

    public Responsavel(String nome, String endereco, String telefone) {
        super(nome, endereco);
        setTelefone(telefone);
    }
    public Responsavel() {
    }

    public void cadastrar(String nome, String endereco, String telefone) {
        if (validarResponsavel(nome, endereco, telefone)) System.out.println(
            "Responsável cadastrado com sucesso!"
        );
    }

    public void editarTel(String telefone) {
        if (validarAttrString(telefone)) System.out.println(
            "Telefone do responsável editado com sucesso!"
        );
        else System.out.println(
            "O atributo a ser editado não pode ser deixado em branco!"
        );
    }

    public void editar(String nome, String endereco, String telefone) {
        if (validarResponsavel(nome, endereco, telefone)) System.out.println(
            "Responsável editado com sucesso!"
        );
        else System.out.println(
            "O atributo a ser editado não pode ser deixado em branco!"
        );
    }

    public static boolean validarResponsavel(
        String nome,
        String endereco,
        String telefone
    ) {
        return (!nome.isBlank() && !endereco.isBlank() && !telefone.isBlank());
    }
}
