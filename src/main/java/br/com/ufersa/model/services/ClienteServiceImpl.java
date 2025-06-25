package br.com.ufersa.model.services;

import br.com.ufersa.model.entities.Pessoa;

import java.util.List;

public class ClienteServiceImpl  {
        private final PessoaService pessoaService;
        // TODO: passar objetos pelas camadas

        public ClienteServiceImpl(PessoaService pessoaService) {
            this.pessoaService = pessoaService;
        }
    
        public void mudarNome(long id, String nome){
            pessoaService.mudarNome( id,  nome);
        }
        public void mudarEndereco(long id, String enderecoP){
            pessoaService.mudarEndereco(id,  enderecoP);
        }
        public Pessoa  getPessoaById(long id) {
           return pessoaService.getPessoaById(id);
        }
        public List<Pessoa> getAllPessoas() {
            return pessoaService.getAllPessoas();
        }

}
