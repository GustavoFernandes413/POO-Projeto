package br.com.ufersa.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "Clientes")
@PrimaryKeyJoinColumn(name = "idPessoa")

public class Cliente extends Pessoa {
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

    public void editarCpf(String cpf) {
        if (validarAttrString(cpf)) {
            System.out.println("Edição feita com sucesso");
        } else {
            System.out.println(
                "O atributo a ser editado não pode ser deixado em branco"
            );
        }
    }

    public void editar(String nome, String endereco, String cpf) {
        if (validarEntradaCliente(nome, endereco, cpf)) {
            System.out.println("Editção feita com sucesso");
        } else {
            System.out.println("Nenhum dos valores pode ser deixado em branco");
        }
    }

    public void cadastrar(String nome, String endereco, String cpf) {
        if (validarEntradaCliente(nome, endereco, cpf)) {
            System.out.println("Cadastro feito com sucesso");
        } else {
            System.out.println("Nenhum dos valores pode ser deixado em branco");
        }
    }

    // como a validação será usada mais de uma vez, decidi reaproveitá-la
    public static boolean validarEntradaCliente(
        String nome,
        String endereco,
        String cpf
    ) {
        return (!nome.isBlank() && !endereco.isBlank() && cpf.isBlank());
    }
}
