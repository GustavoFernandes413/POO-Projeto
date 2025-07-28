package br.com.ufersa.presenter.locais;

import br.com.ufersa.model.dao.LocaisDAOImpl;
import br.com.ufersa.model.entities.Locais;
import br.com.ufersa.model.services.LocaisService;
import br.com.ufersa.model.services.LocaisServiceImpl;
import br.com.ufersa.view.LoginResponsavel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import javax.swing.*;

public class TelaCadastroLocaisPresenter {
    @FXML
    private TextField NomeCasa;
    @FXML
    private TextField LocalCompartimento;
    @FXML private Label erro;


    LocaisService locaisService = new LocaisServiceImpl(new LocaisDAOImpl());
    Locais local = new Locais();
    public  void cadastrar(ActionEvent event){
        local.setNomeCasa(NomeCasa.getText());
        local.setNomeCompartimento(LocalCompartimento.getText());
        try {
            locaisService.cadastrarLocal(local);
            JOptionPane.showMessageDialog(null, "Novo Local Cadastrado com sucesso!");
            LoginResponsavel.telaPrincipalCadastro();
        }catch (Exception e){
            erro.setText(e.getMessage());
            erro.setTextFill(Color.RED);
            erro.setVisible(true);
        }

    }
    @FXML public void voltar(ActionEvent event){
        LoginResponsavel.telaPrincipalCadastro();
    }
}
