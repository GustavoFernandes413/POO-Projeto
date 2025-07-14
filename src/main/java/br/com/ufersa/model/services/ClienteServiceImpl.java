package br.com.ufersa.model.services;

import br.com.ufersa.model.entities.Cliente;
import br.com.ufersa.model.entities.Pessoa;

import java.util.List;

public class ClienteServiceImpl  {
        private final PessoaService pessoaService;
        // TODO: passar objetos pelas camadas

        public ClienteServiceImpl(PessoaService pessoaService) {
            this.pessoaService = pessoaService;
        }
    
        public void mudarNome(Cliente cliente){
            pessoaService.mudarNome( cliente);
        }
        public void mudarEndereco(Cliente cliente){
            pessoaService.mudarEndereco(cliente);
        }
        public Pessoa  getPessoaById(Cliente cliente) {
           return pessoaService.getPessoaById(cliente);
        }
        public List<Pessoa> getAllPessoas() {
            return pessoaService.getAllPessoas();
        }

}
