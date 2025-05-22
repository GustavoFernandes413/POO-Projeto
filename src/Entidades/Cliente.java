package Entidades;

public class Cliente {

    private String nome;
    private String endereco;
    private String cpf;

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (!cpf.isBlank()) {
            this.cpf = cpf;
        } else {
            System.out.println("Erro! Não pode estar em branco.");
        }
    }

    public Cliente() {
        //construtor vazio
    }

    public Cliente(String nome, String endereco, String cpf) {
        setNome(nome);
        setEndereco(endereco);
        setCpf(cpf);
    }

    public void editarCpfCliente(String cpf) {
        if (!cpf.isBlank()) {
            System.out.println("Edição feita com sucesso");
        } else {
            System.out.println(
                "O atributo a ser editado não pode ser deixado em branco"
            );
        }
    }

    public void editarEndCliente(String endereco) {
        if (!endereco.isBlank()) {
            System.out.println("Edição feita com sucesso");
        } else {
            System.out.println(
                "O atributo a ser editado não pode ser deixado em branco"
            );
        }
    }

    public void editarNomeCliente(String nome) {
        if (!nome.isBlank()) {
            System.out.println("Edição feita com sucesso");
        } else {
            System.out.println(
                "O atributo a ser editado não pode ser deixado em branco"
            );
        }
    }

    public void editarCliente(String nome, String endereco, String cpf) {
        if (validarEntradaCliente(nome, endereco, cpf)) {
            System.out.println("Editção feita com sucesso");
        } else {
            System.out.println("Nenhum dos valores pode ser deixado em branco");
        }
    }

    public void cadastrarCliente(String nome, String endereco, String cpf) {
        if (validarEntradaCliente(nome, endereco, cpf)) {
            System.out.println("Cadastro feito com sucesso");
        } else {
            System.out.println("Nenhum dos valores pode ser deixado em branco");
        }
    }

    // como a validação será usada mais de uma vez, decidi reaproveitá-la
    public static boolean validarEntradaCliente(
        String nome,
        String endereco,
        String cpf
    ) {
        if (!nome.isBlank() && !endereco.isBlank() && cpf.isBlank()) {
            return true;
        } else {
            return false;
        }
    }
}
