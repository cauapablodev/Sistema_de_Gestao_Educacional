package Service;

import Model.AlunoModel;
import Model.AvaliacaoModel;
import Model.TurmaModel;
import Repository.TurmaRepository;

public class TurmaService {

    private TurmaRepository repository;

    public TurmaService(TurmaRepository repository) {
        this.repository = repository;
    }

    // Criar turma
    public TurmaModel criarTurma(int codigo, String professor, String curso) {
        TurmaModel turma = new TurmaModel(codigo, professor, curso);
        repository.salvar(turma);
        return turma;
    }

    // Adicionar aluno à turma
    public boolean adicionarAluno(TurmaModel turma, AlunoModel aluno) {
        return turma.getAlunos().add(aluno);
    }

    // Remover aluno
    public boolean removerAluno(TurmaModel turma, int matricula) {
        return turma.getAlunos().removeIf(a -> a.getMatricula() == matricula);
    }

    // Listar alunos
    public void listarAlunos(TurmaModel turma) {
        System.out.println("Alunos da Turma " + turma.getCodigo() + ":");
        turma.getAlunos().forEach(a ->
                System.out.println(a.getNome() + " (Matrícula: " + a.getMatricula() + ")")
        );
    }

    // Associar avaliação
    public boolean associarAvaliacao(TurmaModel turma, int matricula, AvaliacaoModel avaliacao) {
        for (AlunoModel aluno : turma.getAlunos()) {
            if (aluno.getMatricula() == matricula) {
                aluno.adicionarAvaliacao(avaliacao);
                return true;
            }
        }
        return false;
    }

    // Resumo
    public void resumo(TurmaModel turma) {
        System.out.println("Turma: " + turma.getCodigo());
        System.out.println("Professor: " + turma.getProfessor());
        System.out.println("Curso: " + turma.getCurso());
        System.out.println("Qtd Alunos: " + turma.getAlunos().size());
    }
}
