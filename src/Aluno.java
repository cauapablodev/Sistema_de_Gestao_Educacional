import java.util.HashMap;
import java.util.Map;

public class Aluno {
    private String nome;
    private int matricula;
    private String curso;
    //utilizando o Map para facilitar a criacao e deletar alunos por ID "Matricula"
    private Map<String, Aluno> alunoMap = new HashMap<>();

    public Aluno() {

    }

    public Aluno(String nome, int matricula, String curso) {
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
    }

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

    public Map<String, Aluno> getAlunoMap() {
        return alunoMap;
    }

    public void setAlunoMap(Map<String, Aluno> alunoMap) {
        this.alunoMap = alunoMap;
    }

    //metodo para criar alunos
    public Aluno criarAluno (String nome, int matricula, String curso) {
        Aluno aluno = new Aluno(nome, matricula, curso);
        alunoMap.put(String.valueOf(matricula), aluno);
        return aluno;
    }

    //metodo para deletar alunos
    public void deletarAluno (int matricula) {
        alunoMap.remove(String.valueOf(matricula));
    }
}

