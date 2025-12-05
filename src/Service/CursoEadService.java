package Service;

import Model.Curso.CursoEadModel;

public class CursoEadService extends CursoService{
    public void detalharCursoEAD(CursoEadModel curso) {
        super.detalharCurso(curso);
        System.out.println("Plataforma: " + curso.getPlataforma());
    }
}

