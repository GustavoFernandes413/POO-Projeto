package br.com.ufersa.presenter;

import br.com.ufersa.view.LoginResponsavel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class TelaPrincipal {
    @FXML public void irTelaPesquisa (ActionEvent event){
        LoginResponsavel.telaPesquisaEquipamento();
    }
    @FXML public void IrTelaCompraEVenda (ActionEvent event){
        LoginResponsavel.telaCadastroVendas();
    }
    @FXML public void IrTelaCadastroEdicao (ActionEvent event){
        LoginResponsavel.telaPrincipalCadastro();
    }
    @FXML public void IrTelaListagem(ActionEvent event){LoginResponsavel.telaPrincipalListagem();}
    @FXML public void logOut(ActionEvent event){LoginResponsavel.telaLogin();}


}
