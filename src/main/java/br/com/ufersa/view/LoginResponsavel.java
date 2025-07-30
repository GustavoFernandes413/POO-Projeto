package br.com.ufersa.view;

import com.mysql.cj.log.Log;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
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
    public static void retirarPaloco() {
        stage.close();
    }

    public static void carregarPalco(String titulo, String caminhoFXML) {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginResponsavel.class.getResource(caminhoFXML));
        Scene scene = null;
        Stage stageTemporario = new Stage();
        try {
            scene = new Scene(fxmlLoader.load(), 1000, 800);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stageTemporario.setTitle(titulo);
        stageTemporario.setScene(scene);
        stageTemporario.show();
    }

    // TODO Quando precisar criar um novo palco
    public static void carregarPalcoComRaiz(Parent raiz, String titulo) {
        Stage stageTemporario = new Stage();
        Scene scene = null;
        scene = new Scene(raiz, 800, 600);
        stageTemporario.initModality(Modality.WINDOW_MODAL); // Bloqueia a janela principal
        stageTemporario.showAndWait();
        stageTemporario.setTitle(titulo);
        stageTemporario.setScene(scene);
        stageTemporario.show();
    }

    public static void telaPrincipal() {
        carregarCena("TelaPrincipal.fxml", "tela-principal.fxml");
    }

    public static void telaLogin() {
        carregarCena("Login", "tela-login.fxml");
    }

    public static void telaCadastro() {
        carregarPalco("Cadastro", "tela-cadastro.fxml");
    }

    public static void telaPesquisaEquipamento() {
        carregarPalco("Pesquisar Equipamentos em estoque", "tela-pesquisar-equipamentos.fxml");
    }
    // tela após clicar botao da tela princiapl Cadastro

    public static void telaPrincipalCadastro() {
        carregarCena("Cadastro", "tela-principal-cadastro.fxml");
    }

    public static void telaCadastrarEquipamento() {
        carregarPalco("Equipamentos", "tela-cadastrar-equipamento.fxml");
    }

    public static void telaCadastrarCliente() {
        carregarPalco("Clientes", "tela-cadastrar-cliente.fxml");
    }

    public static void telaCadastrarLocais() {
        carregarPalco("Locais", "tela-cadastro-locais.fxml");
    }

    public static void telaCadastroVendas() {
        carregarPalco("Realizar nova Venda", "tela-cadastro-venda.fxml");
    }
    public static void telaRelatorioVendas(){
        carregarPalco("Relatório de Vendas por Período", "tela-relatorio-vendas.fxml");
    }
    public static void telaPrincipalVendas(){
        carregarCena("Vendas", "tela-principal-vendas.fxml");
    }

    // tabelas

    public static void telaPrincipalListagem() {
        carregarCena("Listagem", "tela-principal-listagem.fxml");
    }

    public static void telaTabelaClientes() {
        carregarPalco("Lista de clientes cadastrados", "tela-tabela-clientes.fxml");
    }

    public static void telaTabelaEquipamentos() {
        carregarPalco("Lista de equipamentos em estoque", "tela-tabela-equipamentos.fxml");
    }

    public static void telaTabelaLocais() {
        carregarPalco("Lista de locais cadastrados", "tela-tabela-locais.fxml");
    }
    public static void telaTabelaVendas() {
        carregarPalco("Lista de Vendas", "tela-tabela-vendas.fxml");
    }


    public static void main(String[] args) {
        launch();
    }
}