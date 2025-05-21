package Entidades;

public class Locais {
    private String nomeCasa;
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
}