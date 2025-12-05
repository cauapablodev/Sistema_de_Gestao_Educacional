package Model.Curso;

public class CursoPresencialModel extends CursoModel {
    private int salaDeAula;

    public CursoPresencialModel() {

    }

    public CursoPresencialModel(int codigo, String nome, int cargaHoraria, int salaDeAula) {
        super(codigo, nome, cargaHoraria);
        this.salaDeAula = salaDeAula;
    }

    public int getSalaDeAula() {
        return salaDeAula;
    }

    public void setSalaDeAula(int salaDeAula) {
        this.salaDeAula = salaDeAula;
    }
}
