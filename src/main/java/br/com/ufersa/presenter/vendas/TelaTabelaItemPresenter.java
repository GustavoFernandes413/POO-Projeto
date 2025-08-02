package br.com.ufersa.presenter.vendas;

import br.com.ufersa.model.entities.Equipamentos;
import br.com.ufersa.model.entities.ItemVenda;
import br.com.ufersa.model.entities.Vendas;
import br.com.ufersa.presenter.util.PresenterUtil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class TelaTabelaItemPresenter implements Initializable {
    @FXML
    private TableView<ItemVenda> tabelaItemVendas;
    @FXML
    private TableColumn<ItemVenda, Equipamentos> colEquipamento;
    @FXML
    private TableColumn<ItemVenda, Integer> colQuantidade;
    @FXML
    private TableColumn<ItemVenda, Double> colPreco;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colEquipamento.setCellValueFactory(new PropertyValueFactory<>("equipamento"));
        colQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        colPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        // TODO implementar metodo no services que pega apenas os itens associados a uma venda
        //PresenterUtil.carregarTabelaItemVendas(tabelaItemVendas, vendacriada.getItens());
    }

    public void popularTabelaItemVendas(Vendas vendas){
        PresenterUtil.popularTabela(tabelaItemVendas, vendas.getItens());
    }



}
