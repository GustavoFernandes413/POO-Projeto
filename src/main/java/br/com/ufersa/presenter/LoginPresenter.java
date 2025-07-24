package br.com.ufersa.presenter;

import br.com.ufersa.exceptions.AutenticacaoException;
import br.com.ufersa.model.dao.PessoaDAOImpl;
import br.com.ufersa.model.dao.ResponsavelDAOImpl;
import br.com.ufersa.model.entities.Responsavel;
import br.com.ufersa.model.services.PessoaServiceImpl;
import br.com.ufersa.model.services.ResponsavelService;
import br.com.ufersa.model.services.ResponsavelServiceImpl;
import br.com.ufersa.view.LoginResponsavel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import javax.swing.*;

public class LoginPresenter {
    @FXML private TextField RespEmail;
    @FXML private PasswordField RespSenha;
    @FXML private Label erro;

    ResponsavelService  responsavelService = new ResponsavelServiceImpl(new ResponsavelDAOImpl(), new PessoaServiceImpl(new PessoaDAOImpl()));
    Responsavel logante = new Responsavel();

    @FXML public void autenticar (ActionEvent event){
        logante.setLogin(RespEmail.getText());
        logante.setSenha(RespSenha.getText());
        try {
            responsavelService.autenticar(logante);
            JOptionPane.showMessageDialog(null, "Autenticado com sucesso!");
            LoginResponsavel.telaPrincipal();
        } catch (AutenticacaoException e) {
            erro.setText(e.getMessage());
            erro.setTextFill(Color.RED);
            erro.setVisible(true);
        }
    }

    @FXML public void cadastrar (ActionEvent event){
        LoginResponsavel.telaCadastro();
    }


    
}