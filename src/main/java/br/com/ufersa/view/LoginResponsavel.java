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

    public static void telaPrincipal(){
        FXMLLoader fxmlLoader = new FXMLLoader(LoginResponsavel.class.getResource("tela-principal.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 800, 600);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setTitle("Tela Principal");
        stage.setScene(scene);
        stage.show();
    }
    public static void telaLogin(){
        FXMLLoader fxmlLoader = new FXMLLoader(LoginResponsavel.class.getResource("tela-login.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 800, 600);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }
    public static void telaCadastro(){
        FXMLLoader fxmlLoader = new FXMLLoader(LoginResponsavel.class.getResource("tela-cadastro.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 800, 600);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setTitle("Cadastro");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}