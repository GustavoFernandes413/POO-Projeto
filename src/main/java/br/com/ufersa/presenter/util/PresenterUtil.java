package br.com.ufersa.presenter.util;

import br.com.ufersa.model.entities.Cliente;
import br.com.ufersa.model.entities.Equipamentos;
import br.com.ufersa.model.entities.ItemVenda;
import br.com.ufersa.model.entities.Vendas;
import br.com.ufersa.model.services.ClienteService;
import br.com.ufersa.model.services.VendasService;
import br.com.ufersa.presenter.vendas.TelaCadastroItemVendas;
import br.com.ufersa.presenter.vendas.TelaCadastroVendasPresenter;
import br.com.ufersa.presenter.vendas.TelaNotaVendaPresenter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.controlsfx.control.PropertySheet;

import javax.swing.*;
import java.io.IOException;
import java.util.List;
// Essa classe possui metodos que uso com frequência em toda a UI da aplicação
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
    public void abrirNota(Vendas venda, Node node, Label erro){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/com/ufersa/view/tela-nota-venda.fxml"));
            Parent root = loader.load();

            TelaNotaVendaPresenter modalController = loader.getController();
            modalController.setVendaCriada(venda);

            Stage modalStage = new Stage();
            modalStage.setTitle("Nota da  Venda");
            modalStage.setScene(new Scene(root));
            modalStage.initModality(Modality.APPLICATION_MODAL);
            modalStage.initOwner(node.getScene().getWindow());
            modalStage.showAndWait(); // Pausa a execução aqui até o modal ser fechado
        }catch (Exception e){
            erro.setText(e.getMessage());
            erro.setTextFill(Color.RED);
            erro.setVisible(true);
        }
    }
    public  void abrirNota(Vendas venda ) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/com/ufersa/view/tela-nota-venda.fxml"));
            Parent root = loader.load();
            TelaNotaVendaPresenter modalController = loader.getController();
            modalController.setVendaCriada(venda);
            Stage modalStage = new Stage();
            modalStage.setTitle("Nota da  Venda");
            modalStage.setScene(new Scene(root));
            modalStage.initModality(Modality.APPLICATION_MODAL);
            modalStage.showAndWait(); // Pausa a execução aqui até o modal ser fechado
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao abrir nota!");
        }
    }

    public static void exibirAlerta(String titulo, String mensagem) {
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
    public static void carregarTabelaItemVendas(TableView<ItemVenda> itemVenda, List<ItemVenda> itemVendaList) {
        ObservableList<ItemVenda> observableItemVenda  = FXCollections.observableArrayList(itemVendaList);
        itemVenda.setItems(observableItemVenda);
    }
    public static void carregarTabelaEquipamentos(TableView<Equipamentos> equipamentos, List<Equipamentos> equipamentosList) {
        ObservableList<Equipamentos> observablelEquipamentos  = FXCollections.observableArrayList(equipamentosList);
        equipamentos.setItems(observablelEquipamentos);
    }

    // metodos de renderizacao de tabelas


}
