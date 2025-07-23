package br.com.ufersa;

import br.com.ufersa.model.dao.ClienteDAO;
import br.com.ufersa.model.dao.ClienteDAOImpl;
import br.com.ufersa.model.dao.PessoaDAOImpl;
import br.com.ufersa.model.dao.ResponsavelDAOImpl;
import br.com.ufersa.model.entities.*;
import br.com.ufersa.model.services.*;

public class Main {
    public static void main(String[] args) {
        PessoaService pessoaService = new PessoaServiceImpl(new PessoaDAOImpl());
        LocaisServiceImpl locaisService = new LocaisServiceImpl() ;
        ResponsavelService responsavelService = new ResponsavelServiceImpl(new ResponsavelDAOImpl(),pessoaService);
        EquipamentosService equipamentosService = new EquipamentosServiceImpl();

        // criando locais e responsaveis
        Locais locais = new Locais( "Quarto", "Casa do Perna-Longa");
        //locaisService.cadastrarLocal(locais);

        Pessoa pessoa = new Pessoa("Patolino", "Warner Bros");
        Cliente cliente = new Cliente( pessoa.getNome(), pessoa.getEndereco(),"111.222.333-44");
        ClienteServiceImpl clienteService = new ClienteServiceImpl(pessoaService,new ClienteDAOImpl() );
       // clienteService.cadastrarCliente(cliente);

        Responsavel responsavel = new Responsavel("Cleiton", "Casa do Cleiton", "85 9 8899-0011");
       // responsavelService.cadastrarResponsavel(responsavel);


        Locais localEq = new Locais();
        localEq.setId(1L);
        Locais locId = locaisService.getLocalById(localEq.getId());
        Responsavel responsavelEq = new Responsavel();
        responsavelEq.setId(2L);
        Responsavel responsavelId = responsavelService.getPessoaById(responsavelEq);

        Equipamentos equipamentos = new Equipamentos("Notebook Positivo Celeron", Long.valueOf(12398230),
                1.99, 10, locId, responsavelId);
        equipamentosService.cadastraEquipamento(equipamentos);
    }
}
