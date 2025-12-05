package Model;

import java.util.ArrayList;
import java.util.List;

public class TurmaModel {

    private int codigo;
    private String professor;
    private String curso;

    // A lista DEVE ficar no model
    private List<AlunoModel> alunos = new ArrayList<>();

    public TurmaModel(int codigo, String professor, String curso) {
        this.codigo = codigo;
        this.professor = professor;
        this.curso = curso;
    }

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getProfessor() {
        return professor;
    }
    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }

    // GET e SET da lista DE ALUNOS
    public List<AlunoModel> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<AlunoModel> alunos) {
        this.alunos = alunos;
    }
}