package br.com.ufersa;

import br.com.ufersa.model.dao.ClienteDAOImpl;
import br.com.ufersa.model.dao.PessoaDAOImpl;
import br.com.ufersa.model.entities.Cliente;
import br.com.ufersa.model.entities.Equipamentos;
import br.com.ufersa.model.entities.Locais;
import br.com.ufersa.model.entities.Pessoa;
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
       // Cliente cliente = new Cliente( "Patolino", "Casa do Perna longa","111.222.333-44");
//        Pessoa cliente = clienteService.getPessoaById(Long.valueOf(1));
//                cliente.setNome("Perna longa");
//                cliente.setEndereco("Casa da Lola");
//                clienteService.getAllPessoas().forEach(System.out::println);
    }
}
