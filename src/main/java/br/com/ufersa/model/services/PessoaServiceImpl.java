package br.com.ufersa.model.services;
import br.com.ufersa.model.dao.PessoaDAO;
import br.com.ufersa.model.dao.PessoaDAOImpl;
import br.com.ufersa.model.entities.Cliente;
import br.com.ufersa.model.entities.Pessoa;

import java.util.List;

public class PessoaServiceImpl implements PessoaService {
    private final PessoaDAO pessoaDAO ;  // Inversão de dependencia

    public PessoaServiceImpl(PessoaDAO pessoaDAO) {
        this.pessoaDAO = pessoaDAO;
    }

    @Override
    public void mudarNome(Pessoa  pessoa) throws IllegalArgumentException{
        if (validarAttr(pessoa) ) {
            pessoaDAO.update(pessoa);
        } else {
            throw   new IllegalArgumentException("Nenhum nome passado para atualização.");
        }
    }

    @Override
    public void mudarEndereco(Pessoa   pessoa){
        if (validarAttr(pessoa)) {
            pessoaDAO.update(pessoa);
        } else {
            throw  new IllegalArgumentException("Nenhum endereço passado para atualização.");
        }
    }
    // TODO - mudar atributo de acordo com resposta
    @Override
   public  Pessoa getPessoaById(Pessoa  pessoa){
        if (validarAttr(pessoa)) return  pessoaDAO.findById(pessoa);
        else throw  new IllegalArgumentException("Nenhum id passado para a busca");
   }
   @Override
    public List<Pessoa> getAllPessoas(){
        return pessoaDAO.getAll();
    }
    public static <T> boolean validarAttr( T pessoa) {
        return (pessoa != null);
    }

}
