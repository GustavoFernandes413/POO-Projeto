import java.util.List;
import main.java.br.com.ufersa.model.dto.crudDTO;
import main.java.br.com.ufersa.model.entities.Locais;

public interface LocaisDTO extends crudDTO {
    List<Locais> getAll();
    Locais findByName(Locais local);
}
