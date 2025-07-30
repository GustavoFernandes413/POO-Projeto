package br.com.ufersa.presenter.vendas;

import br.com.ufersa.model.dao.VendasDAOImpl;
import br.com.ufersa.model.entities.Equipamentos;
import br.com.ufersa.model.entities.ItemVenda;
import br.com.ufersa.model.entities.Vendas;
import br.com.ufersa.model.services.VendasService;
import br.com.ufersa.model.services.VendasServiceImpl;
import br.com.ufersa.presenter.equipamentos.TelaCadastroEquipamentosPresenter;
import br.com.ufersa.presenter.util.PresenterUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TelaTabelaVendasPresenter implements Initializable {
    @FXML
    private TableView<Vendas> tabelaVendas;

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
        renderizarColunaAcoesVendas();
        presenterUtil.carregarVendas(tabelaVendas);
    }

    public void renderizarColunaAcoesVendas() {
        Callback<TableColumn<Vendas, Void>, TableCell<Vendas, Void>> cellFactory = new Callback<>() {
            @Override
            public TableCell<Vendas, Void> call(final TableColumn<Vendas, Void> param) {
                final TableCell<Vendas, Void> cell = new TableCell<>() {
                    private final Button btnCancelar = new Button("Cancelar");

                    {
                        // TODO implementar chamada ao servico cancelamento de compra
                        btnCancelar.setOnAction(event -> {
                            Vendas vendaParaEditar = getTableRow().getItem();                        // Cria tela para edicao

                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/com/ufersa/view/tela-cadastro-venda.fxml"));
                            try {
                                Parent root = loader.load();
                                TelaCadastroVendasPresenter presenter = loader.getController();
                                presenter.carregarVendaParaEdicao(vendaParaEditar);
                                presenter.cancelamento(); // TODO corrigir para salvar no BD
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            HBox painelAcoes = new HBox(btnCancelar);
                            painelAcoes.setSpacing(10);
                            setGraphic(painelAcoes);
                        }
                    }
                };
                return cell;
            }

        };
        colAcoes.setCellFactory(cellFactory);
    }


}
