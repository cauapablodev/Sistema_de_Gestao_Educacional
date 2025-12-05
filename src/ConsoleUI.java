import Model.*;
import Model.Curso.CursoModel;
import Repository.*;
import Service.*;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class ConsoleUI {
    private Scanner sc;
    private AlunoRepository alunoRepo;
    private ProfessorRepository professorRepo;
    private TurmaRepository turmaRepo;

    private AlunoService alunoService;
    private ProfessorService professorService;
    private TurmaService turmaService;
    private CursoService cursoService;

    private Map<Integer, CursoModel> cursos;

    private AdministradorModel admin;

    public ConsoleUI() {
        // Inicialização
        sc = new Scanner(System.in);
        alunoRepo = new AlunoRepository();
        professorRepo = new ProfessorRepository();
        turmaRepo = new TurmaRepository();

        alunoService = new AlunoService(alunoRepo);
        professorService = new ProfessorService(professorRepo);
        turmaService = new TurmaService(turmaRepo);
        cursoService = new CursoService();

        cursos = new HashMap<>();

        // Usuário administrador padrão
        admin = new AdministradorModel("admin", "admin123");
    }

    public void run() {
        int opcao = -1;
        do {
            System.out.println("\n=== Sistema de Gestão Educacional ===");
            System.out.println("1. Autenticar");
            System.out.println("2. Alunos");
            System.out.println("3. Professores");
            System.out.println("4. Cursos");
            System.out.println("5. Turmas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = readInt();

            switch (opcao) {
                case 1:
                    autenticar();
                    break;
                case 2:
                    menuAlunos();
                    break;
                case 3:
                    menuProfessores();
                    break;
                case 4:
                    menuCursos();
                    break;
                case 5:
                    menuTurmas();
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (opcao != 0);

        sc.close();
    }

    private void autenticar() {
        System.out.print("Login: ");
        String login = sc.next();
        System.out.print("Senha: ");
        String senha = sc.next();

        // Checa admin
        if (admin.autenticar(login, senha)) {
            System.out.println("Autenticado como administrador");
            return;
        }

        // Checa alunos
        boolean ok = false;
        for (AlunoModel a : alunoRepo.listar().values()) {
            if (a.autenticar(login, senha)) {
                System.out.println("Autenticado como aluno: " + a.getNome());
                ok = true;
                break;
            }
        }

        if (ok) return;

        // Checa professores
        for (ProfessorModel p : professorRepo.listar().values()) {
            if (p.autenticar(login, senha)) {
                System.out.println("Autenticado como professor: " + p.getNome());
                ok = true;
                break;
            }
        }

        if (!ok) System.out.println("Credenciais inválidas");
    }

    private void menuAlunos() {
        int opcao;
        do {
            System.out.println("\n--- Alunos ---");
            System.out.println("1. Criar aluno");
            System.out.println("2. Listar alunos");
            System.out.println("3. Buscar aluno por matrícula");
            System.out.println("4. Remover aluno");
            System.out.println("5. Adicionar avaliação ao aluno");
            System.out.println("6. Atribuir nota");
            System.out.println("7. Gerar relatório do aluno");
            System.out.println("0. Voltar");
            System.out.print("Escolha: ");
            opcao = readInt();

            switch (opcao) {
                case 1:
                    criarAluno();
                    break;
                case 2:
                    alunoService.listarAlunos();
                    break;
                case 3:
                    buscarAluno();
                    break;
                case 4:
                    removerAluno();
                    break;
                case 5:
                    adicionarAvaliacaoAluno();
                    break;
                case 6:
                    atribuirNotaAluno();
                    break;
                case 7:
                    gerarRelatorioAluno();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida");
            }

        } while (opcao != 0);
    }

    private void criarAluno() {
        System.out.print("Login: ");
        String login = sc.next();
        System.out.print("Senha: ");
        String senha = sc.next();
        sc.nextLine();
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Matrícula: ");
        int matricula = readInt();
        sc.nextLine();
        System.out.print("Curso: ");
        String curso = sc.nextLine();

        AlunoModel aluno = new AlunoModel(login, senha, nome, matricula, curso);
        alunoService.criarAluno(aluno);
        System.out.println("Aluno criado.");
    }

    private void buscarAluno() {
        System.out.print("Matrícula: ");
        int matricula = readInt();
        AlunoModel a = alunoService.buscarAluno(matricula);
        if (a == null) System.out.println("Aluno não encontrado");
        else System.out.println("Encontrado: " + a.getNome());
    }

    private void removerAluno() {
        System.out.print("Matrícula: ");
        int matricula = readInt();
        boolean removed = alunoService.removerAluno(matricula);
        System.out.println(removed ? "Removido." : "Aluno não encontrado.");
    }

    private void adicionarAvaliacaoAluno() {
        System.out.print("Matrícula: ");
        int matricula = readInt();
        sc.nextLine();
        System.out.print("Descrição da avaliação: ");
        String desc = sc.nextLine();

        AlunoModel a = alunoService.buscarAluno(matricula);
        if (a == null) {
            System.out.println("Aluno não encontrado");
            return;
        }
        AvaliacaoModel av = new AvaliacaoModel(desc, 0.0);
        a.adicionarAvaliacao(av);
        System.out.println("Avaliação adicionada ao aluno.");
    }

    private void atribuirNotaAluno() {
        System.out.print("Matrícula: ");
        int matricula = readInt();
        sc.nextLine();
        System.out.print("Descrição da avaliação: ");
        String desc = sc.nextLine();
        System.out.print("Nota: ");
        double nota = readDouble();

        AlunoModel a = alunoService.buscarAluno(matricula);
        if (a == null) {
            System.out.println("Aluno não encontrado");
            return;
        }
        boolean sucesso = a.atribuirNota(desc, nota);
        System.out.println(sucesso ? "Nota atribuída." : "Falha ao atribuir nota.");
    }

    private void gerarRelatorioAluno() {
        System.out.print("Matrícula: ");
        int matricula = readInt();
        AlunoModel a = alunoService.buscarAluno(matricula);
        if (a == null) System.out.println("Aluno não encontrado");
        else a.gerarRelatorio();
    }

    private void menuProfessores() {
        int opcao;
        do {
            System.out.println("\n--- Professores ---");
            System.out.println("1. Criar professor");
            System.out.println("2. Listar professores");
            System.out.println("3. Buscar professor por registro");
            System.out.println("4. Remover professor");
            System.out.println("5. Gerar relatório do professor");
            System.out.println("0. Voltar");
            System.out.print("Escolha: ");
            opcao = readInt();

            switch (opcao) {
                case 1:
                    criarProfessor();
                    break;
                case 2:
                    professorService.listarProfessores();
                    break;
                case 3:
                    buscarProfessor();
                    break;
                case 4:
                    removerProfessor();
                    break;
                case 5:
                    gerarRelatorioProfessor();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (opcao != 0);
    }

    private void criarProfessor() {
        System.out.print("Login: ");
        String login = sc.next();
        System.out.print("Senha: ");
        String senha = sc.next();
        sc.nextLine();
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Especialidade: ");
        String esp = sc.nextLine();
        System.out.print("Registro (int): ");
        int reg = readInt();

        ProfessorModel p = new ProfessorModel(login, senha, nome, esp, reg);
        professorService.criarProfessor(p);
        System.out.println("Professor criado.");
    }

    private void buscarProfessor() {
        System.out.print("Registro: ");
        int reg = readInt();
        ProfessorModel p = professorService.buscarProfessor(reg);
        if (p == null) System.out.println("Professor não encontrado");
        else System.out.println("Encontrado: " + p.getNome());
    }

    private void removerProfessor() {
        System.out.print("Registro: ");
        int reg = readInt();
        boolean removed = professorService.removerProfessor(reg);
        System.out.println(removed ? "Removido." : "Professor não encontrado.");
    }

    private void gerarRelatorioProfessor() {
        System.out.print("Registro: ");
        int reg = readInt();
        ProfessorModel p = professorService.buscarProfessor(reg);
        if (p == null) System.out.println("Professor não encontrado");
        else p.gerarRelatorio();
    }

    private void menuCursos() {
        int opcao;
        do {
            System.out.println("\n--- Cursos ---");
            System.out.println("1. Criar curso");
            System.out.println("2. Listar cursos");
            System.out.println("3. Gerar relatório do curso");
            System.out.println("0. Voltar");
            System.out.print("Escolha: ");
            opcao = readInt();

            switch (opcao) {
                case 1:
                    criarCurso();
                    break;
                case 2:
                    listarCursos();
                    break;
                case 3:
                    gerarRelatorioCurso();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (opcao != 0);
    }

    private void criarCurso() {
        System.out.print("Código: ");
        int codigo = readInt();
        sc.nextLine();
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Carga horária (int): ");
        int ch = readInt();

        CursoModel c = new CursoModel(codigo, nome, ch);
        cursos.put(codigo, c);
        System.out.println("Curso criado.");
    }

    private void listarCursos() {
        if (cursos.isEmpty()) {
            System.out.println("Nenhum curso cadastrado.");
            return;
        }
        for (CursoModel c : cursos.values()) {
            System.out.println("Código: " + c.getCodigo() + " | Nome: " + c.getNome() + " | CH: " + c.getCargaHoraria());
        }
    }

    private void gerarRelatorioCurso() {
        System.out.print("Código do curso: ");
        int codigo = readInt();
        CursoModel c = cursos.get(codigo);
        if (c == null) System.out.println("Curso não encontrado");
        else cursoService.gerarRelatorio(c);
    }

    private void menuTurmas() {
        int opcao;
        do {
            System.out.println("\n--- Turmas ---");
            System.out.println("1. Criar turma");
            System.out.println("2. Listar alunos da turma");
            System.out.println("3. Adicionar aluno à turma");
            System.out.println("4. Associar avaliação a aluno da turma");
            System.out.println("0. Voltar");
            System.out.print("Escolha: ");
            opcao = readInt();

            switch (opcao) {
                case 1:
                    criarTurma();
                    break;
                case 2:
                    listarAlunosTurma();
                    break;
                case 3:
                    adicionarAlunoTurma();
                    break;
                case 4:
                    associarAvaliacaoTurma();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (opcao != 0);
    }

    private void criarTurma() {
        System.out.print("Código da turma: ");
        int codigo = readInt();
        sc.nextLine();
        System.out.print("Nome do professor: ");
        String professor = sc.nextLine();
        System.out.print("Curso: ");
        String curso = sc.nextLine();

        TurmaModel t = turmaService.criarTurma(codigo, professor, curso);
        System.out.println("Turma criada: " + t.getCodigo());
    }

    private void listarAlunosTurma() {
        System.out.print("Código da turma: ");
        int codigo = readInt();
        TurmaModel t = turmaRepo.buscar(codigo);
        if (t == null) {
            System.out.println("Turma não encontrada");
            return;
        }
        turmaService.listarAlunos(t);
    }

    private void adicionarAlunoTurma() {
        System.out.print("Código da turma: ");
        int codigo = readInt();
        System.out.print("Matrícula do aluno: ");
        int matricula = readInt();

        TurmaModel t = turmaRepo.buscar(codigo);
        AlunoModel a = alunoRepo.buscar(matricula);
        if (t == null || a == null) {
            System.out.println("Turma ou aluno não encontrado");
            return;
        }
        boolean added = turmaService.adicionarAluno(t, a);
        System.out.println(added ? "Aluno adicionado à turma." : "Falha ao adicionar.");
    }

    private void associarAvaliacaoTurma() {
        System.out.print("Código da turma: ");
        int codigo = readInt();
        System.out.print("Matrícula do aluno: ");
        int matricula = readInt();
        sc.nextLine();
        System.out.print("Descrição da avaliação: ");
        String desc = sc.nextLine();

        TurmaModel t = turmaRepo.buscar(codigo);
        if (t == null) {
            System.out.println("Turma não encontrada");
            return;
        }
        AvaliacaoModel av = new AvaliacaoModel(desc, 0.0);
        boolean sucesso = turmaService.associarAvaliacao(t, matricula, av);
        System.out.println(sucesso ? "Avaliação associada." : "Falha ao associar avaliação.");
    }

    // Helpers
    private int readInt() {
        while (!sc.hasNextInt()) {
            sc.next();
            System.out.print("Insira um número válido: ");
        }
        return sc.nextInt();
    }

    private double readDouble() {
        while (!sc.hasNextDouble()) {
            sc.next();
            System.out.print("Insira um número válido: ");
        }
        return sc.nextDouble();
    }
}

