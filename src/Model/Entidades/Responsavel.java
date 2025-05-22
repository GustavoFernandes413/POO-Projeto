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

    public void cadastrar(String nome, String endereco, String telefone) {
        if (validarResponsavel(nome, endereco, telefone)) System.out.println(
            "Responsável cadastrado com sucesso!"
        );
    }

    public void editarNome(String nome) {
        if (!nome.isBlank()) System.out.println(
            "Nome do responsável editado com sucesso!"
        );
        else System.out.println(
            "O atributo a ser editado não pode ser deixado em branco!"
        );
    }

    public void editarTel(String telefone) {
        if (!telefone.isBlank()) System.out.println(
            "Telefone do responsável editado com sucesso!"
        );
        else System.out.println(
            "O atributo a ser editado não pode ser deixado em branco!"
        );
    }

    public void editarEnd(String endereco) {
        if (!endereco.isBlank()) System.out.println(
            "Endereço do responsável editado com sucesso!"
        );
        else System.out.println(
            "O atributo a ser editado não pode ser deixado em branco!"
        );
    }

    public void editar(String nome, String endereco, String telefone) {
        if (validarResponsavel(nome, endereco, telefone)) System.out.println(
            "Responsável editado com sucesso!"
        );
        else System.out.println(
            "O atributo a ser editado não pode ser deixado em branco!"
        );
    }

    public static boolean validarResponsavel(
        String nome,
        String endereco,
        String telefone
    ) {
        if (
            !nome.isBlank() && !endereco.isBlank() && !telefone.isBlank()
        ) return true;
        else return false;
    }
}
