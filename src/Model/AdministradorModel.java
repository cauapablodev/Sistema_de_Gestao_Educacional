package Model;

public class AdministradorModel extends UsuarioModel {
    public AdministradorModel() {

    }


    public AdministradorModel(String login, String senha) {
        super(login, senha);
    }

    public boolean autenticar(String usuario, String senha) {
        return this.login.equals(usuario) && this.senha.equals(senha);
    }
}
