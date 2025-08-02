package br.com.ufersa.presenter.util;

import br.com.ufersa.model.entities.Vendas;
import br.com.ufersa.presenter.vendas.TelaNotaVendaPresenter;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class NavigationManager {

    public static void abrirNota(Vendas venda ) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(NavigationManager.class.getResource("/br/com/ufersa/view/tela-nota-venda.fxml"));
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

    public static void fecharJanela(Node node) {
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }

}
