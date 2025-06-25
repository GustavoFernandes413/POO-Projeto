package br.com.ufersa.model.services;
import br.com.ufersa.model.dao.PessoaDAOImpl;
import br.com.ufersa.model.entities.Pessoa;

import java.util.List;

public class PessoaServiceImpl implements PessoaService {
    private final PessoaDAOImpl pessoaDTO =  new PessoaDAOImpl();

    @Override
    public void mudarNome(Long id, String nomeP){
        if (validarAttr(nomeP) || validarAttr(id)) {
            Pessoa pessoa = pessoaDTO.findById(id);
            pessoa.setNome(nomeP);
            pessoaDTO.save(pessoa);
        } else {
            throw  new IllegalArgumentException("Nenhum nome passado para atualização.");
        }
    }
    @Override
    public void mudarEndereco(Long id, String enderecoP){
        if (validarAttr(enderecoP) || validarAttr(id)) {
            Pessoa pessoa = pessoaDTO.findById(id);
            pessoa.setEndereco(enderecoP);
            pessoaDTO.save(pessoa);
        } else {
            throw  new IllegalArgumentException("Nenhum endereço passado para atualização.");
        }
    }
    @Override
   public  Pessoa getPessoaById(Long id){
        if (validarAttr(id)) return  pessoaDTO.findById(id);
        else throw  new IllegalArgumentException("Nenhum id passado para a busca");
   }
   @Override
    public List<Pessoa> getAllPessoas(){
        return pessoaDTO.getAll();
    }

    public static boolean validarAttr(String str) {
        return (!str.isBlank());
    }
    public static boolean validarAttr(Long id) {
        return (id > 0);
    }

}
