package br.com.ufersa.presenter.vendas;

import br.com.ufersa.model.dao.VendasDAOImpl;
import br.com.ufersa.model.entities.ItemVenda;
import br.com.ufersa.model.entities.Vendas;
import br.com.ufersa.model.services.VendasService;
import br.com.ufersa.model.services.VendasServiceImpl;
import br.com.ufersa.presenter.util.PresenterUtil;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;

public class TelaTabelaVendasPresenter implements Initializable {
    @FXML
    private TableView<Vendas> minhaTabelaVendas;

    @FXML
    private TableColumn<Vendas, String> colCodVenda;
    @FXML
    private TableColumn<Vendas, String> colClienteVenda;
    @FXML
    private TableColumn<Vendas, Double> colPreco;
    @FXML
    private TableColumn<Vendas, ItemVenda> colItens;
    @FXML
    private TableColumn<Vendas, Void> colAcoes;
    @FXML
    private TableColumn<Vendas, Initializable> colIdVenda;


    VendasService vendasService = new VendasServiceImpl(new VendasDAOImpl());
    PresenterUtil presenterUtil = new PresenterUtil(vendasService);


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colCodVenda.setCellValueFactory(new PropertyValueFactory<>("codigoVenda"));
        colClienteVenda.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        colPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        colItens.setCellValueFactory(new PropertyValueFactory<>("itens"));
        colIdVenda.setCellValueFactory(new PropertyValueFactory<>("id"));
        presenterUtil.renderizarColunaAcoesVendas(colAcoes);
        PresenterUtil.carregarVendas(minhaTabelaVendas, vendasService.getAllVendas());
    }

    public TableView<Vendas> getMinhaTabelaVendas() {
        return minhaTabelaVendas;
    }
}
