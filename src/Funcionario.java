import java.sql.Date;

public class Funcionario extends Pessoa {
    private int matricula;
    private Date horarioTrabalho;

    public Funcionario(String cpf, String nome, String email, Date horario) {
        super(cpf, nome, email);
        this.horarioTrabalho = horario;
    }

    public int getMatricula() {
        return this.matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public Date getHorarioTrabalho() {
        return this.horarioTrabalho;
    }

    public void setHorarioTrabalho(Date horario) {
        this.horarioTrabalho = horario;
    }
}
