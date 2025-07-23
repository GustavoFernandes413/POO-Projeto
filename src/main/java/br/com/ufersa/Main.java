package br.com.ufersa;

import br.com.ufersa.model.dao.*;
import br.com.ufersa.model.entities.*;
import br.com.ufersa.model.services.*;

import java.sql.Timestamp;

public class Main {
    public static void main(String[] args) {
        PessoaService pessoaService = new PessoaServiceImpl(new PessoaDAOImpl());
        LocaisService locaisService = new LocaisServiceImpl() ;
        ResponsavelService responsavelService = new ResponsavelServiceImpl(new ResponsavelDAOImpl(),pessoaService);
        EquipamentosService equipamentosService = new EquipamentosServiceImpl(new EquipamentosDAOImpl());
        ClienteService clienteService = new ClienteServiceImpl(pessoaService,new ClienteDAOImpl() );
        VendasService vendasService = new VendasServiceImpl(new VendasDAOImpl());

        // criando locais e responsaveis
        Locais locais = new Locais( "Quarto", "Casa do Perna-Longa");
        locaisService.cadastrarLocal(locais);

        Pessoa pessoa = new Pessoa("Patolino", "Warner Bros");
        Cliente cliente = new Cliente( pessoa.getNome(), pessoa.getEndereco(),"111.222.333-44");
        //clienteService.cadastrarCliente(cliente);

        Responsavel responsavel = new Responsavel("Cleiton", "Casa do Cleiton", "85 9 8899-0011");
       // responsavelService.cadastrarResponsavel(responsavel);

        Cliente clienteVen = new Cliente();
        clienteVen.setId(1L);
        Cliente clienteId = clienteService.getPessoaById(clienteVen);
//        Locais localEq = new Locais();
//        localEq.setId(1L);
        Locais locId = locaisService.getLocalById(1L);
        Responsavel responsavelEq = new Responsavel();
        responsavelEq.setId(2L);
        Responsavel responsavelId = responsavelService.getPessoaById(responsavelEq);
        Equipamentos equipamentos = new Equipamentos();
        equipamentos.setId(1L);
        Equipamentos equipamentoId = equipamentosService.getEquipamentoById(equipamentos.getId());

       // Equipamentos equipamentos = new Equipamentos("Notebook Positivo Celeron", Long.valueOf(12398230),
       //         1.99, 10, locId, responsavelId);
        //equipamentosService.cadastraEquipamento(equipamentos);

        Vendas vendas = new Vendas(1231032L, clienteId, equipamentoId, locId, responsavelId,"Concluida", Timestamp.valueOf("2021-04-04 08:30:00"));
        vendasService.criarVenda(vendas);
    }
}
