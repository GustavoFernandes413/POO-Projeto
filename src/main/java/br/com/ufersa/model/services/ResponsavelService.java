package br.com.ufersa.model.services;

import br.com.ufersa.exceptions.AutenticacaoException;
import br.com.ufersa.exceptions.PessoaExisteException;
import br.com.ufersa.model.entities.Responsavel;

import java.util.List;

public interface ResponsavelService extends PessoaService<Responsavel> {
    Responsavel autenticar(Responsavel responsavel) throws AutenticacaoException;
    void mudarTelefone(Responsavel responsavel);
    void cadastrarResponsavel(Responsavel responsavel) throws PessoaExisteException;
}
