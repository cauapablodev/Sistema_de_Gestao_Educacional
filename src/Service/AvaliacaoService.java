package Service;

public class AvaliacaoService {

    public boolean atribuirNota(double nota) {

        if (nota < 0 || nota > 10) {
            System.out.println("Nota invalida. A nota deve estar entre 0 e 10.");
            return false;
        }
        System.out.println("Nota atribuida com sucesso: " + nota);
        return true;
    }
}
