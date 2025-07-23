package br.com.ufersa.model.services;

import br.com.ufersa.model.dao.ClienteDAO;
import br.com.ufersa.model.entities.Cliente;
import br.com.ufersa.model.entities.Pessoa;

import java.util.List;

// TODO: precisa-se fazer modificações nas validacoes
// essa classe usa pessoaService porque dentro dela eu defini alguns metodos que serao usados por Responsavel e Cliente

public class ClienteServiceImpl  implements ClienteService{
        private final PessoaService pessoaService; // depende da abstração da classe pessoa, sua interface
        private final ClienteDAO clienteDAO;

        public ClienteServiceImpl(PessoaService pessoaService, ClienteDAO clienteDAO) {
            this.pessoaService = pessoaService;
            this.clienteDAO = clienteDAO;
        }
        // TODO - verificar se esta de acordo com boas praticas
        public void mudarNome(Pessoa cliente){
            pessoaService.mudarNome( cliente);
        }
        public void mudarEndereco(Pessoa cliente){
            pessoaService.mudarEndereco(cliente);
        }
        @Override
        public Cliente  getPessoaById(Cliente cliente) {
            return clienteDAO.findById(cliente);
        }
        public List<Pessoa> getAllPessoas() {
            return pessoaService.getAllPessoas();
        }
        @Override
        public void cadastrarCliente(Cliente cliente){
            // TODO implementar metodo que verifica se o cliente ja existe
            if( clienteDAO.findByCPF(cliente) != null){
               throw new IllegalArgumentException("Cliente já existente");
            }
            clienteDAO.save(cliente);
        }

}
