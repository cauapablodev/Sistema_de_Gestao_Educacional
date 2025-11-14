void main() {
    // criar aluno
    Aluno aluno1 = new Aluno();
    aluno1 = aluno1.criarAluno("João Silva", 12345, "Engenharia");
    System.out.println("Aluno criado: " + aluno1.getNome() + ", Matrícula: " + aluno1.getMatricula() + ", Curso: " + aluno1.getCurso());

    Turma turma1 = new Turma();
    turma1.setProfessor("Dr. Carlos");
    turma1.setCurso("Engenharia");
    turma1.getListaAluno().add(aluno1);
    turma1.resumoDaTurma();
}
