package br.com.ufersa.presenter.util;

import br.com.ufersa.model.entities.Cliente;
import br.com.ufersa.model.entities.Vendas;
import br.com.ufersa.model.services.ClienteService;
import br.com.ufersa.model.services.VendasService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;

import java.util.List;

public class PresenterUtil {
    private  ClienteService clienteService;
    private  VendasService vendasService;


    public PresenterUtil(ClienteService clienteService, VendasService vendasService) {
        this.clienteService = clienteService;
        this.vendasService = vendasService;
    }
    public PresenterUtil(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
    public PresenterUtil( VendasService vendasService) {
        this.vendasService = vendasService;
    }

    // util apenas para comboBox
    public  void carregarClientes(ComboBox<Cliente> clienteVenda) {
        List<Cliente> clienteList = clienteService.getAllPessoas();
        ObservableList<Cliente> observableLocais = FXCollections.observableArrayList(clienteList);
        clienteVenda.setItems(observableLocais);
    }
    public  void carregarVendas(TableView<Vendas> Venda) {
        List<Vendas> vendaList = vendasService.getAllVendas();
        ObservableList<Vendas> observableLocais = FXCollections.observableArrayList(vendaList);
        Venda.setItems(observableLocais);
    }
}
