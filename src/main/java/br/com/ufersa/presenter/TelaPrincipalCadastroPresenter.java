package br.com.ufersa.presenter;

import br.com.ufersa.view.LoginResponsavel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class TelaPrincipalCadastroPresenter {
    @FXML public void irTelaCadastrarEquipamento(ActionEvent event){
        LoginResponsavel.telaCadastrarEquipamento();

    }
    @FXML public void irTelaCadastrarCliente(ActionEvent event){
        LoginResponsavel.telaCadastrarCliente();
    }
    @FXML public void irTelaCadastrarLocal(ActionEvent event){
        LoginResponsavel.telaCadastrarLocais();
    }
    @FXML public void Voltar(ActionEvent event){
        LoginResponsavel.telaPrincipal();
    }
}
