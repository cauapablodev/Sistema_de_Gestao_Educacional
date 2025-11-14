public class Curso {
    private String nome;
    private int codigo;
    private int cargaHoraria;

    public Curso() {

    }

    public Curso(int codigo, String nome, int cargaHoraria) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public void detalharCurso() {
        System.out.println("Codigo do Curso: " + codigo);
        System.out.println("Nome do Curso: " + nome);
        System.out.println("Carga Horaria: " + cargaHoraria + " horas");
    }
}
