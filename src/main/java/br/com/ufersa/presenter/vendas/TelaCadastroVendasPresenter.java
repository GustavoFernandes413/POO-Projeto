package br.com.ufersa.presenter.vendas;

import br.com.ufersa.model.dao.ClienteDAOImpl;
import br.com.ufersa.model.dao.PessoaDAOImpl;
import br.com.ufersa.model.dao.VendasDAOImpl;
import br.com.ufersa.model.entities.*;
import br.com.ufersa.model.services.*;
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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TelaCadastroVendasPresenter implements Initializable {
    @FXML private TextField codVenda;
    @FXML private ComboBox<StatusCompra> statusVenda;
    @FXML private ComboBox<Cliente> clienteVenda;
    @FXML private DatePicker dataVenda;
    @FXML private TableView<ItemVenda> tabelaItensVenda;

    // AJUSTE 1: O tipo da coluna deve corresponder ao tipo do dado.
    // getEquipamento() retorna um objeto Equipamentos, não uma String. O JavaFX usará o método toString() do objeto.
    @FXML private TableColumn<ItemVenda, Equipamentos> equipamentosVenda;
    @FXML private TableColumn<ItemVenda, Integer> quantidadeVenda;

    @FXML private Button adicionarItemButton;
    @FXML private Label erro;

    private ObservableList<ItemVenda> itensDaVenda;

    VendasService vendasService = new VendasServiceImpl(new VendasDAOImpl());
    ClienteService clienteService = new ClienteServiceImpl(new PessoaServiceImpl(new PessoaDAOImpl()), new ClienteDAOImpl());
    Vendas vendaSelecionada;

    private void carregarClientes() {
        List<Cliente> clienteList = clienteService.getAllPessoas();
        ObservableList<Cliente> observableLocais = FXCollections.observableArrayList(clienteList);
        clienteVenda.setItems(observableLocais);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        carregarClientes();
        this.itensDaVenda = FXCollections.observableArrayList();

        // Configura as colunas para buscar os dados do objeto ItemVenda
        // "equipamento" -> chama item.getEquipamento()
        // "quantidade" -> chama item.getQuantidade()
        // DICA: Para a coluna de equipamento funcionar bem, certifique-se de que sua classe Equipamentos
        // tem um método toString() que retorna o nome do equipamento.
        equipamentosVenda.setCellValueFactory(new PropertyValueFactory<>("equipamento"));
        quantidadeVenda.setCellValueFactory(new PropertyValueFactory<>("quantidade"));

        tabelaItensVenda.setItems(itensDaVenda);
    }

    /**
     * Este método abre o modal.
     * No seu FXML principal, o botão deve ter: onAction="#irParaModalItem"
     */
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
        if(vendaSelecionada == null) cadastrar();
        else cancelamento();
    }

    public void cadastrar(){
        Vendas vendaPersistir = new Vendas();
        vendaPersistir.setItens(new ArrayList<>(this.itensDaVenda));
        // ... sua lógica para pegar cliente, data, etc.
        try {
            // vendasService.criarVenda(vendaPersistir);
            JOptionPane.showMessageDialog(null, "Venda realizada com sucesso!");
        } catch (Exception e) {
            erro.setText(e.getMessage());
            erro.setTextFill(Color.RED);
            erro.setVisible(true);
        }
    }

    public void cancelamento(){
        // ...
    }

    @FXML public void voltar(ActionEvent event){
        LoginResponsavel.telaPrincipalCadastro();
    }
}