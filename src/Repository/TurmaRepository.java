package Repository;

import Model.AlunoModel;
import Model.TurmaModel;
import java.util.*;

public class TurmaRepository {

    private Map<Integer, TurmaModel> turmas = new HashMap<>();
    private Map<Integer, List<AlunoModel>> alunosPorTurma = new HashMap<>();

    // Salvar turma
    public void salvar(TurmaModel turma) {
        turmas.put(turma.getCodigo(), turma);
        alunosPorTurma.put(turma.getCodigo(), new ArrayList<>());
    }

    public TurmaModel buscar(int codigo) {
        return turmas.get(codigo);
    }

    public List<AlunoModel> getAlunos(int codigoTurma) {
        return alunosPorTurma.get(codigoTurma);
    }

    public void adicionarAluno(int codigoTurma, AlunoModel aluno) {
        alunosPorTurma.get(codigoTurma).add(aluno);
    }

    public void removerAluno(int codigoTurma, int matricula) {
        alunosPorTurma.get(codigoTurma)
                .removeIf(a -> a.getMatricula() == matricula);
    }
}
