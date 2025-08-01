package br.com.ufersa.presenter.locais;

import br.com.ufersa.model.dao.LocaisDAOImpl;
import br.com.ufersa.model.entities.Locais;
import br.com.ufersa.model.services.LocaisService;
import br.com.ufersa.model.services.LocaisServiceImpl;
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

public class TelaTabelaLocaisPresenter implements Initializable {
    @FXML
    private TableView<Locais> tabelaLocais;

    @FXML
    private TableColumn<Locais, String> colNomeCasa;

    @FXML
    private TableColumn<Locais, String> colNomeCompartimento;
    @FXML
    private TableColumn<Locais, Void> colAcoes;

    private final LocaisService locaisService = new LocaisServiceImpl(new LocaisDAOImpl());

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colNomeCasa.setCellValueFactory(new PropertyValueFactory<Locais, String>("nomeCasa"));
        colNomeCompartimento.setCellValueFactory(new PropertyValueFactory<Locais, String>("nomeCompartimento"));
        renderizarColunaAcoes();
        PresenterUtil.popularTabela(tabelaLocais,locaisService.getAllLocais());
    }

    public void renderizarColunaAcoes() {
        Callback<TableColumn<Locais, Void>, TableCell<Locais, Void>> cellFactory = new Callback<>() {
            @Override
            public TableCell<Locais, Void> call(final TableColumn<Locais, Void> param) {
                final TableCell<Locais, Void> cell = new TableCell<>() {
                    private final Hyperlink linkEditar = new Hyperlink("Editar");
                    {
                        linkEditar.setOnAction(event -> {
                            Locais localParaEditar = getTableRow().getItem();                        // Cria tela para edicao
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/com/ufersa/view/tela-cadastro-locais.fxml"));
                            try {
                                Parent root = loader.load();
                                TelaCadastroLocaisPresenter presenterEdicao = loader.getController();
                                presenterEdicao.carregarLocalEdicao(localParaEditar);
                                Stage stage = new Stage();
                                stage.setTitle("Editar Local");
                                stage.setScene(new Scene(root));
                                stage.showAndWait(); // Use showAndWait() para bloquear a janela da tabela até fechar a de edição

                                // Atualize a tabela após a edição ser salva e a janela fechada
                                PresenterUtil.popularTabela(tabelaLocais,locaisService.getAllLocais());
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

