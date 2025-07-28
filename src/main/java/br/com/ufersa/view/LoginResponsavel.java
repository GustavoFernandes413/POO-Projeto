package br.com.ufersa.view;

import com.mysql.cj.log.Log;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginResponsavel extends Application {
    public static Stage stage;

    public void start(Stage stage) throws Exception {
        this.stage = stage;
        telaLogin();
    }

    public static void carregarCena(String titulo, String caminhoFXML) {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginResponsavel.class.getResource(caminhoFXML));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 800, 600);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setTitle(titulo);
        stage.setScene(scene);
        stage.show();
    }

    public static void telaPrincipal() {
        carregarCena("TelaPrincipal.fxml", "tela-principal.fxml");
    }

    public static void telaLogin() {
        carregarCena("Login", "tela-login.fxml");
    }

    public static void telaCadastro() {
        carregarCena("Cadastro", "tela-cadastro.fxml");
    }

    public static void telaPesquisaEquipamento() {
        carregarCena("Pesquisar Equipamentos em estoque", "tela-pesquisar-equipamentos.fxml");
    }
    // tela após clicar botao da tela princiapl Cadastro

    public static void telaPrincipalCadastro() {
        carregarCena("Equipamentos", "tela-principal-cadastro.fxml");
    }

    public static void telaCadastrarEquipamento() {
        carregarCena("Equipamentos", "tela-cadastrar-equipamento.fxml");
    }
    public static void telaCadastrarCliente() {
        carregarCena("Clientes", "tela-cadastrar-cliente.fxml");
    }
    public static void telaCadastrarLocais() {
        carregarCena("Locais", "tela-cadastro-locais.fxml");
    }


    public static void main(String[] args) {
        launch();
    }
}