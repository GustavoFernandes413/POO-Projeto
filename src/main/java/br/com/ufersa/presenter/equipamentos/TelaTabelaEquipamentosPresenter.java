package br.com.ufersa.presenter.equipamentos;

import br.com.ufersa.model.dao.LocaisDAOImpl;
import br.com.ufersa.model.entities.Equipamentos;
import br.com.ufersa.model.entities.Locais;
import br.com.ufersa.model.entities.Responsavel;
import br.com.ufersa.model.services.LocaisService;
import br.com.ufersa.model.services.LocaisServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class TelaTabelaEquipamentosPresenter {
    @FXML
    private TableView<Equipamentos> tabelaEquipamentos;

    @FXML
    private TableColumn<Equipamentos, String> colNumeroSerie;

    @FXML
    private TableColumn<Equipamentos, String> colNomeEquipamento;
    @FXML
    private TableColumn<Equipamentos, Double> colPreco;
    @FXML
    private TableColumn<Equipamentos, Integer> colEstoque;
    @FXML
    private TableColumn<Equipamentos, Locais> colLocal;
    @FXML
    private TableColumn<Equipamentos, Responsavel> colResponsavel;
    @FXML
    private TableColumn<Equipamentos, Void> colAcoes;

    private final LocaisService locaisService = new LocaisServiceImpl(new LocaisDAOImpl());

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colNomeCasa.setCellValueFactory(new PropertyValueFactory<Locais, String>("nomeCasa"));
        colNomeCompartimento.setCellValueFactory(new PropertyValueFactory<Locais, String>("nomeCompartimento"));
        renderizarColunaAcoes();
        dadosLocais();
    }
}
