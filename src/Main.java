void main() {

    Usuario aluno = new Aluno();
    aluno.login = "aluno1";
    aluno.senha = "senhaAluno";
    Aluno aluno1 = new Aluno("João Silva", 1234, "Ciência da Computação");
    Usuario professor = new Professor("professor1", "senha123", "Dr. Carlos", "Matemática", 5678);
    Usuario administrador = new Administrador("admin123", "admin12345");

    //criando curso

    Curso curso = new Curso(101, "Engenharia de Software", 360);


    System.out.println(aluno.autenticar("João Silva", "senhaAluno")); // false
    System.out.println(professor.autenticar("professor1", "senha123")); // true
    System.out.println(administrador.autenticar("admin123", "admin12345")); // true

    //Menu Relatorios

    Scanner sc = new Scanner(System.in);
    int opcao;

    do {
        System.out.println("Menu de Relatórios:");
        System.out.println("1. Relatório do Aluno");
        System.out.println("2. Relatório do Professor");
        System.out.println("3. Relatório do Curso");
        System.out.println("4. Sair");
        System.out.print("Escolha uma opção: ");
        opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                ((Aluno) aluno1).gerarRelatorio();
                break;
            case 2:
                ((Professor) professor).gerarRelatorio();
                break;
            case 3:
                ((Curso) curso).gerarRelatorio();
                break;
            case 4:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }while (opcao != 0);

}
