import java.util.List;
import main.java.br.com.ufersa.model.dto.crudDTO;
import main.java.br.com.ufersa.model.entities.Cliente;

public interface ClienteDTO extends crudDTO {
    Cliente findByCPF(Cliente cliente);
    List<Cliente> getAll();
}
