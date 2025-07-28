package br.com.ufersa.model.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    @Column(nullable = false, name = "quantidade_estoque")
    private int quantidadeEstoque;

    // regra: cada Equipamento está associado a um local
    @ManyToOne
    @JoinColumn(name = "fk_locais")
    private Locais local;
    // regra: cada Equipamento possui um único responsavel
    @ManyToOne
    @JoinColumn(name = "fk_responsavel")
    private Responsavel responsavel;

    // Vou descidir se é preciso um relacionamento bidirecional aqui
//    @OneToMany(mappedBy = "equipamento", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
//    private List<ItemVenda> itensDeVenda = new ArrayList<>();


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

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        if (validarEqui(quantidadeEstoque)) {
            this.quantidadeEstoque = quantidadeEstoque;
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
        setQuantidadeEstoque(quantidade);
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
        return  this.getNumeroSerie() +" - "+ this.getNome()+ " - " + this.getQuantidadeEstoque() + " - " + this.getPreco() ;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Equipamentos that = (Equipamentos) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
