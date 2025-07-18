package br.com.ufersa.model.services;
import br.com.ufersa.model.dao.PessoaDAOImpl;
import br.com.ufersa.model.entities.Pessoa;

import java.util.List;

public class PessoaServiceImpl implements PessoaService {
    private final PessoaDAOImpl pessoaDTO =  new PessoaDAOImpl();

    @Override
    public void mudarNome(Pessoa  pessoa){
        if (validarAttr(pessoa) ) {
            pessoaDTO.save(pessoa);
        } else {
            throw  new IllegalArgumentException("Nenhum nome passado para atualização.");
        }
    }
    @Override
    public void mudarEndereco(Pessoa   pessoa){
        if (validarAttr(pessoa)) {
            pessoaDTO.save(pessoa);
        } else {
            throw  new IllegalArgumentException("Nenhum endereço passado para atualização.");
        }
    }
    @Override
   public  Pessoa getPessoaById(Pessoa pessoa){
        if (validarAttr(pessoa)) return  pessoaDTO.findById(pessoa);
        else throw  new IllegalArgumentException("Nenhum id passado para a busca");
   }
   @Override
    public List<Pessoa> getAllPessoas(){
        return pessoaDTO.getAll();
    }
    public static boolean validarAttr(Pessoa pessoa) {
        return (pessoa != null);
    }

}
