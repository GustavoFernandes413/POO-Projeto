package Entidades;

public class Equipamentos {

    private String nome;
    private int numeroSerie;
    private double preco;
    private int quantidade;
    private Locais local;
    private Responsavel responsavel;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (!nome.isBlank()) {
            this.nome = nome;
        } else {
            System.out.println("Erro! Não pode estar em branco.");
        }
    }

    public int getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(int numeroSerie) {
        if (numeroSerie > 0) {
            this.numeroSerie = numeroSerie;
        } else {
            System.out.println("Erro! Não pode ser menor que zero.");
        }
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco > 0) {
            this.preco = preco;
        } else {
            System.out.println("Erro! Não pode ser menor que zero.");
        }
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade >= 0) {
            this.quantidade = quantidade;
        } else {
            System.out.println("Erro! Não pode ser menor que zero.");
        }
    }

    public Locais getLocal() {
        return local;
    }

    public void setLocal(Locais local) {
        if (local != null) {
            this.local = local;
        } else {
            System.out.println("Erro! Não pode estar em branco.");
        }
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        if (responsavel != null) {
            this.responsavel = responsavel;
        } else {
            System.out.println("Erro! Não pode estar em branco.");
        }
    }

    public Equipamentos() {
        //construtor vazio
    }

    public Equipamentos(
        String nome,
        int numeroSerie,
        double preco,
        int quantidade,
        Locais local,
        Responsavel responsavel
    ) {
        setNome(nome);
        setNumeroSerie(numeroSerie);
        setPreco(preco);
        setQuantidade(quantidade);
        setLocal(local);
        setResponsavel(responsavel);
    }
}
