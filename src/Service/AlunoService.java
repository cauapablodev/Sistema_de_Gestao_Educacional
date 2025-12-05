package Service;

import Repository.AlunoRepository;
import Model.AlunoModel;

public class AlunoService {

    private AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    // Criar aluno e salvar
    public void criarAluno(AlunoModel aluno) {
        repository.salvar(aluno);
    }

    // Buscar aluno por matrícula
    public AlunoModel buscarAluno(int matricula) {
        return repository.buscar(matricula);
    }

    // Remover aluno
    public boolean removerAluno(int matricula) {
        return repository.remover(matricula);
    }

    // Listar todos os alunos
    public void listarAlunos() {
        for (AlunoModel aluno : repository.listar().values()) {
            System.out.println("Matrícula: " + aluno.getMatricula() +
                    " | Nome: " + aluno.getNome() +
                    " | Model.Curso.Curso: " + aluno.getCurso());
        }
    }

}
