package br.com.ufersa.presenter;

import br.com.ufersa.view.LoginResponsavel;

public class TelaPrincipalVendasPresenter {
    public void irTelaVendas(){
        LoginResponsavel.telaCadastroVendas();
    }
    public void irRelatorioVendas(){
        LoginResponsavel.telaRelatorioVendas();
    }
    public void voltar(){
        LoginResponsavel.telaPrincipal();
    }
}
