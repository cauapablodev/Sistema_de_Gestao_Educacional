package Model;

public class ProfessorModel extends UsuarioModel {
    private String nome;
    private String especialidade;
    private int registro;

    public ProfessorModel() {
        
    }

    public ProfessorModel(String nome, String especialidade, int registro) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.registro = registro;
    }

    public ProfessorModel(String login, String senha, String nome, String especialidade, int registro) {
        super(login, senha);
        this.nome = nome;
        this.especialidade = especialidade;
        this.registro = registro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }

    @Override
    public boolean autenticar(String usuario, String senha) {
        return this.login != null && this.senha != null && this.login.equals(usuario) && this.senha.equals(senha);
    }

    public void gerarRelatorio() {
        System.out.println("Relatório do Professor: " + nome);
        System.out.println("Especialidade: " + especialidade);
        System.out.println("Registro: " + registro);
    }


}