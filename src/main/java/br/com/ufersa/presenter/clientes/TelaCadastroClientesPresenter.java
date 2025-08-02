package br.com.ufersa.presenter.clientes;

import br.com.ufersa.model.dao.ClienteDAOImpl;
import br.com.ufersa.model.dao.PessoaDAOImpl;
import br.com.ufersa.model.entities.Cliente;
import br.com.ufersa.model.entities.Locais;
import br.com.ufersa.model.entities.Responsavel;
import br.com.ufersa.model.services.ClienteService;
import br.com.ufersa.model.services.ClienteServiceImpl;
import br.com.ufersa.model.services.PessoaServiceImpl;
import br.com.ufersa.presenter.util.NavigationManager;
import br.com.ufersa.presenter.util.PresenterUtil;
import br.com.ufersa.view.LoginResponsavel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;

import javax.swing.*;
import java.util.List;

public class TelaCadastroClientesPresenter {
    @FXML
    private TextField nomeCliente;
    @FXML
    private TextField enderecoCliente;
    @FXML
    private TextField cpfCliente;
    @FXML
    private Button voltarButton;
    @FXML
    private Button salvarButton;
    @FXML
    private Label erro;
    // TODO ao editar um elemento ou salvar, a tabela deve ser atualizada ao fechar janela de cadastro
    ClienteService clienteService = new ClienteServiceImpl(new PessoaServiceImpl(new PessoaDAOImpl()), new ClienteDAOImpl());
    Cliente clienteSelecionado;


    public void salvar(ActionEvent event) {
        if(clienteSelecionado == null) cadastrarCliente();
        else editarCliente();

    }

    public void cadastrarCliente() {
        Cliente cliente = new Cliente();

        cliente.setNome(nomeCliente.getText());
        cliente.setEndereco(enderecoCliente.getText());
        cliente.setCpf(cpfCliente.getText());
        try {
            clienteService.cadastrarCliente(cliente);
            JOptionPane.showMessageDialog(null, "Novo Cliente cadastrado com sucesso!");
            NavigationManager.fecharJanela(salvarButton);
        } catch (Exception e) {
            erro.setText(e.getMessage());
            erro.setTextFill(Color.RED);
            erro.setVisible(true);
        }
    }
    public void editarCliente() {
        clienteSelecionado.setNome(nomeCliente.getText());
        clienteSelecionado.setEndereco(enderecoCliente.getText());
        clienteSelecionado.setCpf(clienteSelecionado.getCpf());
        try {
            clienteService.editarCliente(clienteSelecionado);
            JOptionPane.showMessageDialog(null, "Cliente editado com sucesso!");
            NavigationManager.fecharJanela(salvarButton);
        } catch (Exception e) {
            erro.setText(e.getMessage());
            erro.setTextFill(Color.RED);
            erro.setVisible(true);
        }
    }

    public  void carregarClienteParaEdicao(Cliente cliente){
        this.clienteSelecionado = cliente;
        nomeCliente.setText(cliente.getNome());
        enderecoCliente.setText(cliente.getEndereco());
        cpfCliente.setText(cliente.getCpf());
        cpfCliente.setDisable(true);

    }

    @FXML
    public void voltar(ActionEvent event) {
        NavigationManager.fecharJanela(voltarButton);
    }


}
