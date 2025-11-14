void main() {

    Aluno aluno = new Aluno();
    aluno.criarAluno("Maria", 12345, "Engenharia");
    aluno.criarAluno("João", 67890, "Engenharia");
    aluno.criarAluno("Ana", 11223, "Engenharia");

    aluno.deletarAluno(12345);

    Turma turma = new Turma();
    turma.setProfessor("Dr. Silva");
    turma.setCurso("Engenharia");
    turma.resumoDaTurma();
    turma.associarAvaliacaoAluno(11223, new Avaliacao("Prova Engenharia", 0 ) );
    aluno.atribuirNota("Prova Engenharia", 8.5);

    Professor professor = new Professor("Dr. Silva", "Engenharia", 98765);
    System.out.println("Professor: " + professor.getNome() + ", Especialidade: " + professor.getEspecialidade() + ", Registro: " + professor.getRegistro());

    Curso curso = new Curso(101, "Engenharia", 1200);
    System.out.println("Curso: " + curso.getNome() + ", Codigo: " + curso.getCodigo() + ", Carga Horaria: " + curso.getCargaHoraria() + " horas");






}
