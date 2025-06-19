package main.java.br.com.ufersa.model.entities;

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
        if (validarEqui(nome)) {
            this.nome = nome;
        } else {
            System.out.println("Erro! Não pode estar em branco.");
        }
    }

    public int getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(int numeroSerie) {
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

    // métodos para vender e comprar equipamentos
    public void comprar(int numeroSerie, int quantidade) {}

    // métodos para pesquisar equipamentos
    public void pesquisar(Responsavel responsavel) {
        if (validarEqui(responsavel)) System.out.println(
            "Pesquisa pelo equipamento feita com sucesso!"
        );
        else System.out.println(
            "Dado para pesquisa do equipamento não pode ser deixado em branco!"
        );
    }

    public void pesquisar(double preco) { // pode ser que, no futuro, seja melhor mudar esse metodo para pesquisar em um faixa de valores
        if (validarEqui(preco)) System.out.println(
            "Pesquisa pelo equipamento feita com sucesso!"
        );
        else System.out.println(
            "Dado para pesquisa do equipamento não pode ser deixado em branco ou menor que zero!"
    }

    public void pesquisar(String nome) {
        if (validarEqui(nome)) System.out.println(
            "Pesquisa pelo equipamento feita com sucesso!"
        );
        else System.out.println(
            "Dado para pesquisa do equipamento não pode ser deixado em branco!"
        );
    }

    public void pesquisar(int numSerie) {
        if (numSerie > 0) System.out.println(
            "Pesquisa pelo equipamento feita com sucesso!"
        );
        else System.out.println(
            "Dado para pesquisa do equipamento não pode ser deixado em branco ou menor que zero!"
        );
    }

    // métodos para editar Equipamentos
    public void editar(int numeroSerie) {
        if (validarEquiSerie(numeroSerie)) System.out.println(
            "Numero de série do equipamento alterado com sucesso!"
        );
        else System.out.println(
            "Numero de série do equipamento não pode ser deixado em branco ou menor que zero!"
        );
    }

    public void editar(Responsavel responsavel) {
        if (validarEqui(responsavel)) System.out.println(
            "Responsavel pelo equipamento alterado com sucesso!"
        );
        else System.out.println(
            "Responsavel pelo equipamento não pode ser deixado em branco ou menor que zero!"
        );
    }

    public void editar(Locais local) {
        if (validarEqui(local)) System.out.println(
            "Local do equipamento alterado com sucesso!"
        );
        else System.out.println(
            "Local do equipamento não pode ser deixado em branco ou menor que zero!"
        );
    }

    public void editarQtd(int quantidade) {
        if (validarEqui(quantidade)) System.out.println(
            "Quantidade do equipamento alterado com sucesso!"
        );
        else System.out.println(
            "Quantidade do equipamento não pode ser deixado em branco ou menor que zero!"
        );
    }

    public void editar(double preco) {
        if (validarEqui(preco)) System.out.println(
            "Preço do equipamento alterado com sucesso!"
        );
        else System.out.println(
            "Preço do equipamento não pode ser deixado em branco ou menor que zero!"
        );
    }

    public void editar(String nome) {
        if (validarEqui(nome)) System.out.println(
            "Nome do equipamento alterado com sucesso!"
        );
        else System.out.println(
            "o nome da casa não pode ser deixado em branco!"
        );
    }

    public void editar(
        String nome,
        int numeroSerie,
        double preco,
        int quantidade,
        Locais local,
        Responsavel responsavel
    ) {
        if (
            validarEqui(
                nome,
                numeroSerie,
                preco,
                quantidade,
                local,
                responsavel
            )
        ) System.out.println("Equipamento editado com sucesso!");
        else System.out.println("Faltam dados para a edição!");
    }

    public void cadastrar(
        String nome,
        int numeroSerie,
        double preco,
        int quantidade,
        Locais local,
        Responsavel responsavel
    ) {
        if (
            validarEqui(
                nome,
                numeroSerie,
                preco,
                quantidade,
                local,
                responsavel
            )
        ) System.out.println("Equipamento criado com sucesso!");
        else System.out.println("Faltam dados para o cadastro!");
    }

    // os metodos de validação foram feitos pois estavam sendo chamados muitas vezes, por isso o reaproveitamento.
    public static boolean validarEqui(double preco) {
        return (preco >= 0);
    }

    public static boolean validarEqui(String nome) {
        return (!nome.isBlank());
    }

    public static boolean validarEquiSerie(int numeroSerie) {
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
            getResponsavel().toString()
        );
    }

    public static boolean validarEqui(
        String nome,
        int numeroSerie,
        double preco,
        int quantidade,
        Locais local,
        Responsavel responsavel
    ) {
        return (
            validarEqui(nome) &&
            validarEquiSerie(numeroSerie) &&
            validarEqui(preco) &&
            validarEqui(quantidade) &&
            validarEqui(local) &&
            validarEqui(responsavel)
        );
    }
}
