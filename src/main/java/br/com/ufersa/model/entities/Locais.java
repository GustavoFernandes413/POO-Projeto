package br.com.ufersa.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Locais")
public class Locais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nomeCasa")
    private String nomeCasa;
    @Column(name = "nomeCompartimento")
    private String nomeCompartimento;

    @Override
    public String toString() {
        return (
            "Nome da Casa: " +
            getNomeCasa() +
            "Compartimento: " +
            getNomeCompartimento()
        );
    }

    public String getNomeCasa() {
        return nomeCasa;
    }

    public void setNomeCasa(String nomeCasa) {
        if (!nomeCasa.isBlank()) {
            this.nomeCasa = nomeCasa;
        } else {
            System.out.println("Erro! Não pode estar em branco.");
        }
    }

    public String getNomeCompartimento() {
        return nomeCompartimento;
    }

    public void setNomeCompartimento(String nomeCompartimento) {
        if (!nomeCompartimento.isBlank()) {
            this.nomeCompartimento = nomeCompartimento;
        } else {
            System.out.println("Erro! Não pode estar em branco.");
        }
    }

    public Locais() {
        //construtor vazio
    }

    public Locais(String nomeCompartimento, String nomeCasa) {
        setNomeCompartimento(nomeCompartimento);
        setNomeCasa(nomeCasa);
    }

    public void editarCompartimento(String nomeCompartimento) {
        if (!nomeCompartimento.isBlank()) System.out.println(
            "Cadastro feito com sucesso"
        );
        else System.out.println(
            "O nome do compartimento da casa não pode ser deixado em branco"
        );
    }

    public void editarCasa(String nomeCasa) {
        if (!nomeCasa.isBlank()) System.out.println(
            "Cadastro feito com sucesso"
        );
        else System.out.println("O nome casa não pode ser deixado em branco");
    }

    public void editar(String nomeCompartimento, String nomeCasa) {
        if (validarLocais(nomeCompartimento, nomeCasa)) System.out.println(
            "Cadastro feito com sucesso"
        );
        else System.out.println(
            "Nenhum dos valores pode ser deixado em branco"
        );
    }

    public void cadastrar(String nomeCompartimento, String nomeCasa) {
        if (validarLocais(nomeCompartimento, nomeCasa)) System.out.println(
            "Cadastro feito com sucesso"
        );
        else System.out.println(
            "Nenhum dos valores pode ser deixado em branco"
        );
    }

    public static boolean validarLocais(
        String nomeCompartimento,
        String nomeCasa
    ) {
        return (!nomeCasa.isBlank() && !nomeCompartimento.isBlank());
    }
}
