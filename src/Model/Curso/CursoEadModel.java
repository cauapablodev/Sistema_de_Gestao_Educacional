package Model.Curso;

public class CursoEadModel extends CursoModel {
    private String plataforma;

    public CursoEadModel() {

    }

    public CursoEadModel(int codigo, String nome, int cargaHoraria, String plataforma) {
        super(codigo, nome, cargaHoraria);
        this.plataforma = plataforma;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }
}
