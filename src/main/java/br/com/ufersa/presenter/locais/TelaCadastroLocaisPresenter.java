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
    Locais localSelecionado;

    public void salvar(ActionEvent event) {
         if(localSelecionado == null) cadastrar();
         else editar();

    }
    public  void cadastrar(){
        Locais local = new Locais();
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
    public  void editar(){
        localSelecionado.setNomeCasa(NomeCasa.getText());
        localSelecionado.setNomeCompartimento(LocalCompartimento.getText());
        try {
            locaisService.editarLocais(localSelecionado);
            JOptionPane.showMessageDialog(null, "Local atualizado com sucesso!");
            LoginResponsavel.telaTabelaLocais(); // volta para a tabela ao atualizar
        }catch (Exception e){
            erro.setText(e.getMessage());
            erro.setTextFill(Color.RED);
            erro.setVisible(true);
        }

    }
    // sera chamado ao clicar link da tabela
    public  void carregarLocalEdicao(Locais local){
        this.localSelecionado = local;
        NomeCasa.setText(local.getNomeCasa());
        LocalCompartimento.setText(local.getNomeCompartimento());
    }
    @FXML public void voltar(ActionEvent event){
        LoginResponsavel.telaPrincipalCadastro();
    }
}
