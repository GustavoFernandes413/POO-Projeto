package main.java.br.com.ufersa.model.entities;

public class Vendas {

    private int codigoVenda;
    private String status;
    private String data;
    private Cliente cliente;
    private Equipamentos equipamento;
    private Locais local;
    private Responsavel responsavel;

    public String toString() {
        return (
            "Venda: " +
            "codigoVenda: " +
            getCodigoVenda() +
            ", status:" +
            getStatus() +
            '\'' +
            ", data: " +
            getData() +
            '\'' +
            ", cliente: " +
            getCliente() +
            ", equipamento: " +
            getEquipamento().toString() +
            ", local: " +
            getLocal().toString() +
            ", responsavel: " +
            getResponsavel().toString() +
            '}'
        );
    }

    public int getCodigoVenda() {
        return codigoVenda;
    }

    public void setCodigoVenda(int codigoVenda) {
        if (validarVendas(codigoVenda)) {
            this.codigoVenda = codigoVenda;
        } else {
            System.out.println("Erro! Não pode ser menor que zero.");
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        if (validarVendas(cliente)) this.cliente = cliente;
        else System.out.println("Erro! Objeto não pode estar indefinido");
    }

    public Equipamentos getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamentos equipamento) {
        if (validarVendas(equipamento)) this.equipamento = equipamento;
        else System.out.println("Erro! Objeto não pode estar indefinido");
    }

    public Locais getLocal() {
        return local;
    }

    public void setLocal(Locais local) {
        if (validarVendas(local)) this.local = local;
        else System.out.println("Erro! Objeto não pode estar indefinido");
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        if (validarVendas(responsavel)) this.responsavel = responsavel;
        else System.out.println("Erro! Objeto não pode estar indefinido");
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (validarVendas(status)) {
            this.status = status;
        } else {
            System.out.println("Erro! Não pode estar em branco.");
        }
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        if (validarVendas(data)) {
            this.data = data;
        } else {
            System.out.println("Erro! Não pode estar em branco.");
        }
    }

    public Vendas() {
        //construtor vazio
    }

    public Vendas(
        int codigoVenda,
        Cliente cliente,
        Equipamentos equipamento,
        Locais local,
        Responsavel responsavel,
        String status,
        String data
    ) {
        setCodigoVenda(codigoVenda);
        setCliente(cliente);
        setEquipamento(equipamento);
        setLocal(local);
        setResponsavel(responsavel);
        setStatus(status);
        setData(data);
    }

    // precisa dar atenção à estrutura a ser utilizada aqui
    public void relatorio(int inicio, int fim) {
        System.out.println("Relatório criado com sucesso!");
    }

    public void notaVenda(
        int codigoVenda,
        Cliente cliente,
        Equipamentos equipamento,
        Locais local,
        Responsavel responsavel,
        String status,
        String data
    ) {
        if (
            validarVendas(codigoVenda) &&
            validarVendas(status) &&
            validarVendas(data)
        ) {
            System.out.println("Nota da venda criada com sucesso!");
        }
    }

    public void cancelamentoVenda(int codigoVenda) {
        if (validarVendas(codigoVenda)) System.out.println(
            "Cancelamento feito com sucesso!"
        );
        else System.out.println("Erro ao cancelar venda!");
    }

    // mesmo método é usado para os tipos Responsavel, Local e Equipamentos, por isso o uso de generics.
    public static <T> boolean validarVendas(T objeto) {
        return (objeto != null);
    }

    public static boolean validarVendas(String str) {
        return (!str.isBlank());
    }

    public static boolean validarVendas(int codigoVenda) {
        return (codigoVenda > 0);
    }
}
