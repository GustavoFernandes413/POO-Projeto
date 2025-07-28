package br.com.ufersa.presenter;

import br.com.ufersa.view.LoginResponsavel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class EquipamentosPresenter {
    @FXML
    public void voltar (ActionEvent event){
        LoginResponsavel.telaPrincipal();
    }
}
