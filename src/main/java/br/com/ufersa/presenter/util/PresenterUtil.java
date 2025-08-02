package br.com.ufersa.presenter.util;

import br.com.ufersa.model.entities.*;
import br.com.ufersa.model.services.ClienteService;
import br.com.ufersa.model.services.VendasService;
import br.com.ufersa.presenter.locais.TelaCadastroLocaisPresenter;
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
    // EStou estudando como implementar
//    public <T> void renderizarColunaAcoes(T entidade, String fxmlView,TableView<T> tabelaRenderizada, TableColumn<T, ?> colunaAcoes, List<T> listaObjetos) {
//        Callback<TableColumn<T, Void>, TableCell<T, Void>> cellFactory = new Callback<>() {
//            @Override
//            public TableCell<T, Void> call(final TableColumn<T, Void> param) {
//                final TableCell<T, Void> cell = new TableCell<>() {
//                    private final Hyperlink linkEditar = new Hyperlink("Editar");
//                    {
//                        linkEditar.setOnAction(event -> {
//                            T objetoParaEditar = getTableRow().getItem();                        // Cria tela para edicao
//                            FXMLLoader loader = new FXMLLoader(PresenterUtil.class.getResource(fxmlView));
//                            try {
//                                Parent root = loader.load();
//                                TelaCadastroLocaisPresenter presenterEdicao = loader.getController();
//                                presenterEdicao.carregarLocalEdicao(objetoParaEditar);
//                                Stage stage = new Stage();
//                                stage.setTitle("Editar Local");
//                                stage.setScene(new Scene(root));
//                                stage.showAndWait(); // Use showAndWait() para bloquear a janela da tabela até fechar a de edição
//
//                                PresenterUtil.popularTabela(tabelaRenderizada,listaObjetos);
//                            } catch (IOException e) {
//                                throw new RuntimeException(e);
//                            }
//                        });
//                    }
//
//                    @Override
//                    public void updateItem(Void item, boolean empty) {
//                        super.updateItem(item, empty);
//                        if (empty) {
//                            setGraphic(null);
//                        } else {
//                            HBox painelAcoes = new HBox(linkEditar);
//                            painelAcoes.setSpacing(10);
//                            setGraphic(painelAcoes);
//                        }
//                    }
//                };
//                return cell;
//            }
//
//        };
//        colunaAcoes.setCellFactory(cellFactory);
//    }

    public static <T> void popularComboBox(ComboBox<T> comboBox, List<T> listaObjetos) {
        ObservableList<T> observableListObjetos = FXCollections.observableArrayList(listaObjetos);
        comboBox.setItems(observableListObjetos);
    }
    public static <T>  void popularTabela(TableView<T> registrosTabela, List<T> listaRegistros) {
        ObservableList<T> observableListObjetos = FXCollections.observableArrayList(listaRegistros);
        registrosTabela.setItems(observableListObjetos);
    }


    // metodos de renderizacao de tabelas


}
