package br.com.ufersa.model.entities;
import br.com.ufersa.model.entities.Locais;
import br.com.ufersa.model.entities.Responsavel;
import jakarta.persistence.*;
// TODO:: usar excessoes dentro dos modificadores de acesso
@Entity
@Table(name = "Equipamentos")
public class Equipamentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "numero_serie")
    private Long numeroSerie;
    @Column(nullable = false, name = "nome")
    private String nome;
    @Column(nullable = false, name = "preco")
    private double preco;
    @Column(nullable = false, name= "quantidade")
    private int quantidade;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "fk_locais")
    private Locais local;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "fk_responsavel")
    private Responsavel responsavel;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (validarEqui(nome)) {
            this.nome = nome;
        } else {
            System.out.println("Erro! Não pode estar em branco.");
        }
    }

    public Long getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(Long numeroSerie) {
        if (validarEquiSerie(numeroSerie)) {
            this.numeroSerie = numeroSerie;
        } else {
            System.out.println("Erro! Não pode ser menor que zero.");
        }
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (validarEqui(preco)) {
            this.preco = preco;
        } else {
            System.out.println("Erro! Não pode ser menor que zero.");
        }
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (validarEqui(quantidade)) {
            this.quantidade = quantidade;
        } else {
            System.out.println("Erro! Não pode ser menor que zero.");
        }
    }

    public Locais getLocal() {
        return local;
    }

    public void setLocal(Locais local) {
        if (validarEqui(local)) {
            this.local = local;
        } else {
            System.out.println("Erro! Não pode estar em branco.");
        }
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        if (validarEqui(responsavel)) {
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
        Long numeroSerie,
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


    // os metodos de validação foram feitos pois estavam sendo chamados muitas vezes, por isso o reaproveitamento.
    public static boolean validarEqui(double preco) {
        return (preco >= 0);
    }

    public static boolean validarEqui(String nome) {
        return (!nome.isBlank());
    }

    public static boolean validarEquiSerie(Long numeroSerie) {
        return (numeroSerie > 0);
    }

    public static boolean validarEqui(int quantidade) {
        return (quantidade >= 0);
    }

    public static <T> boolean validarEqui(T obj) {
        return (obj != null);
    }

    @Override
    public String toString() {
        return (
            "Nome:" +
            nome +
            "/nNumeroSerie:" +
            numeroSerie +
            "/nPreco: " +
            preco +
            "/nLocal:  Nome Casa: " +
            getLocal().toString() +
            "/nResponsavel: Nome: " +
            getResponsavel()
        );
    }


}
