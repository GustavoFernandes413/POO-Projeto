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
    @Override
    public String toString() {
        return (
                "Nome da Casa: " +
                        getNomeCasa() +
                        "Compartimento: " +
                        getNomeCompartimento()
        );
    }
}
