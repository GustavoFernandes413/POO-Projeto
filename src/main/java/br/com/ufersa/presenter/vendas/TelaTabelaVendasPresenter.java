package br.com.ufersa.presenter.vendas;

import br.com.ufersa.model.dao.VendasDAOImpl;
import br.com.ufersa.model.entities.ItemVenda;
import br.com.ufersa.model.entities.StatusCompra;
import br.com.ufersa.model.entities.Vendas;
import br.com.ufersa.model.services.VendasService;
import br.com.ufersa.model.services.VendasServiceImpl;
import br.com.ufersa.presenter.util.NavigationManager;
import br.com.ufersa.presenter.util.PresenterUtil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.util.Callback;

import javax.swing.*;
import java.io.IOException;
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
    private TableColumn<Vendas, Void> colAcoes;
    @FXML
    private TableColumn<Vendas, StatusCompra> colStatus;
    @FXML
    private TableColumn<Vendas, Initializable> colIdVenda;

    // Ainda não sei como implementar DI aqui, por isso esse alto acoplamento
    VendasService vendasService = new VendasServiceImpl(new VendasDAOImpl());
    NavigationManager navegationManager = new NavigationManager();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colCodVenda.setCellValueFactory(new PropertyValueFactory<>("codigoVenda"));
        colClienteVenda.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        colPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        colIdVenda.setCellValueFactory(new PropertyValueFactory<>("id"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        renderizarColunaAcoesVendas(colAcoes);
        PresenterUtil.carregarVendas(minhaTabelaVendas, vendasService.getAllVendas());
    }

    public TableView<Vendas> getMinhaTabelaVendas() {
        return minhaTabelaVendas;
    }

    // Renderiza botões de ações ao criar tabela de vendas
    public void renderizarColunaAcoesVendas(TableColumn<Vendas, Void> colAcoes) {
        Callback<TableColumn<Vendas, Void>, TableCell<Vendas, Void>> cellFactory = new Callback<>() {
            @Override
            public TableCell<Vendas, Void> call(final TableColumn<Vendas, Void> param) {
                final TableCell<Vendas, Void> cell = new TableCell<>() {
                    private final Button btnCancelar = new Button("Cancelar");
                    private final Button btnNota = new Button("Abrir nota");
                    {
                        btnCancelar.setOnAction(event -> {
                            Vendas vendaParaEditar = getTableRow().getItem();
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/com/ufersa/view/tela-cadastro-venda.fxml"));
                            try {
                                Parent root = loader.load();
                                TelaCadastroVendasPresenter presenter = loader.getController();
                                presenter.carregarVendaParaEdicao(vendaParaEditar);
                                presenter.cancelamento();
                                JOptionPane.showMessageDialog(null, " Venda Devolvida com sucesso! Novo status: ");
                                PresenterUtil.carregarVendas(minhaTabelaVendas,vendasService.getAllVendas());
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        });

                        btnNota.setOnAction(event -> {
                            Vendas vendaParaAbrirNota = getTableRow().getItem();
                            try {
                                navegationManager.abrirNota(vendaParaAbrirNota);
                            }catch (Exception e) {
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
                            HBox painelAcoes = new HBox(btnCancelar, btnNota);
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
