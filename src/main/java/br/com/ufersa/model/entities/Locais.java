package br.com.ufersa.model.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Locais",  uniqueConstraints = {
        @UniqueConstraint(columnNames = {"nomeCasa", "nomeCompartimento"})
})

public class Locais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nomeCasa")
    private String nomeCasa;
    @Column(name = "nomeCompartimento")
    private String nomeCompartimento;
    @OneToMany(mappedBy = "local",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Equipamentos> equipamentos = new ArrayList<>();

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return  this.getNomeCasa() + "," +this.getNomeCompartimento();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Locais locais = (Locais) o;
        return Objects.equals(id, locais.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

