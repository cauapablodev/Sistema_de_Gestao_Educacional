package Service;

import Model.ProfessorModel;
import Model.UsuarioModel;
import Repository.ProfessorRepository;

public class ProfessorService extends UsuarioModel {

        private ProfessorRepository repository;

        public ProfessorService(ProfessorRepository repository) {
            this.repository = repository;
        }

        // Criar professor
        public void criarProfessor(ProfessorModel professor) {
            repository.salvar(professor);
        }

        // Buscar professor por registro
        public ProfessorModel buscarProfessor(int registro) {
            return repository.buscar(registro);
        }

        // Remover professor
        public boolean removerProfessor(int registro) {
            return repository.remover(registro);
        }

        // Listar professores
        public void listarProfessores() {
            for (ProfessorModel professor : repository.listar().values()) {
                System.out.println(
                        "Registro: " + professor.getRegistro() +
                                " | Nome: " + professor.getNome() +
                                " | Especialidade: " + professor.getEspecialidade()
                );
            }
        }
        // Autenticar professor

    @Override
    public boolean autenticar(String usuario, String senha) {
        return this.login.equals(usuario) && this.senha.equals(senha);
    }
    }

