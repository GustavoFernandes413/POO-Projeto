package br.com.ufersa.presenter.clientes;

import br.com.ufersa.model.dao.LocaisDAOImpl;
import br.com.ufersa.model.dao.PessoaDAOImpl;
import br.com.ufersa.model.entities.Locais;
import br.com.ufersa.model.services.LocaisService;
import br.com.ufersa.model.services.LocaisServiceImpl;
import br.com.ufersa.model.services.PessoaServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TelaTabelaClientesPresenter implements Initializable {
    @FXML
    private TableView<Locais> tabelaLocais;

    @FXML
    private TableColumn<Locais, String> colNomeCasa;

    @FXML
    private TableColumn<Locais, String> colNomeCompartimento;

    private final LocaisService locaisService = new LocaisServiceImpl(new LocaisDAOImpl());
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colNomeCasa.setCellValueFactory(new PropertyValueFactory<Locais, String>("nomeCasa"));
        colNomeCompartimento.setCellValueFactory(new PropertyValueFactory<Locais, String>("nomeCompartimento"));
        dadosLocais();
    }

    public void dadosLocais(){
        List<Locais> listaLocais = locaisService.getAllLocais();
        ObservableList<Locais> observableListLocais = FXCollections.observableArrayList(listaLocais);
        tabelaLocais.setItems(observableListLocais);
    }
}
