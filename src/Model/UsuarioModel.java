package Model;

import Service.AutenticacaoService;

public abstract class UsuarioModel implements AutenticacaoService {
    protected String login;
    protected String senha;

    public UsuarioModel() {

    }

    public UsuarioModel(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
