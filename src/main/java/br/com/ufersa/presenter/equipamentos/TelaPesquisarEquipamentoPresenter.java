package br.com.ufersa.presenter.equipamentos;

import br.com.ufersa.model.dao.EquipamentosDAOImpl;
import br.com.ufersa.model.entities.Equipamentos;
import br.com.ufersa.model.entities.Locais;
import br.com.ufersa.model.entities.Responsavel;
import br.com.ufersa.model.services.EquipamentosService;
import br.com.ufersa.model.services.EquipamentosServiceImpl;
import br.com.ufersa.presenter.util.PresenterUtil;
import br.com.ufersa.presenter.vendas.TelaTabelaItemPresenter;
import br.com.ufersa.presenter.vendas.TelaTabelaVendasPresenter;
import br.com.ufersa.view.LoginResponsavel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TelaPesquisarEquipamentoPresenter implements Initializable {


    @FXML private ComboBox<String> paramDePesquisa;
    @FXML private TextField textoPesquisa;
    @FXML private Button buscarButton;
    @FXML private TelaTabelaEquipamentosPresenter minhaTabelaEquipamentosController;
    private EquipamentosService equipamentosService = new EquipamentosServiceImpl(new EquipamentosDAOImpl());
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        paramDePesquisa.getItems().addAll("Nome", "N° de série", "Responsavel", "Local");

    }
    public void handleBuscar(ActionEvent actionEvent) {
        String parametro = paramDePesquisa.getValue();
        String termo = textoPesquisa.getText();
        List<Equipamentos> resultados = List.of();
        Equipamentos equipamentosParaBusca = new Equipamentos();
        try {
            if (termo == null || termo.trim().isEmpty()) {
            } else {
                switch (parametro) {
                    case "Nome":
                        equipamentosParaBusca.setNome(termo);
                        resultados = equipamentosService.findByNome(equipamentosParaBusca);
                        break;
                    case "N° de série":
                        equipamentosParaBusca.setNumeroSerie(termo);
                        resultados = equipamentosService.findByNSerie(equipamentosParaBusca);
                          break;
                    case "Responsavel":
                        Responsavel responsavel = new Responsavel();
                        responsavel.setNome(termo);
                        equipamentosParaBusca.setResponsavel(responsavel);
                        resultados = equipamentosService.findByResponsavel(equipamentosParaBusca);
                        break;
                    case "Local":
                        Locais locais = new Locais();
                        locais.setNomeCasa(termo);
                        equipamentosParaBusca.setLocal(locais);
                        resultados = equipamentosService.findByLocal(equipamentosParaBusca);
                        break;
                }
            }
            PresenterUtil.carregarTabelaEquipamentos(minhaTabelaEquipamentosController.getTabelaEquipamentos(), resultados);
        } catch (Exception e) {
            PresenterUtil.exibirAlerta("Erro na pesquisa", "Não foi possíve realizar a busca");
        }
    }
    }


