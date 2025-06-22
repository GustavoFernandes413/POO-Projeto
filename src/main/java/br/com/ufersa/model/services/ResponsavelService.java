package br.com.ufersa.model.services;

public interface ResponsavelService extends PessoaService {
    void mudarTelefone(Long id, String novoT);
}
