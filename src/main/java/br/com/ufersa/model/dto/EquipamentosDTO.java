import java.util.List;
import main.java.br.com.ufersa.model.dto.crudDTO;
import main.java.br.com.ufersa.model.entities.Equipamentos;

public interface EquipamentosDTO extends crudDTO {
    List<Equipamentos> getall();
    Equipamentos findByName(Equipamentos equipamentos);
}
