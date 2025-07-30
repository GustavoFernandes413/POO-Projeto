package br.com.ufersa.presenter.vendas;

import br.com.ufersa.model.dao.ClienteDAOImpl;
import br.com.ufersa.model.dao.EquipamentosDAOImpl;
import br.com.ufersa.model.dao.PessoaDAOImpl;
import br.com.ufersa.model.dao.VendasDAOImpl;
import br.com.ufersa.model.entities.*;
import br.com.ufersa.model.services.*;
import br.com.ufersa.presenter.util.PresenterUtil;
import br.com.ufersa.view.LoginResponsavel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TelaCadastroVendasPresenter implements Initializable {
    @FXML private TextField codVenda;
    @FXML private ComboBox<StatusCompra> statusVenda;
    @FXML private ComboBox<Cliente> clienteVenda;

    @FXML private TableView<ItemVenda> tabelaItensVenda;

    // AJUSTE 1: O tipo da coluna deve corresponder ao tipo do dado.
    // getEquipamento() retorna um objeto Equipamentos, não uma String. O JavaFX usará o método toString() do objeto.
    @FXML private TableColumn<ItemVenda, Equipamentos> equipamentosVenda;
    @FXML private TableColumn<ItemVenda, Integer> quantidadeVenda;

    @FXML private Button adicionarItemButton;
    @FXML private Label erro;

    private ObservableList<ItemVenda> itensDaVenda;
    // Sei que não é uma boa prática, mas até o momento não sei como fazer DI funcional aqui
    VendasService vendasService = new VendasServiceImpl(new VendasDAOImpl());
    ClienteService clienteService = new ClienteServiceImpl(new PessoaServiceImpl(new PessoaDAOImpl()), new ClienteDAOImpl());
    PresenterUtil presenterUtil = new PresenterUtil(clienteService);
    ObserverVendas vendasObserver = new EquipamentosServiceImpl(new EquipamentosDAOImpl());

    Vendas vendaSelecionada;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        presenterUtil.carregarClientes(clienteVenda);
        this.itensDaVenda = FXCollections.observableArrayList();

        equipamentosVenda.setCellValueFactory(new PropertyValueFactory<>("equipamento"));
        quantidadeVenda.setCellValueFactory(new PropertyValueFactory<>("quantidade"));

        tabelaItensVenda.setItems(itensDaVenda);
    }

    @FXML
    void irParaModalItem(ActionEvent event) {
        try {
            // AJUSTE 2: Corrija o caminho para o FXML do seu modal se necessário
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/com/ufersa/view/tela-cadastro-item.fxml"));
            Parent root = loader.load();

            TelaCadastroItemVendas modalController = loader.getController();

            Stage modalStage = new Stage();
            modalStage.setTitle("Adicionar Item à Venda");
            modalStage.setScene(new Scene(root));
            modalStage.initModality(Modality.APPLICATION_MODAL);
            modalStage.initOwner(adicionarItemButton.getScene().getWindow());
            modalStage.showAndWait(); // Pausa a execução aqui até o modal ser fechado

            // Após fechar o modal, pega o item que foi criado lá
            ItemVenda novoItem = modalController.getItemAdicionado();

            // Se o usuário confirmou (novoItem não é nulo), adiciona na tabela
            if (novoItem != null) {
                this.itensDaVenda.add(novoItem); // A tabela na tela se atualiza sozinha!
            }

        } catch (IOException e) {
            erro.setText("Erro ao abrir tela de item: " + e.getMessage());
            erro.setTextFill(Color.RED);
            erro.setVisible(true);
            e.printStackTrace();
        }
    }

    public void salvar(ActionEvent event) {
        if (vendaSelecionada == null) cadastrar();
        else cancelamento();
    }

    // Uso do Builder
    public void cadastrar() {
        vendasService.addObserver(vendasObserver);
        Vendas vendaPersistir = new Vendas.Builder()
                .data(Timestamp.valueOf(LocalDateTime.now()))
                .cliente(clienteVenda.getSelectionModel().getSelectedItem())
                .status(StatusCompra.CONCLUIDA)
                .preco(vendasService.calcularPrecoVenda(this.itensDaVenda))
                .addItens(this.itensDaVenda)
                .build();


        try {
             vendasService.criarVenda(vendaPersistir);
            vendasService.removeObserver(vendasObserver); // retira
            JOptionPane.showMessageDialog(null, "Venda realizada com sucesso!");
        } catch (Exception e) {
            erro.setText(e.getMessage());
            erro.setTextFill(Color.RED);
            erro.setVisible(true);
        }
    }

    public void cancelamento() {
        vendasService.addObserver(vendasObserver);

        vendaSelecionada.setStatus(StatusCompra.CANCELADA);
        try {
            vendasService.cancelamento(vendaSelecionada);
            JOptionPane.showMessageDialog(null, " Equipamento devolvido com sucesso! Novo status: "+ vendaSelecionada.getStatus());
            vendasService.removeObserver(vendasObserver); // retira

        } catch (Exception e) {
            erro.setText(e.getMessage());
            erro.setTextFill(Color.RED);
            erro.setVisible(true);
        }
    }
    public  void carregarVendaParaEdicao(Vendas venda){
        this.vendaSelecionada = venda;
        Vendas novaVenda = new Vendas();
        novaVenda.setId(venda.getId());

        codVenda.setText(novaVenda.getCodigoVenda());
        clienteVenda.setValue((  novaVenda.getCliente()));
    }
    @FXML
    public void voltar(ActionEvent event) {
        LoginResponsavel.telaPrincipalCadastro();
    }
}