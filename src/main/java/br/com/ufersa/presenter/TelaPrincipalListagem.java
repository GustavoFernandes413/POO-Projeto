package br.com.ufersa.presenter;

import br.com.ufersa.view.LoginResponsavel;
import javafx.fxml.FXML;

public class TelaPrincipalListagem {
    @FXML public void irTelaTabelaEquipamentos() {
        LoginResponsavel.telaTabelaEquipamentos();
    }
    @FXML public void irTelaTabelaLocais() {
        LoginResponsavel.telaTabelaLocais();
    }
    @FXML public void irTelaTabelaClientes() {LoginResponsavel.telaTabelaClientes();}
    @FXML public void voltar() {LoginResponsavel.telaPrincipal();}

}
