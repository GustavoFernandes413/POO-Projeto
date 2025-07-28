package br.com.ufersa.presenter.clientes;

import br.com.ufersa.model.dao.ClienteDAOImpl;
import br.com.ufersa.model.dao.PessoaDAOImpl;
import br.com.ufersa.model.entities.Cliente;
import br.com.ufersa.model.services.ClienteService;
import br.com.ufersa.model.services.ClienteServiceImpl;
import br.com.ufersa.model.services.PessoaServiceImpl;
import br.com.ufersa.view.LoginResponsavel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;

import javax.swing.*;

public class TelaCadastroClientesPresenter  {
    @FXML
    private TextField nomeCliente;
    @FXML
    private TextField enderecoCliente;
    @FXML
    private TextField cpfCliente;
    @FXML
    private Label erro;

    ClienteService clienteService = new ClienteServiceImpl(new PessoaServiceImpl(new PessoaDAOImpl()), new ClienteDAOImpl());
    Cliente cliente = new Cliente();


    public void cadastrarCliente(ActionEvent event)  {
            cliente.setNome(nomeCliente.getText());
            cliente.setEndereco(enderecoCliente.getText());
            cliente.setCpf(cpfCliente.getText());
            try {
                clienteService.cadastrarCliente(cliente);
                JOptionPane.showMessageDialog(null, "Novo Cliente cadastrado com sucesso!");
                LoginResponsavel.telaPrincipalCadastro();
            } catch (Exception e) {
                erro.setText(e.getMessage());
                erro.setTextFill(Color.RED);
                erro.setVisible(true);
            }
    }
    @FXML public void voltar(ActionEvent event){
        LoginResponsavel.telaPrincipalCadastro();
    }

}
