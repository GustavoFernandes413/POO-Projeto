package br.com.ufersa.presenter;

import br.com.ufersa.exceptions.PessoaExisteException;
import br.com.ufersa.model.dao.PessoaDAOImpl;
import br.com.ufersa.model.dao.ResponsavelDAOImpl;
import br.com.ufersa.model.entities.Responsavel;
import br.com.ufersa.model.services.PessoaServiceImpl;
import br.com.ufersa.model.services.ResponsavelService;
import br.com.ufersa.model.services.ResponsavelServiceImpl;
import br.com.ufersa.view.LoginResponsavel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import javax.swing.*;

public class ResponsavelPresenter {
    @FXML  private TextField RespCadNome;
    @FXML private TextField RespCadEmail;
    @FXML private TextField RespCadTelefone;
    @FXML private PasswordField RespCadSenha;
    @FXML private TextField RespCadEndereco;
    @FXML private Label erro;




    ResponsavelService responsavelService = new ResponsavelServiceImpl(new ResponsavelDAOImpl(), new PessoaServiceImpl(new PessoaDAOImpl()));
    //Responsavel novoResp = new Responsavel();




    @FXML public void retornar(){
        LoginResponsavel.telaLogin();
    }

    @FXML public void cadastrar(){
        Responsavel novoResp = new Responsavel(RespCadNome.getText(), RespCadEndereco.getText(),
                RespCadEmail.getText(), RespCadSenha.getText(), RespCadTelefone.getText());
        try {
            responsavelService.cadastrarResponsavel(novoResp);
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
            LoginResponsavel.telaLogin();
        } catch (PessoaExisteException e) {
            erro.setText(e.getMessage());
            erro.setTextFill(Color.RED);
            erro.setVisible(true);
        }

    }
}
