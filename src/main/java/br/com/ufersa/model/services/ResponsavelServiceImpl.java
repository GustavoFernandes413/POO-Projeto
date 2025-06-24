package br.com.ufersa.model.services;

import br.com.ufersa.model.dto.ResponsavelDTOImpl;
import br.com.ufersa.model.entities.Pessoa;
import br.com.ufersa.model.entities.Responsavel;
import java.util.List;

public class ResponsavelServiceImpl implements ResponsavelService {

    private final ResponsavelDTOImpl responsavelDTO = new ResponsavelDTOImpl();
    private final PessoaService pessoaService;

    public ResponsavelServiceImpl(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @Override
    public void mudarTelefone(Long id, String telefoneR) {
        if (id > 0 && !telefoneR.isBlank()) {
            Responsavel responsavel = new Responsavel();
            responsavel.setTelefone(telefoneR);
            responsavelDTO.update(responsavel);
        } else {
            throw new IllegalArgumentException("Telefone informado é inválido");
        }
    }


    public void mudarNome(long id, String nome){
        pessoaService.mudarNome( id,  nome);
    }
    public void mudarEndereco(long id, String enderecoP){
        pessoaService.mudarEndereco(id,  enderecoP);
    }
    public Pessoa getPessoaById(long id) {
        return pessoaService.getPessoaById(id);
    }
    public List<Pessoa> getAllPessoas() {
        return pessoaService.getAllPessoas();
    }

}
