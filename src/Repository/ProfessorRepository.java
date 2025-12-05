package Repository;

import Model.ProfessorModel;
import java.util.HashMap;
import java.util.Map;

public class ProfessorRepository {

    private Map<Integer, ProfessorModel> professores = new HashMap<>();

    // Salvar professor no repositório
    public void salvar(ProfessorModel professor) {
        professores.put(professor.getRegistro(), professor);
    }

    // Buscar professor pelo registro
    public ProfessorModel buscar(int registro) {
        return professores.get(registro);
    }

    // Remover professor
    public boolean remover(int registro) {
        return professores.remove(registro) != null;
    }

    // Listar todos
    public Map<Integer, ProfessorModel> listar() {
        return professores;
    }
}

