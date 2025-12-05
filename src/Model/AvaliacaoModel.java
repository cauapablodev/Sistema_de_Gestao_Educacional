package Model;

public class AvaliacaoModel {
    private double nota;
    private String descricao;

    public AvaliacaoModel() {

    }

    public AvaliacaoModel(String descricao, double nota) {
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

    // Adicionado: permite atribuir nota com validação e retorna true se for bem-sucedido
    public boolean setNota(double nota) {
        if (nota < 0.0 || nota > 10.0) {
            System.out.println("Nota inválida: " + nota + ". Deve estar entre 0 e 10.");
            return false;
        }
        this.nota = nota;
        return true;
    }

}
