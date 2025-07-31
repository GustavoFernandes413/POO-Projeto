package br.com.ufersa.presenter.equipamentos;

import br.com.ufersa.model.dao.EquipamentosDAOImpl;
import br.com.ufersa.model.entities.Equipamentos;
import br.com.ufersa.model.entities.Locais;
import br.com.ufersa.model.entities.Responsavel;
import br.com.ufersa.model.services.EquipamentosService;
import br.com.ufersa.model.services.EquipamentosServiceImpl;
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

public class TelaTabelaEquipamentosPresenter implements Initializable {
    @FXML
    private TableView<Equipamentos> tabelaEquipamentos;
    @FXML
    private TableColumn<Equipamentos, Integer> colNumeroSerie;
    @FXML
    private TableColumn<Equipamentos, String> colNomeEquipamento;
    @FXML
    private TableColumn<Equipamentos, Double> colPreco;
    @FXML
    private TableColumn<Equipamentos, Integer> colEstoque;
    @FXML
    private TableColumn<Equipamentos, Locais> colLocal;
    @FXML
    private TableColumn<Equipamentos, Responsavel> colResponsavel;
    @FXML
    private TableColumn<Equipamentos, Void> colAcoes;

    private final EquipamentosService equipamentosService = new EquipamentosServiceImpl(new EquipamentosDAOImpl());

    public TableView<Equipamentos> getTabelaEquipamentos() {
        return tabelaEquipamentos;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colNumeroSerie.setCellValueFactory(new PropertyValueFactory<Equipamentos, Integer>("numeroSerie"));
        colNomeEquipamento.setCellValueFactory(new PropertyValueFactory<Equipamentos, String>("nome"));
        colPreco.setCellValueFactory(new PropertyValueFactory<Equipamentos, Double>("preco"));
        colEstoque.setCellValueFactory(new PropertyValueFactory<Equipamentos, Integer>("quantidadeEstoque"));
        colLocal.setCellValueFactory(new PropertyValueFactory<Equipamentos, Locais>("local"));
        colResponsavel.setCellValueFactory(new PropertyValueFactory<Equipamentos, Responsavel>("responsavel"));


        renderizarColunaAcoes();
        dadosEquipamentos();
    }

    public void dadosEquipamentos() {
        List<Equipamentos> listaEquipamentos = equipamentosService.getAllEquipamentos();
        ObservableList<Equipamentos> observableListEquipamentos = FXCollections.observableArrayList(listaEquipamentos);
        tabelaEquipamentos.setItems(observableListEquipamentos);
    }



    public void renderizarColunaAcoes() {
        Callback<TableColumn<Equipamentos, Void>, TableCell<Equipamentos, Void>> cellFactory = new Callback<>() {
            @Override
            public TableCell<Equipamentos, Void> call(final TableColumn<Equipamentos, Void> param) {
                final TableCell<Equipamentos, Void> cell = new TableCell<>() {
                    private final Hyperlink linkEditar = new Hyperlink("Editar");
                   // private final Button btnExcluir = new Button("Excluir");

                    {
                        linkEditar.setOnAction(event -> {
                            Equipamentos EquipamentoParaEditar = getTableRow().getItem();                        // Cria tela para edicao
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/com/ufersa/view/tela-cadastrar-equipamento.fxml"));
                            try {
                                Parent root = loader.load();
                                TelaCadastroEquipamentosPresenter presenterEdicao = loader.getController();
                                presenterEdicao.carregarEquipamentoEdicao(EquipamentoParaEditar);
                                // Cria um novo palco
                                Stage stage = new Stage();
                                stage.setTitle("Editar Equipamento");
                                stage.setScene(new Scene(root));
                                stage.showAndWait(); // Use showAndWait() para bloquear a janela da tabela até fechar a de edição

                                // 6. (Opcional) Atualize a tabela após a edição ser salva e a janela fechada
                                dadosEquipamentos();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                        });
//                        // TODO implementar chamada ao servico de exclusao
//                        btnExcluir.setOnAction(event -> {
////                            Equipamentos equipamento = getTableView().getItem();
////                             deletarRegistro(produto);
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
