package br.com.ufersa.presenter.util;

import br.com.ufersa.model.entities.Cliente;
import br.com.ufersa.model.entities.Equipamentos;
import br.com.ufersa.model.entities.ItemVenda;
import br.com.ufersa.model.entities.Vendas;
import br.com.ufersa.model.services.ClienteService;
import br.com.ufersa.model.services.VendasService;
import br.com.ufersa.presenter.vendas.TelaCadastroItemVendas;
import br.com.ufersa.presenter.vendas.TelaCadastroVendasPresenter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.controlsfx.control.PropertySheet;

import javax.swing.*;
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

    public static void exibirAlerta(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    // TODO pode ser uma forma de refatoracao
    public <T> T  getPresenter(String caminhoPresenter, T tipoController, Button donoModal) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(caminhoPresenter));
        Parent root = loader.load();
        Stage modalStage = new Stage();
        modalStage.setTitle("Adicionar Item à Venda");
        modalStage.setScene(new Scene(root));
        modalStage.initModality(Modality.APPLICATION_MODAL);
        modalStage.initOwner(donoModal.getScene().getWindow());
        modalStage.showAndWait();


        return loader.getController();
    }

    public static void fecharJanela(Node node) {
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
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
    public static void carregarTabelaItemVendas(TableView<ItemVenda> itemVenda, List<ItemVenda> itemVendaList) {
        ObservableList<ItemVenda> observableItemVenda  = FXCollections.observableArrayList(itemVendaList);
        itemVenda.setItems(observableItemVenda);
    }
    public static void carregarTabelaEquipamentos(TableView<Equipamentos> equipamentos, List<Equipamentos> equipamentosList) {
        ObservableList<Equipamentos> observablelEquipamentos  = FXCollections.observableArrayList(equipamentosList);
        equipamentos.setItems(observablelEquipamentos);
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
                                JOptionPane.showMessageDialog(null, " Venda Devolvida com sucesso! Novo status: ");

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
