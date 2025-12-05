package Model;

import java.util.HashMap;
import java.util.Map;

public class AlunoModel extends UsuarioModel {

    private String nome;
    private int matricula;
    private String curso;

    // Map de avaliações do aluno (essa parte é OK no model)
    private Map<String, AvaliacaoModel> avaliacoes = new HashMap<>();

    public AlunoModel() {}

    public AlunoModel(String nome, int matricula, String curso) {
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
    }

    // Construtor com login e senha herdados
    public AlunoModel(String login, String senha, String nome, int matricula, String curso) {
        super(login, senha);
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Map<String, AvaliacaoModel> getAvaliacoes() {
        return avaliacoes;
    }

    // Lógica interna do aluno → OK
    public void adicionarAvaliacao(AvaliacaoModel avaliacao) {
        avaliacoes.put(avaliacao.getDescricao(), avaliacao);
    }

    public boolean atribuirNota(String descricao, double nota) {
        AvaliacaoModel avaliacao = avaliacoes.get(descricao);
        if (avaliacao == null) {
            System.out.println("Avaliação não encontrada para o aluno " + nome);
            return false;
        }
        return avaliacao.setNota(nota);
    }

    @Override
    public boolean autenticar(String login, String senha) {
        return this.login.equals(login) && this.senha.equals(senha);
    }

    public void gerarRelatorio() {
        System.out.println("Relatório do Aluno: " + nome);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Curso: " + curso);
        System.out.println("Avaliações:");

        for (AvaliacaoModel avaliacao : avaliacoes.values()) {
            System.out.println(
                    "Descrição: " + avaliacao.getDescricao() +
                            " - Nota: " + avaliacao.getNota()
            );
        }
    }
}

