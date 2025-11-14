public class CursoPresencial extends Curso{
    private int salaDeAula;

    public CursoPresencial() {

    }

    public CursoPresencial(int codigo, String nome, int cargaHoraria, int salaDeAula) {
        super(codigo, nome, cargaHoraria);
        this.salaDeAula = salaDeAula;
    }

    public int getSalaDeAula() {
        return salaDeAula;
    }

    public void setSalaDeAula(int salaDeAula) {
        this.salaDeAula = salaDeAula;
    }
    //sobrescreve o metodo detalharCurso da classe Curso
    @Override
    public void detalharCurso() {
        super.detalharCurso();
        System.out.println("Sala de Aula: " + salaDeAula);
    }
}
