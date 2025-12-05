package Service;

import Model.Curso.CursoPresencialModel;

public class CursoPresencialService extends CursoService {

    public void detalharCursoPresencial(CursoPresencialModel curso) {
        super.detalharCurso(curso);
        System.out.println("Sala de Aula: " + curso.getSalaDeAula());
    }
}

