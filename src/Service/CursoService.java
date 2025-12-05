package Service;

import Model.Curso.CursoModel;

public class CursoService {
    // Método para gerar relatório do curso
    public void gerarRelatorio(CursoModel curso) {
        System.out.println("Relatório do Curso:");
        System.out.println("Código: " + curso.getCodigo());
        System.out.println("Nome: " + curso.getNome());
        System.out.println("Carga Horária: " + curso.getCargaHoraria() + " horas");
    }

    // Método para detalhar informações do curso
    public void detalharCurso(CursoModel curso) {
        System.out.println("Código do Curso: " + curso.getCodigo());
        System.out.println("Nome do Curso: " + curso.getNome());
        System.out.println("Carga Horária: " + curso.getCargaHoraria() + " horas");
    }
}
