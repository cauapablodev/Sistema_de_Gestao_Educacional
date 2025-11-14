public class Administrador extends Usuario{
    public Administrador() {

    }


    public Administrador(String login, String senha) {
        super(login, senha);
    }

    @Override
    public boolean autenticar(String usuario, String senha) {
        return this.login.equals(usuario) && this.senha.equals(senha);
    }
}
