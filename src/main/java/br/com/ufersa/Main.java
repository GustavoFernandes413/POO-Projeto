package br.com.ufersa;

import br.com.ufersa.model.dao.ClienteDAOImpl;
import br.com.ufersa.model.dao.PessoaDAOImpl;
import br.com.ufersa.model.dao.ResponsavelDAOImpl;
import br.com.ufersa.model.entities.*;
import br.com.ufersa.model.services.*;

public class Main {
    public static void main(String[] args) {
        //Locais locais = new Locais( "Quarto", "Casa do Perna-Longa");


//        LocaisServiceImpl locaisService = new LocaisServiceImpl() ;
//        locaisService.cadastrarLocal(locais);
//        Pessoa pessoa = new Pessoa("Patolino", "Warner Bros");
//        Cliente cliente = new Cliente( pessoa.getNome(), pessoa.getEndereco(),"111.222.333-44");
//        ClienteServiceImpl clienteService = new ClienteServiceImpl(pessoa);
//        System.out.println("Informacoes do objeto Local: " + locaisService.getLocalById(Long.valueOf(2)));
//        System.out.println( "FindByname: " +locaisService.findByNomeCasa( locais));
//
//         locaisService.getAllLocais();
//        Locais local = locaisService.getLocalById(Long.valueOf(1));
//        local.setNomeCompartimento("Sala");
//        local.setNomeCasa("Casa do Patolino");
//        locaisService.mudarLocal(local);
        PessoaService pessoaService = new PessoaServiceImpl(new PessoaDAOImpl());
        ClienteService clienteService = new ClienteServiceImpl(pessoaService, new ClienteDAOImpl());
     //   Cliente cliente = new Cliente( "Patolino", "Casa do Perna longa","111.222.333-44");
//        Cliente clienteId = new Cliente();
//        clienteId.setId(Long.valueOf(1));
//       Pessoa cliente = clienteService.getPessoaById(clienteId);
////                cliente.setNome("Perna longa");
////                cliente.setEndereco("Casa da Lola");
////                clienteService.getAllPessoas().forEach(System.out::println);
//        System.out.println(cliente);

        ResponsavelService responsavelService = new ResponsavelServiceImpl(new ResponsavelDAOImpl(),pessoaService);
      Responsavel responsavel = new Responsavel("Kanalense", "Casa do Joao", "84 9 8899-0011");
       // responsavelService.cadastrarResponsavel(responsavel);
        Pessoa responsavelId = new Responsavel();
            responsavelId.setId(Long.valueOf(2));
       // responsavelService.mudarTelefone(responsavel);
       // responsavelService.getAllPessoas().forEach(System.out::println);
        System.out.println( responsavelService.getPessoaById(responsavelId));
    }
}
