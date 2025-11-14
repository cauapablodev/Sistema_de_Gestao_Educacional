
import java.util.ArrayList;
import java.util.List;

public class Turma {
    private int codigo;
    private String professor;
    private String curso;
    private List<Aluno> listaAluno = new ArrayList<>();

    public Turma() {

    }

    public Turma(int codigo, String professor, String curso, List<Aluno> listaAluno) {
        this.codigo = codigo;
        this.professor = professor;
        this.curso = curso;
        this.listaAluno = listaAluno;
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

    public List<Aluno> getListaAluno() {
        return listaAluno;
    }

    public void setListaAluno(List<Aluno> listaAluno) {
        this.listaAluno = listaAluno;
    }

    //metodo para exibir o resumo da turma
    public void resumoDaTurma() {
        System.out.println("Professor: " + professor);
        System.out.println("Curso: " + curso);
        System.out.println("Quantidade de Alunos:");
        for (Aluno aluno : listaAluno) {
            System.out.println(listaAluno.size());
        }

    }
}
