package br.com.ufersa.presenter.clientes;

import br.com.ufersa.model.dao.ClienteDAOImpl;
import br.com.ufersa.model.dao.PessoaDAOImpl;
import br.com.ufersa.model.entities.Cliente;
import br.com.ufersa.model.entities.Locais;
import br.com.ufersa.model.services.*;
import br.com.ufersa.presenter.locais.TelaCadastroLocaisPresenter;
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

public class TelaTabelaClientesPresenter implements Initializable {
    @FXML
    private TableView<Cliente> tabelaClientes;

    @FXML
    private TableColumn<Cliente, String> colNomeCliente;

    @FXML
    private TableColumn<Cliente, String> colEnderecoCliente;

    @FXML
    private TableColumn<Cliente, String> colCpfCliente;
    @FXML
    private TableColumn<Cliente, Void> colAcoes;

    private final ClienteService clienteService = new ClienteServiceImpl(new PessoaServiceImpl(new PessoaDAOImpl()), new ClienteDAOImpl());

    // passa os dados do DB para a  tabela. Usa dadosClientes como subrotina de receber os dados do DB e passar para os componentes da Table
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colNomeCliente.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));
        colEnderecoCliente.setCellValueFactory(new PropertyValueFactory<Cliente, String>("endereco"));
        colCpfCliente.setCellValueFactory(new PropertyValueFactory<Cliente, String>("cpf"));
        renderizarColunaAcoes();
        dadosClientes();
    }
    public void dadosClientes(){
        List<Cliente> listaCliente = clienteService.getAllPessoas();
        ObservableList<Cliente> observableListCliente = FXCollections.observableArrayList(listaCliente);
        tabelaClientes.setItems(observableListCliente);
    }

    public void renderizarColunaAcoes() {
        Callback<TableColumn<Cliente, Void>, TableCell<Cliente, Void>> cellFactory = new Callback<>() {
            @Override
            public TableCell<Cliente, Void> call(final TableColumn<Cliente, Void> param) {
                final TableCell<Cliente, Void> cell = new TableCell<>() {
                    private final Hyperlink linkEditar = new Hyperlink("Editar");
                   // private final Button btnExcluir = new Button("Excluir");

                    {
                        linkEditar.setOnAction(event -> {
                            Cliente clienteParaEditar = getTableRow().getItem();                        // Cria tela para edicao
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/com/ufersa/view/tela-cadastrar-cliente.fxml"));
                            try {
                                Parent root = loader.load();
                                TelaCadastroClientesPresenter presenterEdicao = loader.getController();
                                presenterEdicao.carregarClienteParaEdicao(clienteParaEditar);
                                Stage stage = new Stage();
                                stage.setTitle("Editar Local");
                                stage.setScene(new Scene(root));
                                stage.showAndWait(); // Use showAndWait() para bloquear a janela da tabela até fechar a de edição

                                dadosClientes();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                        });
//                        // TODO implementar funcionalidade Deletar
//                        btnExcluir.setOnAction(event -> {
//                           // Locais local = getTableView().getItems().get(getIndex());
//                            // deletarRegistro(produto);
//                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            HBox painelAcoes = new HBox(linkEditar);
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
