package br.com.ufersa.model.services;

import br.com.ufersa.model.entities.Responsavel;

public interface ResponsavelService extends PessoaService<Responsavel> {

    void mudarTelefone(Responsavel responsavel);
    void cadastrarResponsavel(Responsavel responsavel);
}
