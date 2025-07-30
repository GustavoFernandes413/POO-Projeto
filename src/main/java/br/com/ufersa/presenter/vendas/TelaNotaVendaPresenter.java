package br.com.ufersa.presenter.vendas;

import br.com.ufersa.model.entities.Vendas;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

public class TelaNotaVendaPresenter implements Initializable {
    @FXML
    private Label nomeCliente;
    @FXML
    private Label codigoVenda;
    @FXML
    private Label dataVenda;
    @FXML
    private Label totalVenda;

    @FXML private TelaTabelaItemPresenter tabelaItemVendasController;


    public Vendas vendaCriada;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

    public void setVendaCriada(Vendas vendaCriada) {
        this.vendaCriada = vendaCriada;
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        nomeCliente.setText(vendaCriada.getCliente().getNome());
        codigoVenda.setText(vendaCriada.getCodigoVenda());
        dataVenda.setText(formatador.format(vendaCriada.getData())); // torna mais amigável para o usuario
        totalVenda.setText("R$ "+ vendaCriada.getPreco());
        tabelaItemVendasController.popularTabelaItemVendas(vendaCriada);
    }
    public void popularTabelaItensVendas() {

    }

    public Vendas getVendaCriada() {
        return vendaCriada;
    }
}
