package br.com.ufersa.model.services;

import br.com.ufersa.exceptions.AutenticacaoException;
import br.com.ufersa.model.dao.ResponsavelDAO;
import br.com.ufersa.model.dao.ResponsavelDAOImpl;
import br.com.ufersa.model.entities.Cliente;
import br.com.ufersa.model.entities.Pessoa;
import br.com.ufersa.model.entities.Responsavel;
import java.util.List;

public class ResponsavelServiceImpl implements ResponsavelService {

    private final ResponsavelDAO responsavelDAO ;
    private final PessoaService pessoaService;

    // é feita a injecao de dependencia via construtor
    public ResponsavelServiceImpl(ResponsavelDAO responsavelDAO, PessoaService pessoaService) {
        this.responsavelDAO = responsavelDAO;
        this.pessoaService = pessoaService;
    }

    @Override
    public Responsavel autenticar(Responsavel responsavel) throws AutenticacaoException {
        Responsavel responsavelogin = responsavelDAO.findByLogin(responsavel);
       if (responsavelogin != null){
            if(responsavelogin.getSenha().equals(responsavel.getSenha()) ) {
                responsavel.setLogin(responsavel.getLogin());
                responsavel.setSenha(responsavel.getSenha());
                return responsavel;
           }else {
                throw new AutenticacaoException("Senha incorreta.");
            }
       }else  {
           throw  new AutenticacaoException("Responsavel não encontrado.");
        }
    }


    @Override
    public void mudarTelefone(Responsavel responsavel) {
        if (responsavel != null) {
            responsavelDAO.update(responsavel);
        } else {
            throw new IllegalArgumentException("Telefone informado é inválido");
        }
    }
    // = metodo de registro de responsaveis
    @Override
    public void cadastrarResponsavel(Responsavel responsavel){
        // TODO implementar metodo que verifica se o cliente ja existe
        if( responsavelDAO.findById(responsavel) != null){
            throw new IllegalArgumentException("Cliente já existente");
        }
        responsavelDAO.save(responsavel);
    }

    public void mudarNome(Pessoa pessoa){
        pessoaService.mudarNome( pessoa);
    }
    public void mudarEndereco(Pessoa pessoa){
        pessoaService.mudarEndereco(pessoa);
    }

    public Responsavel getPessoaById(Responsavel responsavel) {
        return responsavelDAO.findById(responsavel);
    }
    public List<Pessoa> getAllPessoas() {
        return pessoaService.getAllPessoas();
    }


}
