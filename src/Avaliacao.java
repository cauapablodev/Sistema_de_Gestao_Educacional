public class Avaliacao {
    private double nota;
    private String descricao;

    public Avaliacao() {

    }

    public Avaliacao(String descricao, double nota) {
        this.nota = nota;
        this.descricao = descricao;
    }

    public double getNota() {
        return nota;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }



    //atribuir nota a avaliacao
    public boolean atribuirNota(double nota) {

        if (nota < 0 || nota > 10) {
            System.out.println("Nota invalida. A nota deve estar entre 0 e 10.");
            return false;
        }
        this.nota = nota;
        return true;
    }


}
