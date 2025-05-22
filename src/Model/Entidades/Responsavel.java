package Entidades;

public class Responsavel {

    private String nome;
    private String endereco;
    private String telefone;

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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        if (!endereco.isBlank()) {
            this.endereco = endereco;
        } else {
            System.out.println("Erro! Não pode estar em branco.");
        }
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if (!telefone.isBlank()) {
            this.telefone = telefone;
        } else {
            System.out.println("Erro! Não pode estar em branco.");
        }
    }

    public Responsavel() {
        //construtor vazio
    }

    public Responsavel(String nome, String endereco, String telefone) {
        setNome(nome);
        setEndereco(endereco);
        setTelefone(telefone);
    }
}
