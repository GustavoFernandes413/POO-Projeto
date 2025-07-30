package br.com.ufersa.presenter.vendas;

import br.com.ufersa.model.dao.VendasDAOImpl;
import br.com.ufersa.model.entities.Vendas;
import br.com.ufersa.model.services.VendasService;
import br.com.ufersa.model.services.VendasServiceImpl;
import br.com.ufersa.presenter.util.PresenterUtil;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;

import javafx.event.ActionEvent;
import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class TelaRelatorioVendasPresenter implements Initializable
{
    @FXML private TelaTabelaVendasPresenter minhaTabelaVendasController;
    @FXML private DatePicker dataInicial;
    @FXML private DatePicker dataFinal;
    @FXML private Button botaoGerarRelatorio;

    VendasService vendasService = new VendasServiceImpl(new VendasDAOImpl());
    PresenterUtil presenterUtil = new PresenterUtil(vendasService);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

     public void  gerarRelatorioVendas(ActionEvent event)
    {
        List<Vendas> dadosRelatorio = carregarDadosRelatorio();
        if (dadosRelatorio.isEmpty())
        {
            presenterUtil.exibirAlerta("Erro ao carregar relatório", "Nenhuma venda feita neste período");
        }
        else {
            PresenterUtil.carregarVendas(minhaTabelaVendasController.getMinhaTabelaVendas(), dadosRelatorio);
        }
    }
    private List<Vendas> carregarDadosRelatorio(){
        LocalDate inicio = dataInicial.getValue();
        LocalDate fim = dataFinal.getValue();

        Vendas vendaInicio = new Vendas();
        Vendas vendaFim = new Vendas();

        Timestamp tsInicio = Timestamp.valueOf(inicio.atStartOfDay());
        Timestamp tsFim = Timestamp.valueOf(fim.atTime(23, 59, 59));

        vendaInicio.setData(tsInicio);
        vendaFim.setData(tsFim);

       return  vendasService.relatorio(vendaInicio, vendaFim);
    }


}
