package Repository;
import Model.AlunoModel;
import java.util.HashMap;
import java.util.Map;

public class AlunoRepository {

    private Map<Integer, AlunoModel> alunos = new HashMap<>();

    // Criar aluno no repositório
    public void salvar(AlunoModel aluno) {
        alunos.put(aluno.getMatricula(), aluno);
    }

    // Buscar aluno por matrícula
    public AlunoModel buscar(int matricula) {
        return alunos.get(matricula);
    }

    // Remover aluno
    public boolean remover(int matricula) {
        return alunos.remove(matricula) != null;
    }

    // Listar todos
    public Map<Integer, AlunoModel> listar() {
        return alunos;
    }
}
