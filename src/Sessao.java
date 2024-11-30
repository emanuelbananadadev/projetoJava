import java.time.format.DateTimeFormatter;

public class Sessao {
    private int idSessao;
    private DateTimeFormatter dataHoraSessao;
    private Filme filme;
    private Sala sala;
    private Funcionario funcionario;
    private String status;

    public Sessao(DateTimeFormatter dataHoraSessao, Filme filme, Sala sala, Funcionario funcionario) {
        this.dataHoraSessao = dataHoraSessao;
        this.filme = filme;
        this.sala = sala;
        this.funcionario = funcionario;
        this.status = "Ativo";
    }

    public int getIdSessao() {
        return this.idSessao;
    }

    public void setIdSessao(int id) {
        this.idSessao = id;
    }

    public DateTimeFormatter getData() {
        return this.dataHoraSessao;
    }

    public void setData(DateTimeFormatter data) {
        this.dataHoraSessao = data;
    }

    public Filme getFilme() {
        return this.filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Sala getSala() {
        return this.sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Funcionario getFuncionario() {
        return this.funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
 
}
