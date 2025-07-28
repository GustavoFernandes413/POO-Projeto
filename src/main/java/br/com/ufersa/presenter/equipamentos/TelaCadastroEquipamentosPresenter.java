package br.com.ufersa.presenter.equipamentos;

import br.com.ufersa.model.dao.EquipamentosDAOImpl;
import br.com.ufersa.model.dao.LocaisDAOImpl;
import br.com.ufersa.model.dao.PessoaDAOImpl;
import br.com.ufersa.model.dao.ResponsavelDAOImpl;
import br.com.ufersa.model.entities.Equipamentos;
import br.com.ufersa.model.entities.Locais;
import br.com.ufersa.model.entities.Responsavel;
import br.com.ufersa.model.services.*;
import br.com.ufersa.view.LoginResponsavel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TelaCadastroEquipamentosPresenter implements Initializable {
    @FXML
    private TextField nomeEquipamento;
    @FXML
    private TextField numeroSerie;
    @FXML
    private TextField quantidade;
    @FXML
    private TextField preco;
    @FXML
    private Label erro;

    @FXML
    private ComboBox<Locais> localEquipamento;
    @FXML
    private ComboBox<Responsavel> responsavelEquipamento;

    EquipamentosService equipamentosService = new EquipamentosServiceImpl(new EquipamentosDAOImpl());
    LocaisService locaisService = new LocaisServiceImpl(new LocaisDAOImpl());
    ResponsavelService responsavelService = new ResponsavelServiceImpl(new ResponsavelDAOImpl(), new PessoaServiceImpl(new PessoaDAOImpl()));

    Equipamentos equipamentoSelecionado ;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarLocais();
        carregarResponsaveis();
    }

    public void salvar(ActionEvent event) {
        if(equipamentoSelecionado == null) cadastrar();
        else editar();

    }

    public void cadastrar() {
        Equipamentos equipamentoPersistir = new Equipamentos();

        equipamentoPersistir.setNome(nomeEquipamento.getText());
        equipamentoPersistir.setNumeroSerie(Long.valueOf(numeroSerie.getText()));
        equipamentoPersistir.setQuantidadeEstoque(Integer.parseInt(quantidade.getText()));
        equipamentoPersistir.setPreco(Double.parseDouble(preco.getText()));
        equipamentoPersistir.setLocal( localEquipamento.getSelectionModel().getSelectedItem());
        equipamentoPersistir.setResponsavel( responsavelEquipamento.getSelectionModel().getSelectedItem());

        try {
            equipamentosService.cadastraEquipamento(equipamentoPersistir);
            JOptionPane.showMessageDialog(null, "Novo Equipamento cadastrado com sucesso!");
        } catch (Exception e) {
            erro.setText(e.getMessage());
            erro.setTextFill(Color.RED);
            erro.setVisible(true);
        }

    }

    public void editar() {
        equipamentoSelecionado.setNome(nomeEquipamento.getText());
        equipamentoSelecionado.setNumeroSerie(Long.valueOf(numeroSerie.getText()));
        equipamentoSelecionado.setQuantidadeEstoque(Integer.parseInt(quantidade.getText()));
        equipamentoSelecionado.setPreco(Double.parseDouble(preco.getText()));
        equipamentoSelecionado.setLocal( localEquipamento.getSelectionModel().getSelectedItem());
        equipamentoSelecionado.setResponsavel( responsavelEquipamento.getSelectionModel().getSelectedItem());

        try {
            equipamentosService.editarEquipamento(equipamentoSelecionado);
            JOptionPane.showMessageDialog(null, " Equipamento editado com sucesso!");

        } catch (Exception e) {
            erro.setText(e.getMessage());
            erro.setTextFill(Color.RED);
            erro.setVisible(true);
        }

    }

    private void carregarLocais() {
        List<Locais> locaisList = locaisService.getAllLocais();
        ObservableList<Locais> observableLocais = FXCollections.observableArrayList(locaisList);
        localEquipamento.setItems(observableLocais);
    }

    private void carregarResponsaveis() {
        List<Responsavel> responsavelList = responsavelService.getAllPessoas();
        ObservableList<Responsavel> observableLocais = FXCollections.observableArrayList(responsavelList);
        responsavelEquipamento.setItems(observableLocais);
    }

    // sera chamado ao clicar link da tabela
    public  void carregarEquipamentoEdicao(Equipamentos equipamento){
        this.equipamentoSelecionado = equipamento;
        nomeEquipamento.setText(equipamento.getNome());
        numeroSerie.setText(String.valueOf(equipamento.getNumeroSerie()));
        quantidade.setText(String.valueOf(equipamento.getQuantidadeEstoque()));
        preco.setText(String.valueOf(equipamento.getPreco()));
        responsavelEquipamento.setValue(equipamento.getResponsavel());
        localEquipamento.setValue(equipamento.getLocal());
    }
    @FXML public void voltar(ActionEvent event){
        LoginResponsavel.telaPrincipalCadastro();
    }




}
