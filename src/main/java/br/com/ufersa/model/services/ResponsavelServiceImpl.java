package br.com.ufersa.model.services;

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
    public void mudarTelefone(Responsavel responsavel) {
        if (responsavel != null) {
            responsavelDAO.update(responsavel);
        } else {
            throw new IllegalArgumentException("Telefone informado é inválido");
        }
    }
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
    public Pessoa getPessoaById(Pessoa pessoa) {
        return pessoaService.getPessoaById(pessoa);
    }
    public List<Pessoa> getAllPessoas() {
        return pessoaService.getAllPessoas();
    }

}
