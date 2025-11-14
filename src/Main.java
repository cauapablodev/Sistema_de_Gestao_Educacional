void main() {

    Usuario aluno = new Aluno();
    aluno.login = "aluno1";
    aluno.senha = "senhaAluno";
    Usuario professor = new Professor("professor1", "senha123", "Dr. Carlos", "Matemática", 5678);
    Usuario administrador = new Administrador("admin123", "admin12345");

    System.out.println(aluno.autenticar("João Silva", "senhaAluno")); // false
    System.out.println(professor.autenticar("professor1", "senha123")); // true
    System.out.println(administrador.autenticar("admin123", "admin12345")); // true





}
