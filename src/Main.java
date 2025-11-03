import Aluno.Aluno;
import Curso.Curso;
import Professor.Professor;

void main() {
    // criar aluno
    Aluno aluno = new Aluno();
    aluno.nome = "Caua";
    aluno.curso = "Analise e Desenvolvimento de Sistemas";
    aluno.matricula = 12345;

    System.out.println("Aluno: " + aluno.nome);
    System.out.println("Curso: " + aluno.curso);
    System.out.println("Matricula: " + aluno.matricula);

    //curso

    Curso curso = new Curso();
    curso.nome = "Analise e Desenvolvimento de Sistemas";
    curso.codigo = 54321;
    curso.cargaHoraria = 40;

    System.out.println("Curso: " + curso.nome);
    System.out.println("Codigo: " + curso.codigo);
    System.out.println("CargaHoraria" + curso.cargaHoraria);
    //professor

    Professor professor = new Professor();
    professor.nome = "Cleber";
    professor.especialidade = "Desenvolvimento de Software";
    professor.registro = 1231;

    System.out.println("Professor: " + professor.nome);
    System.out.println("Especialidade: " + professor.especialidade);
    System.out.println("Registro: " + professor.registro);
}
