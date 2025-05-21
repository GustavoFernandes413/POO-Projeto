package Entidades;

public class Vendas {
    private int codigoVenda;
    private Cliente cliente;
    private Equipamentos equipamento;
    private Locais local;
    private Responsavel responsavel;
    private String status;
    private String data;

    public int getCodigoVenda() {
        return codigoVenda;
    }

    public void setCodigoVenda(int codigoVenda) {
        if (codigoVenda > 0) {
            this.codigoVenda = codigoVenda;
        } else {
            System.out.println("Erro! Não pode ser menor que zero.");
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Equipamentos getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamentos equipamento) {
        this.equipamento = equipamento;
    }

    public Locais getLocal() {
        return local;
    }

    public void setLocal(Locais local) {
        this.local = local;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (!status.isBlank()) {
            this.status = status;
        } else {
            System.out.println("Erro! Não pode estar em branco.");
        }
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        if (data.isBlank()) {
            this.data = data;
        } else {
            System.out.println("Erro! Não pode estar em branco.");
        }
    }

    public Vendas() {
        //construtor vazio
    }

    public Vendas(int codigoVenda, Cliente cliente, Equipamentos equipamento, Locais local, Responsavel responsavel, String status, String data) {
        setCodigoVenda(codigoVenda);
        setCliente(cliente);
        setEquipamento(equipamento);
        setLocal(local);
        setResponsavel(responsavel);
        setStatus(status);
        setData(data);
    }
}
