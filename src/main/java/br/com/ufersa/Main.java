package br.com.ufersa;

import br.com.ufersa.model.dao.*;
import br.com.ufersa.model.entities.*;
import br.com.ufersa.model.services.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        PessoaService pessoaService = new PessoaServiceImpl(new PessoaDAOImpl());
//        LocaisService locaisService = new LocaisServiceImpl(new LocaisDAOImpl()) ;
        ResponsavelService responsavelService = new ResponsavelServiceImpl(new ResponsavelDAOImpl(), pessoaService);
//        EquipamentosService equipamentosService = new EquipamentosServiceImpl(new EquipamentosDAOImpl());
//        ClienteService clienteService = new ClienteServiceImpl(pessoaService,new ClienteDAOImpl() );
//        VendasService vendasService = new VendasServiceImpl(new VendasDAOImpl());
//        ObserverVendas vendasObserver = new EquipamentosServiceImpl(new EquipamentosDAOImpl());
//
//        // criando locais e responsaveis
//        Locais locais = new Locais( "Quarto", "Casa do Perna-Longa");
//        locaisService.cadastrarLocal(locais);
//
//        Pessoa pessoa = new Pessoa("Patolino", "Warner Bros");
//        Cliente cliente = new Cliente( pessoa.getNome(), pessoa.getEndereco(),"111.222.333-44");
//        //clienteService.cadastrarCliente(cliente);
//
        Responsavel responsavel = new Responsavel("Kanalense", "Casa do Kanalense", "kanalense@gmail.com", "123456", "85 9 8899-0011");
        responsavelService.cadastrarResponsavel(responsavel);
//
//        Cliente clienteVen = new Cliente();
//        clienteVen.setId(1L);
//        Cliente clienteId = clienteService.getPessoaById(clienteVen);
////        Locais localEq = new Locais();
////        localEq.setId(1L);
//        Locais locId = locaisService.getLocalById(1L);
//        Responsavel responsavelEq = new Responsavel();
//        responsavelEq.setId(2L);
//        Responsavel responsavelId = responsavelService.getPessoaById(responsavelEq);
//        Equipamentos equipamentos = new Equipamentos();
//        equipamentos.setId(2L);
//        Equipamentos equipamentoId = equipamentosService.getEquipamentoById(equipamentos);
//
//        vendasService.addObserver(vendasObserver);
//
//        Equipamentos equipamento = new Equipamentos("Mouse Dragon", Long.valueOf(12398230),
//                139.99, 14, locId, responsavelId);
//        //equipamentosService.cadastraEquipamento(equipamento);
//        Equipamentos equi01 =  new Equipamentos();
//        Equipamentos equi02 =  new Equipamentos();
//        Equipamentos equi03 =  new Equipamentos();
//        equi01.setId(1L);
//        equi02.setId(2L);
//
//
//
//
//
//
//        // construcao de venda usando builder
//        Vendas venda02 = new Vendas.Builder().data(Timestamp.valueOf("2021-04-04 08:30:00"))
//                .cliente(clienteId)
//                .responsavel(responsavelId)
//                .status(StatusCompra.CONCLUIDA)
//                .codigoVenda(1231032L)
//                .addItem(new ItemVenda(equipamentosService.getEquipamentoById(equi01), 6))
//                .addItem(new ItemVenda(equipamentosService.getEquipamentoById(equi02), 3))
//                .build();
//        vendasService.criarVenda(venda02);
//        Vendas vendaCancelamento = new Vendas();
//        vendaCancelamento.setId(3L);
//        Vendas vendaId = vendasService.getVendaById(vendaCancelamento);
//        //vendasService.cancelamento(vendaId);
//

    }
}
