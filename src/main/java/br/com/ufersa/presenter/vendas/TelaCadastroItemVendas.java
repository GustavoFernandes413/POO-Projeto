package br.com.ufersa.presenter.vendas;

import br.com.ufersa.model.dao.EquipamentosDAOImpl;
import br.com.ufersa.model.entities.Equipamentos;
import br.com.ufersa.model.entities.ItemVenda;
import br.com.ufersa.model.entities.Vendas;
import br.com.ufersa.model.services.EquipamentosService;
import br.com.ufersa.model.services.EquipamentosServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

// CORREÇÃO 1: Importar o ActionEvent do JavaFX, não do AWT.
import javafx.event.ActionEvent;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TelaCadastroItemVendas implements Initializable {
    @FXML private ComboBox<Equipamentos> equipamentoItens;
    @FXML private ComboBox<Integer> quantidadeItens;
    @FXML private Label erro;
    @FXML private Button botaoAdicionar, cancelarAdicao;


    EquipamentosService equipamentosService = new EquipamentosServiceImpl(new EquipamentosDAOImpl());

    // Mantém o item que será retornado para a tela principal
    private ItemVenda itemAdicionado = null;

    @FXML
    public void adicionarItemVenda(ActionEvent event) {
        // Validação para garantir que algo foi selecionado
        if (equipamentoItens.getSelectionModel().isEmpty() || quantidadeItens.getSelectionModel().isEmpty()) {
            erro.setText("Por favor, selecione um equipamento e uma quantidade.");
            erro.setVisible(true);
            return;
        }

        ItemVenda item = new ItemVenda();
        item.setEquipamento(equipamentoItens.getSelectionModel().getSelectedItem());
        item.setQuantidade(quantidadeItens.getSelectionModel().getSelectedItem());
        // Guarda o item criado para que a outra tela possa pegá-lo
        this.itemAdicionado = item;
        fecharJanela(botaoAdicionar);
    }

    public ItemVenda getItemAdicionado() {
        return this.itemAdicionado;
    }

    @FXML
    private void cancelar(ActionEvent event) { // Adicionado ActionEvent para consistência
        this.itemAdicionado = null;
        fecharJanela(cancelarAdicao);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        carregarEquipamentos();

        // Listener para atualizar a quantidade disponível quando um equipamento é selecionado
        equipamentoItens.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                popularComboBoxDeNumeros(newValue.getQuantidadeEstoque());
            } else {
                quantidadeItens.getItems().clear(); // Limpa as opções se nada estiver selecionado
                quantidadeItens.setPromptText("Selecione a Quantidade");
            }
        });
    }

    // Preenche o ComboBox de quantidade com números de 1 até o estoque
    public void popularComboBoxDeNumeros(int quantidadeMaxima) {
        ObservableList<Integer> numeros = FXCollections.observableArrayList();
        for (int i = 1; i <= quantidadeMaxima; i++) {
            numeros.add(i);
        }
        // CORREÇÃO 2: Faltava associar a lista criada ao ComboBox
        quantidadeItens.setItems(numeros);
    }

    public void carregarEquipamentos() {
        List<Equipamentos> equipamentos = equipamentosService.getAllEquipamentosDisponiveis();
        ObservableList<Equipamentos> equipamentosObservableList = FXCollections.observableArrayList(equipamentos);
        equipamentoItens.setItems(equipamentosObservableList);
        equipamentoItens.setPromptText("Selecione um Equipamento");
    }

    private void fecharJanela(Node node) {
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }
}