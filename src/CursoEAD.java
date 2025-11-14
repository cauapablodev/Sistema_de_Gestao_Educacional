public class CursoEAD extends Curso{
    private String plataforma;

    public CursoEAD() {

    }

    public CursoEAD(int codigo, String nome, int cargaHoraria, String plataforma) {
        super(codigo, nome, cargaHoraria);
        this.plataforma = plataforma;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }
    //sobrescreve o metodo detalharCurso da classe Curso
    @Override
    public void detalharCurso() {
        super.detalharCurso();
        System.out.println("Plataforma: " + plataforma);
    }
}
