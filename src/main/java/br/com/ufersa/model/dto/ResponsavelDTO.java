import java.util.List;
import main.java.br.com.ufersa.model.dto.crudDTO;
import main.java.br.com.ufersa.model.entities.Responsavel;

public interface ResponsavelDTO extends crudDTO {
    Responsavel findByTelefone(Responsavel responsavel);
    List<Responsavel> getAll();
}
