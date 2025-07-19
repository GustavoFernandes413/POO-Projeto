package br.com.ufersa.model.services;

import br.com.ufersa.model.dao.ResponsavelDAOImpl;
import br.com.ufersa.model.entities.Pessoa;
import br.com.ufersa.model.entities.Responsavel;
import java.util.List;

public class ResponsavelServiceImpl implements ResponsavelService {

    private final ResponsavelDAOImpl responsavelDTO = new ResponsavelDAOImpl();
    private final PessoaService pessoaService;

    public ResponsavelServiceImpl(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @Override
    public void mudarTelefone(Responsavel responsavel) {
        if (responsavel != null) {
            responsavelDTO.update(responsavel);
        } else {
            throw new IllegalArgumentException("Telefone informado é inválido");
        }
    }


    public void mudarNome(Pessoa pessoa){
        pessoaService.mudarNome( pessoa);
    }
    public void mudarEndereco(Pessoa pessoa){
        pessoaService.mudarEndereco(pessoa);
    }
    public Pessoa getPessoaById(Long pessoa) {
        return pessoaService.getPessoaById(pessoa);
    }
    public List<Pessoa> getAllPessoas() {
        return pessoaService.getAllPessoas();
    }

}
