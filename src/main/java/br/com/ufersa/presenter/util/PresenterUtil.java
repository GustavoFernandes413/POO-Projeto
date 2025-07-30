package br.com.ufersa.presenter.util;

import br.com.ufersa.model.entities.Cliente;
import br.com.ufersa.model.entities.Vendas;
import br.com.ufersa.model.services.ClienteService;
import br.com.ufersa.model.services.VendasService;
import br.com.ufersa.presenter.vendas.TelaCadastroVendasPresenter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.util.Callback;

import java.io.IOException;
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

    public void exibirAlerta(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    // util apenas para comboBox
    public  void carregarClientes(ComboBox<Cliente> clienteVenda) {
        List<Cliente> clienteList = clienteService.getAllPessoas();
        ObservableList<Cliente> observableLocais = FXCollections.observableArrayList(clienteList);
        clienteVenda.setItems(observableLocais);
    }
    public static void carregarVendas(TableView<Vendas> Venda, List<Vendas> vendasList) {
        ObservableList<Vendas> observableLocais = FXCollections.observableArrayList(vendasList);
        Venda.setItems(observableLocais);
    }

    // metodos de renderizacao de tabelas

    public void renderizarColunaAcoesVendas(TableColumn<Vendas, Void> colAcoes) {
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
